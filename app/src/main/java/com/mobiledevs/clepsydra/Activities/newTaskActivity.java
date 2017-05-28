package com.mobiledevs.clepsydra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

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
                Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
                String newTaskName = getTaskName();
                String newTaskPriority = getTaskPriority();
                intent.putExtra("newTaskName",newTaskName);
                intent.putExtra("newTaskPriority",newTaskPriority);
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


    public String getTaskName(){
        TextView taskName = (TextView) findViewById(R.id.editTxtNewTask);
        final String newTaskName = taskName.getText().toString();

        return newTaskName;
    }

    public String getTaskPriority(){
        Spinner taskPriority = (Spinner) findViewById(R.id.editDropTaskPriority);
        final String newTaskPriority = taskPriority.getSelectedItem().toString();

        return newTaskPriority;
    }
}
