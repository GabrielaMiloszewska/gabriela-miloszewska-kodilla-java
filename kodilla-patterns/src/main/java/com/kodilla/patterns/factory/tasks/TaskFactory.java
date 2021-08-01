package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPINGTASK = "Shopping task";
    public static final String PAINTINGTASK = "Painting task";
    public static final String DRIVINGTASK = "Driving task";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("Holiday shopping", "souvenirs", 5);
            case PAINTINGTASK:
                return new PaintingTask("Holiday painting", "beige", "the entire apartment");
            case DRIVINGTASK:
                return new DrivingTask("Holiday break", "to Barcelona", "by airplane");
            default:
                return null;
        }

    }
}
