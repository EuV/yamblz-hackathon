package ru.yandex.yamblz.euv.hackathon.db;

import android.provider.BaseColumns;

public class WordsContract {
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + Words.TABLE_NAME + " (" +
                    Words._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Words.WORD + " TEXT UNIQUE," +
                    Words.LANG_ID + " INTEGER NOT NULL," +
                    Words.PROGRESS + " INTEGER NOT NULL)";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + Words.TABLE_NAME;

    public static abstract class Words implements BaseColumns {
        public static final String TABLE_NAME = "words";

        public static final String WORD = "word";
        public static final String LANG_ID = "lang_id";
        public static final String PROGRESS = "progress";

        public static final String[] PROJECTION = {
                _ID, WORD, LANG_ID, PROGRESS
        };
    }
}
