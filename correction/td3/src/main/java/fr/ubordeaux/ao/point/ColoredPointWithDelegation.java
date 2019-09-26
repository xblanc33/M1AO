package fr.ubordeaux.ao.point;

import java.util.Objects;

public class ColoredPointWithDelegation  {
    private int r, g, b;
    private Point point;

    public ColoredPointWithDelegation(int x, int y, int r, int g, int b) {
        this.point = new Point(x, y);
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof ColoredPointWithDelegation)) {
            return false;
        }
        ColoredPointWithDelegation otherPoint = (ColoredPointWithDelegation) other;
        boolean sameX = otherPoint.getX() == getX();
        boolean sameY = otherPoint.getY() == getY();
        boolean sameR = otherPoint.r == r;
        boolean sameG = otherPoint.g == g;
        boolean sameB = otherPoint.b == b;
        return sameX && sameY && sameR && sameG && sameB ;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getX(),getY(),r,g,b);
    }
}