package com.example.program13;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "registrationDB";
   private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "signUp";
    private static final String ID_COL = "id";
    private static final String USERNAME = "userName";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String PASSWORD = "password";
    private static final String C_PASSWORD = "C_password";
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME + " TEXT,"
                + EMAIL + " TEXT,"
                + PHONE + " TEXT,"
                + PASSWORD + " TEXT,"
                + C_PASSWORD + " TEXT)";
        db.execSQL(query);
    }
    public void addNewUser(String username1, String email1, String phone1, String password1, String c_password1) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(USERNAME, username1);
        values.put(EMAIL, email1);
        values.put(PHONE, phone1);
        values.put(PASSWORD, password1);
        values.put(C_PASSWORD, c_password1);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<UserModal> readUsers()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorUser = db.rawQuery("SELECT * FROM " +TABLE_NAME, null);
        ArrayList<UserModal> userModalArrayList = new ArrayList<>();
        if (cursorUser.moveToFirst())
        {
            do {
                userModalArrayList.add(new UserModal(cursorUser.getString(1),
                        cursorUser.getString(2),
                        cursorUser.getString(3),
                        cursorUser.getString(4),
                        cursorUser.getString(5)));
            } while (cursorUser.moveToNext());
        }
        cursorUser.close();
        return userModalArrayList;
    }

    public void DeleteUser(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "name=?", new String[]{username});
        db.close();
    }

    public void UpdateUserDetails(String username, String email, String phone, String password, String cnfrm_Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMAIL, email);
        values.put(PHONE, phone);
        values.put(PASSWORD, password);
        values.put(C_PASSWORD, cnfrm_Password);
        db.update(TABLE_NAME,values, " name=?", new String[]{username});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}