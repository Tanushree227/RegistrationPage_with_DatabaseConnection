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

    // below method is for creating a database by running a sqlite query
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

    @SuppressLint("Range")
    public ArrayList<HashMap<String, String>> getUsers()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT userName FROM " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext())
        {
            HashMap<String, String> user = new HashMap<>();
            user.put("userName", cursor.getString(cursor.getColumnIndex(USERNAME)));
            userList.add(user);
        }
        return userList;
    }

    public void DeleteUser(int userId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID_COL+" = ?", new String[]{String.valueOf(userId)});
        db.close();
    }

    public int UpdateUserDetails(String email, String phone, String password, String cnfrm_Password, int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMAIL, email);
        values.put(PHONE, phone);
        values.put(PASSWORD, password);
        values.put(C_PASSWORD, cnfrm_Password);
        int count = db.update(TABLE_NAME,values, ID_COL+ " = ?", new String[]{String.valueOf(id)});
        return count;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}