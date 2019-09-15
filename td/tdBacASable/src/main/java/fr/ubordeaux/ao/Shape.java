package fr.ubordeaux.ao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shape {
    private List<Point> pointList;
    
    public Shape() {
        pointList = new ArrayList<Point>();
    }

    public List<Point> getPointList() {
        return new ArrayList<Point>(pointList);
    }

    public Shape move(Point v0, Point v1) {
        return null;
    }

}