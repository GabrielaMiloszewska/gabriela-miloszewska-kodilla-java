package com.kodilla.patterns.forest;

public class Conifer extends Tree {

    public Conifer(String name) {
        super(name);
        this.leafGrowth = new ConiferGrowth();
    }

    @Override
    public int getAvgBranchLength(int age) {
        return age * 2;
    }
}
