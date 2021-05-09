package com.alpha.fitnutronew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import androidx.annotation.Nullable;

import es.dmoral.toasty.Toasty;

public class DatabaseHandler extends SQLiteOpenHelper {

    //defining table attributes//
    private  Context context;
    private static final String DATABASE_NAME = "TaskList.db";
    private static final int DATABASE_VERSION = 3;

    private static final String TABLE_NAME = "tasks";
    private static final String COLUMN_ID = "task_id";
    private static final String COLUMN_TITLE = "task_title";
    private static final String COLUMN_DESCRIPTION = "task_description";
    private static final String COLUMN_SETS = "task_sets";
    private static final String COLUMN_REPS = "task_reps";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//create the table//

        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_SETS + " INTEGER, " +
                COLUMN_REPS + " INTEGER);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void addTask(String title, String description, int sets, int reps) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_DESCRIPTION, description);
        cv.put(COLUMN_SETS, sets);
        cv.put(COLUMN_REPS, reps);

        //WHETHER DATA INSERT OR NOT

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toasty.error(context,"Fail to add",Toast.LENGTH_SHORT).show();
        } else {
            Toasty.success(context,"Added successfully",Toast.LENGTH_SHORT).show();
        }

    }


    // READ ALL THE DATA FROM DATABASE

    Cursor readData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String title, String description, String sets, String reps){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_DESCRIPTION, description);
        cv.put(COLUMN_SETS, sets);
        cv.put(COLUMN_REPS, reps);


        long result = db.update(TABLE_NAME, cv, "task_id=?", new String[]{row_id});
        if(result == -1){
            Toasty.error(context,"Fail to Update",Toast.LENGTH_SHORT).show();
        }else {

            Toasty.success(context,"Updated Successfully",Toast.LENGTH_SHORT).show();
        }

    }

    void deleteRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "task_id=?", new String[]{row_id});
        if(result == -1){
            Toasty.error(context,"Fail to Delete",Toast.LENGTH_SHORT).show();
        }else{
            Toasty.success(context,"Successfully Deleted",Toast.LENGTH_SHORT).show();
        }
    }



}
