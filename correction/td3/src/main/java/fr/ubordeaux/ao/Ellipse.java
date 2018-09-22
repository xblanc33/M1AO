package fr.ubordeaux.ao;

import org.jdom2.Attribute;
import org.jdom2.Element;

@SuppressWarnings("serial")
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
		this.setAttribute(new Attribute("type", "ellipse"));
		this.setAttribute(new Attribute("cy", "" + getY() + ""));
		this.setAttribute(new Attribute("rx", "" + getRadius() + ""));
		this.setAttribute(new Attribute("ry", "" + getRadiusY() + ""));
	}
}