package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapeList = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapeList.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapeList.remove(shape);
    }

    public Shape getFigure(int n) {
        return shapeList.get(n);
    }

    public void showFigures() {
        for (Shape theShape : shapeList) {
            System.out.println(theShape.getShapeName());
        }
    }

    public int getListSize() {
        return shapeList.size();
    }

}
