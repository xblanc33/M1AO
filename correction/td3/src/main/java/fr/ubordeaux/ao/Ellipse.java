package fr.ubordeaux.ao;

public class Ellipse extends Circle {
    private int radiusY;

    public Ellipse(int centerX, int centerY, int radiusX, int radiusY) {
        super(centerX, centerY, radiusX);
        this.setRadiusY(radiusY);
    }

    private void setRadiusY(int radiusY) {
        this.radiusY = radiusY;
    }

    public int getRadiusY() {
        return radiusY;
    }

    @Override
    public String toSVG() {
        return "<ellipse cx=\""+getX()+"\" cy=\""+getY()+"\" rx=\""+getRadius()+"\" ry=\""+getRadiusY()+"\" />";
    }
    
}