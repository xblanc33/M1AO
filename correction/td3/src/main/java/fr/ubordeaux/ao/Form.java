package fr.ubordeaux.ao;

import org.jdom2.Element;

public abstract class Form {
	private int x;
	private int y;
	private Element htmlElement;

	public Form(int x, int y) {
		this.htmlElement = new Element("form");
		this.setX(x);
		this.setY(y);
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	private void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public Element getHtmlElement() {
		return htmlElement;
	}

	public abstract void setAttributes();

}