package com.mobiledevs.clepsydra.POJO;

import android.content.Context;

import java.util.Date;

/**
 * Created by milko on 2/22/2017.
 */

public class Task {

    private Context context;

    private String taskName;
    private Date taskCreationDate;
    private Date taskDueDate;
    private String taskCategory;
    private String taskPriority;
    private Date taskReminderDate;
    private String taskLocation;
    private boolean taskComplete;
    private boolean onTime;

    public Task(String newTaskName, Context context){
        this.context = context;

        taskName = newTaskName;
        taskComplete = false;
        taskCreationDate = new Date();

    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskCreationDate() {
        return taskCreationDate;
    }

    public void setTaskCreationDate(Date taskCreationDate) {
        this.taskCreationDate = taskCreationDate;
    }

    public String getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(String taskCategory) {
        this.taskCategory = taskCategory;
    }

    public Date getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(Date taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Date getTaskReminderDate() {
        return taskReminderDate;
    }

    public void setTaskReminderDate(Date taskReminderDate) {
        this.taskReminderDate = taskReminderDate;
    }

    public String getTaskLocation() {
        return taskLocation;
    }

    public void setTaskLocation(String taskLocation) {
        this.taskLocation = taskLocation;
    }

    public boolean isTaskComplete() {
        return taskComplete;
    }

    public void setTaskComplete(boolean taskComplete) {
        this.taskComplete = taskComplete;
    }

    public boolean isOnTime() {
        return onTime;
    }

    public void setOnTime(boolean onTime) {
        this.onTime = onTime;
    }

    public Context getContext() {
        return context;
    }

}
