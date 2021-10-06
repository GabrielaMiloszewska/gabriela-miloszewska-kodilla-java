package com.kodilla.kodillapatterns2.observer.homework;

public interface HomeworkObservable {

    void selectObserver(TeacherObserver teacherObserver);
    void notifyObservers();
    void removeObserver(TeacherObserver teacherObserver);
}
