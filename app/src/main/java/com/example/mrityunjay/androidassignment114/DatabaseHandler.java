package com.example.mrityunjay.androidassignment114;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mrityunjay on 08-06-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String TABLE_WORKER = "worker";
    public static final String ID = "_id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final Integer VERSION = 1;
    private static final String DATABASE_NAME = "mj.db";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String DATABASE_CREATE = "CREATE TABLE if not exists "
                + TABLE_WORKER + " (" + ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FIRST_NAME + " TEXT, " + LAST_NAME + " TEXT);";
        db.execSQL(DATABASE_CREATE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_WORKER);
        onCreate(db);

    }

    public void insertRecord(Employee contact) {
        this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, contact.getName());
        contentValues.put(LAST_NAME, contact.getLast_Name());
        this.getWritableDatabase().insert(TABLE_WORKER, null, contentValues);

    }

    public Employee retrievr() throws SQLException {
        Cursor cur = this.getWritableDatabase().query(true, TABLE_WORKER, new String[]{FIRST_NAME,
                LAST_NAME}, null, null, null, null, null, null);
        if (cur.moveToFirst()) {

            String firstname = cur.getString(cur.getColumnIndex(FIRST_NAME));
            String lastname= cur.getString(cur.getColumnIndex(LAST_NAME));
            cur.close();
            return new Employee(firstname, lastname);
        }
        cur.close();
        return null;


    }
}
