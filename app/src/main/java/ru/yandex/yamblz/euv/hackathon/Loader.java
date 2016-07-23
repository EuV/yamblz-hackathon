package ru.yandex.yamblz.euv.hackathon;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import ru.yandex.yamblz.euv.hackathon.db.DBHelper;
import ru.yandex.yamblz.euv.hackathon.db.WordsContract.Words;
import ru.yandex.yamblz.euv.hackathon.model.Lang;
import ru.yandex.yamblz.euv.hackathon.model.Word;
import ru.yandex.yamblz.euv.hackathon.model.WordsJson;


public final class Loader extends HandlerThread {
    private static final String TAG = Loader.class.getSimpleName();

    private static Loader loaderInstance;

    private OkHttpClient okHttpClient = new OkHttpClient();
    private Handler loaderThreadHandler;
    private WeakReference<LoaderCallback> callbackReference;


    public interface LoaderCallback {
        void trainingWordsLoaded(List<String> from, List<String> to);
    }


    private Loader() {
        super(TAG + "Thread");
        start();
        loaderThreadHandler = new Handler(getLooper());
    }


    public static Loader getInstance() {
        if (loaderInstance == null) {
            loaderInstance = new Loader();
        }
        return loaderInstance;
    }


    public void loadTrainingWords(LoaderCallback callback) {
        final WeakReference<LoaderCallback> callbackReference = new WeakReference<>(callback);
        loaderThreadHandler.post(() -> loadTrainingWordsInBackground(callbackReference));
    }


    public void loadTrainingWordsInBackground(WeakReference<LoaderCallback> callbackReference) {
        LoaderCallback callback = callbackReference.get();
        if (callback == null) return;

        List<String> from = Arrays.asList("дом", "собака", "кот", "машина", "стена", "урон", "мышь", "страдание", "боль", "смерть");
        List<String> to = Arrays.asList("house", "dog", "cat", "car", "wall", "damage", "mouse", "suffering", "pain", "death");
        callback.trainingWordsLoaded(from, to);
    }


    /**
     * Read words from json file, download their translation and save into DB
     */
    public void updateWords() {
        loaderThreadHandler.post(this::updateWordsInBackground);
    }


    private void updateWordsInBackground() {
        WordsJson words = readJson();
        if (words == null) {
            return;
        }

        checkLoadSave(words.getEn(), Lang.EN);
        checkLoadSave(words.getRu(), Lang.RU);
    }


    private void checkLoadSave(List<String> words, Lang lang) {
        SQLiteDatabase dbr = new DBHelper(App.getContext()).getReadableDatabase();
        SQLiteDatabase dbw = new DBHelper(App.getContext()).getWritableDatabase();

        for (String wordStr : words) {
            Word word = loadWord(dbr, wordStr);
            Log.d(TAG, "Loaded from DB word '" + wordStr + "': " + word);

            if (word == null) {
                saveWord(dbw, new Word(-1, wordStr, lang, 0));
            }
        }

        dbr.close();
        dbw.close();
    }


    private Word loadWord(SQLiteDatabase db, String wordStr) {
        Word word = null;
        String selection = Words.WORD + " = '" + wordStr + "'";
        Cursor cursor = db.query(Words.TABLE_NAME, Words.PROJECTION, selection, null, null, null, null);
        try {
            if (!cursor.moveToFirst()) return null;
            int id = getInt(cursor, Words._ID);
            Lang lang = Lang.values()[getInt(cursor, Words.LANG_ID)];
            int progress = getInt(cursor, Words.PROGRESS);
            word = new Word(id, wordStr, lang, progress);
        } finally {
            cursor.close();
        }
        return word;
    }


    private int getInt(Cursor cursor, String column) {
        return cursor.getInt(cursor.getColumnIndexOrThrow(column));
    }


    private String getString(Cursor cursor, String column) {
        return cursor.getString(cursor.getColumnIndexOrThrow(column));
    }


    private void saveWord(SQLiteDatabase db, Word word) {
        ContentValues val = new ContentValues();
        val.put(Words.WORD, word.word);
        val.put(Words.LANG_ID, word.lang.ordinal());
        val.put(Words.PROGRESS, word.progress);

        db.insertWithOnConflict(Words.TABLE_NAME, null, val, SQLiteDatabase.CONFLICT_IGNORE);
    }


    private WordsJson readJson() {
        String wordsStr = null;
        try {
            InputStream is = App.getContext().getResources().openRawResource(R.raw.words);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            wordsStr = new String(buffer);
        } catch (Exception e) {
            Log.d(TAG, Log.getStackTraceString(e));
        }

        if (wordsStr == null) {
            return null;
        }


        WordsJson words = null;
        try {
            words = JSON.parseObject(wordsStr, WordsJson.class);
        } catch (JSONException e) {
            Log.d(TAG, "Failed to parse JSON string", e);
        }

        return words;
    }
}
