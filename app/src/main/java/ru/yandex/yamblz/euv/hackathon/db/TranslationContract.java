package ru.yandex.yamblz.euv.hackathon.db;

import android.provider.BaseColumns;

public class TranslationContract {
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + Translation.TABLE_NAME + " (" +
                    Translation._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Translation.FROM_WORD_ID + " INTEGER NOT NULL," +
                    Translation.TO_WORD_ID + " INTEGER NOT NULL," +
                    Translation.TRANSLATION_TYPE + " INTEGER NOT NULL," +
                    Translation.ACTIVE + " INTEGER NOT NULL)";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + Translation.TABLE_NAME;

    public static abstract class Translation implements BaseColumns {
        public static final String TABLE_NAME = "translation";

        public static final String FROM_WORD_ID = "from_word_id";
        public static final String TO_WORD_ID = "to_word_id";
        public static final String TRANSLATION_TYPE = "translation_type";
        public static final String ACTIVE = "active";

        public static final String[] PROJECTION = {
                _ID, FROM_WORD_ID, TO_WORD_ID, TRANSLATION_TYPE, ACTIVE
        };
    }
}
