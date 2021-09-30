package com.kodilla.hibernate.manytomany.facade;

public class EmployeeException extends Exception{
    public static String ERR_NOT_EXIST = "The employee is not in the database";

    public EmployeeException(String message) {
        super(message);
    }
}
