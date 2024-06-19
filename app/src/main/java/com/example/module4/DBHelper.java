package com.example.pavel2.module4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "myapp.db";
    public static final String MATCHES_ID_COL = "id";
    public static final String MATCHES_TEAM1_COL = "team1";
    public static final String MATCHES_TEAM2_COL = "team2";
    public static final String MATCHES_POINTS1_COL = "points1";
    public static final String MATCHES_POINTS2_COL = "points2";
    public static final int VERSION = 2;
    public static final int MATCHES_ID_NUM= 0;
    public static final int MATCHES_TEAM1_NUM = 1;
    public static final int MATCHES_TEAM2_NUM = 2;
    public static final int MATCHES_POINTS1_NUM= 3;
    public static final int MATCHES_POINTS2_NUM= 4;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE matches (" +
                MATCHES_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MATCHES_TEAM1_COL + " TEXT NOT NULL, " +
                MATCHES_TEAM2_COL + " TEXT NOT NULL, " +
                MATCHES_POINTS1_COL + " INTEGER NOT NULL, " +
                MATCHES_POINTS2_COL + " INTEGER  NOT NULL" +
        ")";
        sqLiteDatabase.execSQL(sql);
}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int v1, int v2) {
        if (v1 != v2) {
            sqLiteDatabase.execSQL("DROP TABLE matches");
            onCreate(sqLiteDatabase);
        }

    }
}
