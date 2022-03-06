package com.kodilla.patterns.forest;

abstract class Tree implements AllTrees {
    private final String name;
    protected LeafGrowth leafGrowth;

    public Tree(String name) {
        this.name = name;
    }

    public String leafInfo() {
        return leafGrowth.showLeafInfo();
    }

    public int growYourTree(int desiredHeight, int weeklyGrowth) {
        int numberOfWeeks = (int)Math.ceil((double) desiredHeight/weeklyGrowth);
        return numberOfWeeks;
    }

    public int getEstimatedTrunkHeight(int age) {
        return age * 50;
    }

    public int getAvgBranchLength(int age) {
        return age * 5;
    }

    public double getAvgTrunkCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public String getName() {
        return name;
    }
}
