package fr.ubordeaux.ao;

import org.jdom2.Attribute;
import org.jdom2.Element;

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

	public Element createElement() {
		Element ellipse = new Element("ellipse");
		ellipse.setAttribute(new Attribute("cx", ""+getX()+""));
		ellipse.setAttribute(new Attribute("cy", ""+getY()+""));
		ellipse.setAttribute(new Attribute("rx", ""+getRadius()+""));
		ellipse.setAttribute(new Attribute("ry", ""+getRadiusY()+""));
		return ellipse;
	}
    
}