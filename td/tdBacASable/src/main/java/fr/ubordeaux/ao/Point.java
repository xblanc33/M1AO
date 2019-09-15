package fr.ubordeaux.ao;

import java.util.Objects;

public class Point {
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Point)) return false;
        Point otherPoint = (Point) other;
        boolean sameX = this.x == otherPoint.x;
        boolean sameY = this.y == otherPoint.y;
        return  sameX && sameY;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(toString());
    }

    @Override
    public String toString() {
        return "[x="+x+", y="+y+"]";
    }

}