package fr.ubordeaux.ao.point;

import java.util.Objects;

public class ColoredPoint extends Point  {
    private int r, g, b;

    public ColoredPoint(int x, int y, int r, int g, int b) {
        super(x,y);
        this.r = r;
        this.g = g;
        this.b = b;
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
		if (! (other instanceof ColoredPoint)) {
            return false;
        }
        ColoredPoint otherPoint = (ColoredPoint) other;
        boolean sameX = otherPoint.x == x;
        boolean sameY = otherPoint.y == y;
        boolean sameR = otherPoint.r == r;
        boolean sameG = otherPoint.g == g;
        boolean sameB = otherPoint.b == b;
        return sameX && sameY && sameR && sameG && sameB ;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x,y,r,g,b);
    }
}