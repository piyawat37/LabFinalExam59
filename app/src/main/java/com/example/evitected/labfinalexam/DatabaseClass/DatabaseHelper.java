package com.example.evitected.labfinalexam.DatabaseClass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Evitected on 30/11/2559.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "LabFinalExam";

    public DatabaseHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
        SQLiteDatabase db = this.getWritableDatabase(); //checking
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE tb_1" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "field1 VARCHAR," +
                "field2 VARCHAR,");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_1");
        onCreate(sqLiteDatabase);
    }
    public boolean insertData1(){
        SQLiteDatabase db = this.getWritableDatabase();
        return false;
    }
    /*
    //Insert
    public boolean insertVocab(String vocab, String meaning, String example, int cat_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues myValue = new ContentValues();
        myValue.put("vocab", vocab);
        myValue.put("meaning", meaning);
        myValue.put("example", example);
        myValue.put("cat_id", cat_id);
        long result = db.insert("tb_vocab", null, myValue);

        if (result == -1) {
            return false;
        }else {
            return  true;
        }
    }
    //Select
    public Cursor getAllCat() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from tb_cat", null);
        return result;
    }
    public boolean deleteVocab(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("tb_vocab","_id = "+id, null) > 0;
    }
    //Update
    public boolean updateVocab(int id, String vocab, String mean, String example,int cat_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("vocab",vocab);
        data.put("meaning", mean);
        data.put("example", example);
        data.put("cat_id", cat_id);
        return db.update("tb_vocab", data,"_id = "+id, null) > 0;
    }
    //Delete
    public Cursor getSelectedVocab(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from tb_vocab where _id = "+ id;
        Cursor result = db.rawQuery(sql, null);
        if(!result.moveToFirst())
            result.moveToFirst();
        return result;
    }
    */
}
