package com.kodilla.patterns.forest;

public class LeafyTree extends Tree {

    public LeafyTree(String name) {
        super(name);
        this.leafGrowth = new LeafyTreeGrowth();
    }

    @Override
    public int getEstimatedTrunkHeight(int age) {
        return age * 70;
    }

    public int ifAmountOfWaterIsSufficient (int numberOfTrees, int waterConsumedByATree, int[] waterAvailableInTheArea, int numberOfPlots) {
        if (waterAvailableInTheArea == null) return -1;
        int requiredWaterForAllTrees = numberOfTrees * waterConsumedByATree;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < numberOfPlots; i++) {
            sum = sum + waterAvailableInTheArea[i];
            count++;
            if (sum >= requiredWaterForAllTrees)
                break;
        }

        if(sum < requiredWaterForAllTrees) return 0;
        return count;
    }
}
