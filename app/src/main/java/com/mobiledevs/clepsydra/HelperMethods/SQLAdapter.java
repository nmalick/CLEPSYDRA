package com.mobiledevs.clepsydra.HelperMethods;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mobiledevs.clepsydra.POJO.Task;

/**
 * Created by milko on 5/30/2017.
 */

public class SQLAdapter {
    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "tasklist_database";
    public static final String TASKLIST_TABLE_NAME = "TaskList_Table";
    public static final String TASKLIST_TASK_ID = "_ID Number";
    public static final String TASKLIST_TASK_NAME = "Task Name";
    public static final String TASKLIST_CREATION_DATE = "Creation Date";
    public static final String TASKLIST_DUE_DATE = "Due Date";
    public static final String TASKLIST_CATEGORY = "Category";
    public static final String TASKLIST_PRIORITY = "Priority";
    public static final String TASKLIST_REMINDER_DATE = "Reminder Date";
    public static final String TASKLIST_LOCATION = "Location";
    public static final String TASKLIST_IsComplete = "Is Complete";
    public static final String TASKLIST_OnTime = "On Time";

    private SQLiteDatabase sqLiteDatabase;
    private SQLiteDBHelper sqLiteDBHelper;
    private Context mContext;

    private static final String SCRIPT_CREATE_DATABASE = "CREATE TABLE " + TASKLIST_TABLE_NAME + " ( " +
            TASKLIST_TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TASKLIST_TASK_NAME + " TEXT NOT NULL, " +
            TASKLIST_CREATION_DATE + " DATETIME, " +
            TASKLIST_DUE_DATE + " DATETIME, " +
            TASKLIST_CATEGORY + " TEXT, " +
            TASKLIST_PRIORITY + " TEXT, " +
            TASKLIST_REMINDER_DATE + " DATETIME, " +
            TASKLIST_LOCATION + " TEXT, " +
            TASKLIST_IsComplete + " BOOLEAN, " +
            TASKLIST_OnTime + " BOOLEAN" + " )";

    public SQLAdapter(Context context){
        mContext = context;
    }

    public void close(){
        sqLiteDBHelper.close();
    }

    public int deleteAll(){
        return sqLiteDatabase.delete(TASKLIST_TABLE_NAME, null, null);
    }

    public long insert(Task newTask) {
        ContentValues values = new ContentValues();
        values.put(TASKLIST_TASK_NAME, newTask.getTaskName());
        values.put(TASKLIST_PRIORITY, newTask.getTaskPriority());

        long testSql = sqLiteDatabase.insert(TASKLIST_TABLE_NAME,null,values);
         return testSql;
    }

    public SQLAdapter openToRead() throws SQLException{
        try{
            sqLiteDBHelper = new SQLiteDBHelper(mContext,DATABASE_NAME,null,DATABASE_VERSION);
            sqLiteDatabase = sqLiteDBHelper.getReadableDatabase();
        }catch (Exception e){}

        return this;
    }

    public SQLAdapter openToWrite() throws SQLException{
        try{
            sqLiteDBHelper = new SQLiteDBHelper(mContext,DATABASE_NAME,null,DATABASE_VERSION);
            sqLiteDatabase = sqLiteDBHelper.getWritableDatabase();
        }catch (Exception e){}

        return this;
    }

    public String getName(){
        String taskName = "TEST";
//        String query = "SELECT * FROM "+ TASKLIST_TABLE_NAME;
//        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
//        if (cursor.getCount() > 0)
//            cursor.moveToFirst();
//        while(!cursor.isAfterLast()){
//            taskName = cursor.getString(cursor.getColumnIndex(TASKLIST_TASK_NAME));
//            cursor.moveToNext();
//        }

        return taskName;
    }


    public class SQLiteDBHelper extends SQLiteOpenHelper {


        public SQLiteDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
            super(context, name, factory, version);
        }

//        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase){
            sqLiteDatabase.execSQL(SCRIPT_CREATE_DATABASE);
        }

        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldV, int newV){}

    }

}
