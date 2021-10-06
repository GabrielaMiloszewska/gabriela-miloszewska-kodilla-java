package com.kodilla.kodillapatterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StudentHomework implements HomeworkObservable {

    private final List<TeacherObserver> teacherObservers;
    private final Deque<String> homework;
    private final String studentName;

    public StudentHomework(String studentName) {
        teacherObservers = new ArrayList<>();
        homework = new ArrayDeque<>();
        this.studentName = studentName;
    }

    public void addHomework(String topic) {
        homework.offer(topic);
        notifyObservers();
    }

    @Override
    public void selectObserver(TeacherObserver teacherObserver) {
        teacherObservers.add(teacherObserver);
    }

    @Override
    public void notifyObservers() {
        for (TeacherObserver teacherObserver : teacherObservers) {
            teacherObserver.update(this);
        }
    }

    @Override
    public void removeObserver(TeacherObserver teacherObserver) {
        teacherObservers.remove(teacherObserver);
    }

    public List<TeacherObserver> getTeacherObservers() {
        return teacherObservers;
    }

    public Deque<String> getHomework() {
        return homework;
    }

    public String getStudentName() {
        return studentName;
    }
}
