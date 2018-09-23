package fr.ubordeaux.ao;

import org.jdom2.Attribute;

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
		getHtmlElement().setAttribute(new Attribute("type", "rect"));
		getHtmlElement().setAttribute(new Attribute("x", "" + getX() + ""));
		getHtmlElement().setAttribute(new Attribute("y", "" + getY() + ""));
		getHtmlElement().setAttribute(new Attribute("width", "" + getWidth() + ""));
		getHtmlElement().setAttribute(new Attribute("height", "" + getHeight() + ""));
	}

}