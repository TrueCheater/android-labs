package com.example.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PasswordStorage.db";
    public static final String TABLE_NAME = "passwords";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_PASSWORD + " TEXT);");
    }

    public void addPassword(String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PASSWORD, password);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public String getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_PASSWORD};
        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
        StringBuilder sb = new StringBuilder();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String password = cursor.getString(1);
            sb.append(id).append(": ").append("\t\t\t").append(password).append("\n");
        }

        cursor.close();

        if (sb.length() == 0) {
            return "no data yet";
        } else {
            return sb.toString();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
