package com.example.evitected.labfinalexam.DatabaseClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Evitected on 30/11/2559.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DbRegister.db";

    public DatabaseHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
        SQLiteDatabase db = this.getWritableDatabase(); //checking
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE tbRegister " +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name VARCHAR," +
                "email VARCHAR," +
                "phone VARCHAR," +
                "type VARCHAR)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_1");
        onCreate(sqLiteDatabase);
    }
    public boolean insertRegist(String name, String email, String phone, String type){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues myValue = new ContentValues();
        myValue.put("name", name);
        myValue.put("email", email);
        myValue.put("phone", phone);
        myValue.put("type", type);
        long result = db.insert("tbRegister", null, myValue);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getListMemByName() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from tbRegister order by name", null);
        return result;
    }

    public Cursor getListMemByID() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from tbRegister order by _id", null);
        return result;
    }
}
