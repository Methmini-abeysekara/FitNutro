package com.example.fitnutro;

public class MyWorkoutData {

    private String workoutName;
    private Integer workoutImage;

    public MyWorkoutData(String workoutName, Integer workoutImage) {
        this.workoutName = workoutName;
        this.workoutImage = workoutImage;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public Integer getWorkoutImage() {
        return workoutImage;
    }

    public void setWorkoutImage(Integer workoutImage) {
        this.workoutImage = workoutImage;
    }
}