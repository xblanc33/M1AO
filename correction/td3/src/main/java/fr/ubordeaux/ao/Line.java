package fr.ubordeaux.ao;

import org.jdom2.Attribute;
import org.jdom2.Element;

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
    
	@Override
	public Element createElement() {
		Element line = new Element("line");
		line.setAttribute(new Attribute("x1", ""+getX()+""));
		line.setAttribute(new Attribute("y1", ""+getY()+""));
		line.setAttribute(new Attribute("x2", ""+getX2()+""));
		line.setAttribute(new Attribute("y2", ""+getY2()+""));
		return line;
	}
}