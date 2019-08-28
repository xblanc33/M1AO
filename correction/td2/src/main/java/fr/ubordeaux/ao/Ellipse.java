package fr.ubordeaux.ao;

import org.jdom2.Attribute;

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

	public void setAttributes() {
		getHtmlElement().setName("ellipse");	
		getHtmlElement().setAttribute(new Attribute("cy", "" + getY() + ""));
		getHtmlElement().setAttribute(new Attribute("rx", "" + getRadius() + ""));
		getHtmlElement().setAttribute(new Attribute("ry", "" + getRadiusY() + ""));
	}
}