package fr.ubordeaux.ao;

import org.jdom2.Attribute;
import org.jdom2.Element;

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

	@Override
	public Element createElement() {
		Element rect = new Element("rect");
		rect.setAttribute(new Attribute("x", ""+getX()+""));
		rect.setAttribute(new Attribute("y", ""+getY()+""));
		rect.setAttribute(new Attribute("width", ""+getWidth()+""));
		rect.setAttribute(new Attribute("height", ""+getHeight()+""));
		return rect;
	}

}