package ru.yandex.yamblz.euv.hackathon.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static final int DATABASE_VERSION = 6;
    static final String DATABASE_NAME = "Yatrainer.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LangContract.SQL_CREATE_TABLE);
        db.execSQL(WordsContract.SQL_CREATE_TABLE);
        db.execSQL(StatisticsContract.SQL_CREATE_TABLE);
        db.execSQL(TranslationContract.SQL_CREATE_TABLE);
        db.execSQL(TranslationTypeContract.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(LangContract.SQL_DROP_TABLE);
        db.execSQL(WordsContract.SQL_DROP_TABLE);
        db.execSQL(StatisticsContract.SQL_DROP_TABLE);
        db.execSQL(TranslationContract.SQL_DROP_TABLE);
        db.execSQL(TranslationTypeContract.SQL_DROP_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
