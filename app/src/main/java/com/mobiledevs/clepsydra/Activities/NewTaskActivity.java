package com.mobiledevs.clepsydra.Activities;

import android.content.Intent;
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
                getNewTask();
//                saveNewTask(getNewTask());
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
    }


    public Task getNewTask(){
        TextView taskName = (TextView) findViewById(R.id.editTxtNewTask);
        Task newTask = new Task(taskName.getText().toString());

        Spinner taskPriority = (Spinner) findViewById(R.id.editDropTaskPriority);
        newTask.setTaskPriority(taskPriority.getSelectedItem().toString());

        return newTask;
    }

//    public void saveNewTask(Task newTask){
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
//    }
}
