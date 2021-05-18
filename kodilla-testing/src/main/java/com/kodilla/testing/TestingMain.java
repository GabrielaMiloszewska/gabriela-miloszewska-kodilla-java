package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }


        // 6.2 Zadanie: pierwszy test jednostkowy
        Calculator calculator = new Calculator();
        int addition = calculator.add(100, 32);
        int subtraction = calculator.subtract(100, 32);
        if ((addition == 132) && (subtraction == 68)) {
            System.out.println("This calculator works fine.");
        } else {
            System.out.println("Something went wrong. This calculator doesn't work.");
        }

    }
}
