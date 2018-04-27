package com.bintangglenn.tasklist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bintangglenn.tasklist.data.TaskContract.TaskEntry;

public class TaskDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ABSENT.DB";
    public static final int DATABASE_VERSION = 1;

    public static final String SQL_CREATE_ENTRIES = "" +
            "CREATE TABLE " + TaskEntry.TABLE_NAME + "(" +
            TaskEntry._ID + " INTEGER PRIMARY KEY, " +
            TaskEntry.COLUMN_ABSENT_TASK + " TEXT NOT NULL, " +
            TaskEntry.COLUMN_ABSENT_DAY + " INTEGER NOT NULL);";

    public static final String SQL_DELETE_ENTRIES = "" +
            "DROP TABLE IF EXISTS " + TaskEntry.TABLE_NAME + ";";

    public TaskDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
