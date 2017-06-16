package com.mobiledevs.clepsydra.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.mobiledevs.clepsydra.POJO.Task;
import com.mobiledevs.clepsydra.R;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        getDefaultDueDate();
        createListeners();
    }

    public void createListeners(){
        Button btnCreate = (Button) findViewById(R.id.btnAddNewTask);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        TextView taskDueDate = (TextView) findViewById(R.id.editDateTaskDueDate);
        TextView taskReminderDate = (TextView) findViewById(R.id.editDateTaskReminderDate);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task newTask = getNewTask();
                saveNewTask(newTask);
                Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
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

        taskDueDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView taskDueDate = (TextView) findViewById(R.id.editDateTaskDueDate);
                taskDueDate.setText(new Date().toString().toUpperCase());
            }
        });

        taskReminderDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView taskReminderDate = (TextView) findViewById(R.id.editDateTaskReminderDate);
                taskReminderDate.setText(new Date().toString().toUpperCase());
            }
        });

    }



    public Task getNewTask(){
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

        TextView taskName = (TextView) findViewById(R.id.editTxtNewTask);
        Spinner taskCategory = (Spinner) findViewById(R.id.editDropTaskCategory);
        Spinner taskPriority = (Spinner) findViewById(R.id.editDropTaskPriority);
        TextView taskDueDate = (TextView) findViewById(R.id.editDateTaskDueDate);
        TextView taskReminderDate = (TextView) findViewById(R.id.editDateTaskReminderDate);
        TextView taskLocation = (TextView) findViewById(R.id.editTxtTaskLocation);

        Task newTask = new Task(taskName.getText().toString(),this);
        newTask.setTaskCategory(taskCategory.getSelectedItem().toString());
        newTask.setTaskPriority(taskPriority.getSelectedItem().toString());
        newTask.setTaskLocation(taskLocation.getText().toString());

        try {
            Date dueDate = format.parse(taskDueDate.getText().toString());
            newTask.setTaskDueDate(dueDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date reminderDate = format.parse(taskReminderDate.getText().toString());
            newTask.setTaskReminderDate(reminderDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return newTask;
    }

    public void saveNewTask(Task newTask){
        String taskName = newTask.getTaskName();
//        String fileName = taskName + ".txt";
        String newTaskString = newTask.getTaskName() + "|" +
                newTask.getTaskCategory()+ "|" +newTask.getTaskLocation()+ "|" +
                newTask.getTaskPriority()+ "|" +newTask.getTaskCreationDate()+ "|" +
                newTask.getTaskDueDate()+ "|" +newTask.getTaskReminderDate()+ ";" ;

                File newTaskFile = new File(newTask.getContext().getFilesDir(),taskName);

        FileOutputStream oStream;
        try {
            oStream = openFileOutput(taskName, Context.MODE_PRIVATE);
            oStream.write(newTaskString.getBytes());
            oStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//.....................SQL version of file storage........................
//        SQLAdapter sqlAdapter = new SQLAdapter(this);
//        sqlAdapter.openToWrite();
//        sqlAdapter.insert(newTask);
//        sqlAdapter.close();
//
//        sqlAdapter.openToRead();
//
//        TextView textView = (TextView) findViewById(R.id.txtNewTask);
//        textView.setText(sqlAdapter.getName());
//
//        sqlAdapter.close();

//        ...........................................................................................................
    }

    public void getDefaultDueDate(){
        TextView taskDueDate = (TextView) findViewById(R.id.editDateTaskDueDate);
        taskDueDate.setText(new Date().toString().toUpperCase());
    }
}
