package com.kodilla.hibernate.manytomany.facade;

public class CompanyException extends Exception{
    public static String ERR_NOT_EXIST = "The company is not in the database";

    public CompanyException(String message) {
        super(message);
    }
}
