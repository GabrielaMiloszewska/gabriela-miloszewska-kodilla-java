package com.kodilla.kodillapatterns2.observer.homework;

public class Teacher implements TeacherObserver{

    private final String username;
    private int updateCount;

    public Teacher(String username) {
        this.username = username;
    }

    @Override
    public void update(StudentHomework studentHomework) {
        System.out.println(username + ": you have " + studentHomework.getHomework().size() + " homework to check from " + studentHomework.getStudentName());
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
