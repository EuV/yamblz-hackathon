package ru.yandex.yamblz.euv.hackathon.db;


import android.provider.BaseColumns;

public class StatisticsContract {
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + Statistics.TABLE_NAME + " (" +
                    Statistics._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    Statistics.DATE + " INTEGER NOT NULL," +
                    Statistics.COUNT + " INTEGER NOT NULL)";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + Statistics.TABLE_NAME;

    public static abstract class Statistics implements BaseColumns {
        public static final String TABLE_NAME = "statistics";

        public static final String DATE = "date";
        public static final String COUNT = "count";

        public static final String[] PROJECTION = {
                _ID, DATE, COUNT
        };
    }
}