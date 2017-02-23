package com.mobiledevs.clepsydra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mobiledevs.clepsydra.R;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
    }

    public void goHome(MenuItem item) {
        startActivity(new Intent(NewTaskActivity.this, MainActivity.class));
    }
}
