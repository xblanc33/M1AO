package fr.ubordeaux.ao;

public class Line extends Form{
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.setX2(x2);
        this.setY2(y2);
    }

    private void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX2() {
        return this.x2;
    }

    private void setY2(int y2) {
        this.y2 = y2;
    }

    public int getY2() {
        return this.y2;
    }
    
    public String toSVG() {
        return "<line x1=\""+getX()+"\" y1=\""+getY()+"\" x2=\""+getX2()+"\" y2=\""+getY2()+"\"/>";
    }
}