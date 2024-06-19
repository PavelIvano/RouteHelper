package com.example.pavel2.module4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBMatches {

    DBHelper helper;
    SQLiteDatabase db;
    public DBMatches(Context ctx) {
        helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public long insert(Match match) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.MATCHES_TEAM1_COL, match.getTeam1());
        cv.put(DBHelper.MATCHES_TEAM2_COL, match.getTeam2());
        cv.put(DBHelper.MATCHES_POINTS1_COL, match.getPoints1());
        cv.put(DBHelper.MATCHES_POINTS2_COL, match.getPoints2());
        long id = db.insert("matches", null, cv);
        match.setId((int)id);
        return id;
    }
    public List<Match> selectAll() {
        Cursor cursor = db.query("matches", new String[]{"*"},null, null, null, null, null);
        cursor.moveToFirst();
        ArrayList<Match> list = new ArrayList<>();
        if (!cursor.isAfterLast()) {
            do {
                Match next = new Match();
                next.setId(cursor.getInt(DBHelper.MATCHES_ID_NUM));
                next.setPoints1(cursor.getInt(DBHelper.MATCHES_POINTS1_NUM));
                next.setPoints2(cursor.getInt(DBHelper.MATCHES_POINTS2_NUM));
                next.setTeam1(cursor.getString(DBHelper.MATCHES_TEAM1_NUM));
                next.setTeam2(cursor.getString(DBHelper.MATCHES_TEAM2_NUM));
            } while (cursor.moveToNext());
        }
        return list;
    }
}
