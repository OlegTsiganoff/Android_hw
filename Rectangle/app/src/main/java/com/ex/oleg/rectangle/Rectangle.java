package com.ex.oleg.rectangle;

/**
 * Created by oleg on 28.02.2016.
 */
public class Rectangle {
    private double side1;
    private double side2;

    public Rectangle() { }
    public Rectangle(double inSide1, double inSide2)
    {
        side1 = inSide1;
        side2 = inSide2;
    }

    private double AreaCalculator()
    {
        return side1 * side2;
    }

    private double PerimeterCalculator()
    {
        return (side1 + side2) * 2;
    }

    public double getArea() { return AreaCalculator();  }
    public double getPerimeter() { return PerimeterCalculator(); }
}
