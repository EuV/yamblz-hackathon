package ru.yandex.yamblz.euv.hackathon.db;

import android.provider.BaseColumns;

public class TranslationTypeContract {
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TranslationType.TABLE_NAME + " (" +
                    TranslationType._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    TranslationType.FROM_LANG + " INTEGER NOT NULL," +
                    TranslationType.TO_LANG + " INTEGER NOT NULL," +
                    TranslationType.ACTIVE + " INTEGER NOT NULL)";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + TranslationType.TABLE_NAME;

    public static abstract class TranslationType implements BaseColumns {
        public static final String TABLE_NAME = "translation_type";

        public static final String FROM_LANG = "from_lang";
        public static final String TO_LANG = "to_lang";
        public static final String ACTIVE = "active";

        public static final String[] PROJECTION = {
                _ID, FROM_LANG, TO_LANG, ACTIVE
        };
    }
}
