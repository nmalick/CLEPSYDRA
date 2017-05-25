package com.mobiledevs.clepsydra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mobiledevs.clepsydra.R;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        btnCreateListener();
    }

    public void goHome(MenuItem item) {
        Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
        //finish();
        startActivity(intent);
    }

    public void btnCreateListener(){
        Button btnCreate = (Button) findViewById(R.id.btnAddNewTask);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
                intent.putExtra("newTaskName","Forced Name");
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
}
