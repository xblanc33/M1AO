package fr.ubordeaux.ao;

import org.jdom2.Attribute;
import org.jdom2.Element;

@SuppressWarnings("serial")
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
	public void setAttributes() {
		this.setAttribute(new Attribute("type", "rect"));
		this.setAttribute(new Attribute("x", "" + getX() + ""));
		this.setAttribute(new Attribute("y", "" + getY() + ""));
		this.setAttribute(new Attribute("width", "" + getWidth() + ""));
		this.setAttribute(new Attribute("height", "" + getHeight() + ""));
	}

}