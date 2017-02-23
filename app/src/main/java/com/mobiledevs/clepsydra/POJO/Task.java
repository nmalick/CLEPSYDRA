package com.mobiledevs.clepsydra.POJO;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by milko on 2/22/2017.
 */

public class Task {

    public String taskName;
    public String taskCreationDate;
    public Date taskDueDate;
    public String taskCategory;
    public String taskPriority;
    public Date taskReminderDate;
    public String taskLocation;
    public boolean taskComplete;
    public boolean onTime;

    public Task(String newTaskName){

        taskName = newTaskName;
        taskComplete = false;
        taskCreationDate = DateFormat.getDateTimeInstance().format(new Date());
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskCreationDate() {
        return taskCreationDate;
    }

    public void setTaskCreationDate(String taskCreationDate) {
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

}
