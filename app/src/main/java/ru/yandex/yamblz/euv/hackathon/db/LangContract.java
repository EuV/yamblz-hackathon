package ru.yandex.yamblz.euv.hackathon.db;


import android.provider.BaseColumns;

public class LangContract {
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + Lang.TABLE_NAME + " (" +
                    Lang._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Lang.MEMO + " TEXT UNIQUE)";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + Lang.TABLE_NAME;

    public static abstract class Lang implements BaseColumns {
        public static final String TABLE_NAME = "lang";

        public static final String MEMO = "memo"; // 'EN', 'RU', etc.

        public static final String[] PROJECTION = {
                _ID, MEMO
        };
    }
}
