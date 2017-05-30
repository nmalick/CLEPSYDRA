package com.mobiledevs.clepsydra.Activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.mobiledevs.clepsydra.POJO.Task;
import com.mobiledevs.clepsydra.R;

public class NewTaskActivity extends AppCompatActivity {

    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        btnCreateListener();
    }

    public void btnCreateListener(){
        Button btnCreate = (Button) findViewById(R.id.btnAddNewTask);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDBHelper sqLiteDBHelper = saveNewTask(getNewTask());
                Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
//                intent.putExtra("newTaskName",newTask.getTaskName());
//                intent.putExtra("newTaskPriority",newTask.getTaskPriority());
                finish();
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }


    public Task getNewTask(){
        TextView taskName = (TextView) findViewById(R.id.editTxtNewTask);
        Task newTask = new Task(taskName.getText().toString());

        Spinner taskPriority = (Spinner) findViewById(R.id.editDropTaskPriority);
        newTask.setTaskPriority(taskPriority.getSelectedItem().toString());



        return newTask;
    }

    public SQLiteDBHelper saveNewTask(Task newTask){
        SQLiteDBHelper sqLiteDBHelper = new SQLiteDBHelper(this);
        SQLiteDatabase database = sqLiteDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLiteDBHelper.TASKLIST_TASK_NAME, newTask.getTaskName());
        values.put(SQLiteDBHelper.TASKLIST_PRIORITY, newTask.getTaskPriority());
        long newRowId = database.insert(SQLiteDBHelper.TASKLIST_TABLE_NAME,null,values);

        return sqLiteDBHelper;
    }


    public class SQLiteDBHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 2;
        public static final String DATABASE_NAME = "tasklist_database";
        public static final String TASKLIST_TABLE_NAME = "TaskList Table";
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

        public SQLiteDBHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase){
            sqLiteDatabase.execSQL("CREATE TABLE" + TASKLIST_TABLE_NAME + " (" +
                TASKLIST_TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TASKLIST_TASK_NAME + " TEXT, " +
                    TASKLIST_CREATION_DATE + " DATETIME, " +
                    TASKLIST_DUE_DATE + " DATETIME, " +
                    TASKLIST_CATEGORY + " TEXT, " +
                    TASKLIST_PRIORITY + " TEXT, " +
                    TASKLIST_REMINDER_DATE + " DATETIME, " +
                    TASKLIST_LOCATION + " TEXT, " +
                    TASKLIST_IsComplete + " BOOLEAN, " +
                    TASKLIST_OnTime + "BOOLEAN" + ")");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TASKLIST_TABLE_NAME);
            onCreate(sqLiteDatabase);
        }


    }

}
