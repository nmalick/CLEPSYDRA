package com.mobiledevs.clepsydra.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobiledevs.clepsydra.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createNewTask();
        displayTasks();


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


    public void createNewTask(){
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

    public void displayTasks(){
        Button btnDisplay = (Button) findViewById(R.id.btnDisplay);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "N/A";

                String[] tasks = getFilesDir().list();
                for (String task : tasks){
                    data = task + "\n";
                }
//                FileInputStream iStream;
//                InputStreamReader iSReader;
//                try {
//                    iStream = openFileInput("221.txt");
//                    iSReader = new InputStreamReader(iStream);
//                    char[] inputBuffer = new char[iStream.available()];
//                    iSReader.read(inputBuffer);
//                    data = new String(inputBuffer);
//
//                    iSReader.close();
//                    iStream.close();
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }


                TextView textView = (TextView) findViewById(R.id.txtDisplay);
                textView.setText(data);
            }
        });
    }



}
