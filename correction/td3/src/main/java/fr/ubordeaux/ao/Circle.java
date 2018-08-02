package fr.ubordeaux.ao;

public class Circle extends Form {
    private int radius;
    
    public Circle(int centerX, int centerY, int radius) {
        super(centerX, centerY);
        this.setRadius(radius);
    }

    private void setRadius(int radius) {
        if (radius <= 0) throw new SVGException("radius must be greater than 0");
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toSVG() {
        return "<circle cx=\""+getX()+"\" cy=\""+getY()+"\" r=\""+getRadius()+"\"/>";
    }
}