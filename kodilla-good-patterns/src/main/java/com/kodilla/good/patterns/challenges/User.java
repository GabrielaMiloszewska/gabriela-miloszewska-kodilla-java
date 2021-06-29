package com.kodilla.good.patterns.challenges;

public class User {
    private String nickName;
    private String name;
    private String surname;
    private int numberOfTransactions;

    public User(final String nickName, final String name, final String surname, final int numberOfTransactions) {
        this.nickName = nickName;
        this.name = name;
        this.surname = surname;
        this.numberOfTransactions = numberOfTransactions;
    }

    public String getNickName() {
        return nickName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

}
