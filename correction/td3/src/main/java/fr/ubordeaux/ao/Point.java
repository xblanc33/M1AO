package fr.ubordeaux.ao;

import java.util.Objects;

public class Point  {
    protected int x;
    protected int y;
    
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
		if (! (other instanceof Point)) {
            return false;
        }
        Point otherPoint = (Point) other;
        return (otherPoint.x == x) && (otherPoint.y == y);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}