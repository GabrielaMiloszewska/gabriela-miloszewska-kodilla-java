package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private Shape shape;
    public ShapeCollector(Shape shape) {
        this.shape = shape;
    }

    List<Shape> shapeList= new ArrayList<>();

    public void addFigure(Shape shape) {
        shapeList.add(this.shape);
    }

    public void removeFigure(Shape shape) {
        shapeList.remove(this.shape);
    }

    public Shape getFigure(int n) {
        shapeList.get(n);
        return shape;
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
