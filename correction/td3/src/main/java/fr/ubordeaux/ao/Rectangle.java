package fr.ubordeaux.ao;

public class Rectangle extends Form {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public String toSVG() {
        return "<rect x=\""+getX()+"\" y=\""+getY()+"\" width=\""+getWidth()+"\" height=\""+getHeight()+"\"/>";
    }

}