package fr.ubordeaux.ao;

import org.jdom2.Attribute;

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
	public void setAttributes() {
		getHtmlElement().setName("circle");	
		getHtmlElement().setAttribute(new Attribute("cx", ""+getX()+""));
		getHtmlElement().setAttribute(new Attribute("cy", ""+getY()+""));
		getHtmlElement().setAttribute(new Attribute("r", ""+getRadius()+""));
	}
}