package fr.ubordeaux.ao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rectangle extends Shape{
    private Point[] pointArray;
    
    public Rectangle(Point a, Point b, Point c, Point d) {
        pointArray = new Point[4];
        pointArray[0] = a;
        pointArray[1] = b;
        pointArray[2] = c;
        pointArray[3] = d;
    }

    public List<Point> getPointList() {
        List<Point> list = new ArrayList<Point>();
        list.add(pointArray[0]);
        list.add(pointArray[1]);
        list.add(pointArray[2]);
        list.add(pointArray[3]);
        return list;
    }

    public Rectangle move(Point v0, Point v1) {
        return null;
    }

    public int getWidth() {
        int xDiff = Math.abs(pointArray[1].getX() - pointArray[0].getX());
        int yDiff = Math.abs(pointArray[1].getY() - pointArray[2].getY());
        return Math.min(xDiff, yDiff);

    }

    public int getLength() {
        int xDiff = Math.abs(pointArray[1].getX() - pointArray[0].getX());
        int yDiff = Math.abs(pointArray[1].getY() - pointArray[2].getY());
        return Math.min(xDiff, yDiff);
    }

}