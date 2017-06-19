package com.mobiledevs.clepsydra.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobiledevs.clepsydra.POJO.Task;
import com.mobiledevs.clepsydra.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * A fragment representing a single Task detail screen.
 * This fragment is either contained in a {@link TaskListActivity}
 * in two-pane mode (on tablets) or a {@link TaskDetailActivity}
 * on handsets.
 */
public class TaskDetailFragment extends Fragment {
    private Task taskItem;
    static String mTaskName;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TaskDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            String taskData = getTaskData(getArguments().getString(mTaskName));
            taskItem = parseTaskData(taskData);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(taskItem.getTaskName());
            }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.task_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (taskItem != null) {
            ((TextView) rootView.findViewById(R.id.task_detail)).setText(taskItem.getTaskCategory());
        }

        return rootView;
    }

    public String getTaskData(String taskName){
        String taskData = null;

        FileInputStream iStream;
        InputStreamReader iSReader;
        try {
            iStream = getContext().openFileInput(taskName);// Do parsing on getFilesDir() result and add +".txt" back
            iSReader = new InputStreamReader(iStream);
            char[] inputBuffer = new char[iStream.available()];
            iSReader.read(inputBuffer);
            taskData = new String(inputBuffer);

            iSReader.close();
            iStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        File f = new File(getFilesDir()+"/"+taskName);
//        f.delete();


        return taskData;
    }

    public Task parseTaskData(String taskData){
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");


        String[] dataArray = taskData.split(":");
        Task newTask = new Task(dataArray[0]);
        newTask.setTaskCategory(dataArray[1]);
        newTask.setTaskLocation(dataArray[2]);
        newTask.setTaskPriority(dataArray[3]);
        try {
            newTask.setTaskCreationDate(format.parse(dataArray[4]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            newTask.setTaskDueDate(format.parse(dataArray[5]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            newTask.setTaskReminderDate(format.parse(dataArray[6]));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return newTask;
    }
}
