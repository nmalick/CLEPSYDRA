package com.mobiledevs.clepsydra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mobiledevs.clepsydra.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createNewActivity();

//        SQLAdapter sqlAdapter = new SQLAdapter(this);
//        displayTasks(sqlAdapter);


//.............................................................
//        Old Stuff
//        String newTaskName = getIntent().getStringExtra("newTaskName");
//        String newTaskPriority = getIntent().getStringExtra("newTaskPriority");

//        Task newTask = new Task(newTaskName);
//        newTask.setTaskPriority(newTaskPriority);

//        TextView textView = (TextView) findViewById(R.id.textView2);
//        TextView textView2 = (TextView) findViewById(R.id.textView3);
//        textView.setText(newTask.getTaskName());
//        textView2.setText(newTask.getTaskPriority());
//       .......................................................


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openSettings(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }


    public void createNewActivity(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

//    public void displayTasks(final SQLAdapter sqlAdapter){
//        Button btnDisplay = (Button) findViewById(R.id.btnDisplay);
//        btnDisplay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sqlAdapter.openToRead();
//                TextView textView = (TextView) findViewById(R.id.txtDisplay);
//                textView.setText(sqlAdapter.queueAll().getCount());
//            }
//        });
//    }



}
