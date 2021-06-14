package com.kodilla.exception.test;

public class ExceptionHandling extends Exception {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(2.0, 1.5);
        } catch (Exception e) {
            System.out.println("One or both of the numbers are different than we're looking for:" + e);
        } finally {
            System.out.println("Done!");
        }
    }
}
