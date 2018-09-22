package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Set;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class SVG {
	private int width;
	private int height;

	private Set<Form> forms;

	public SVG(int width, int height) {
		if (width == 0 || height == 0)
			throw new SVGException("SVG is too small");
		this.width = width;
		this.height = height;
		forms = new HashSet<Form>();
	}

	public void add(Form form) {
		forms.add(form);
	}

	public void remove(Form form) {
		forms.remove(form);
	}

	public void generateHTML(Element body) {
		Element svg = new Element("svg");
		svg.setAttribute(new Attribute("width", "" + width + ""));
		svg.setAttribute(new Attribute("height", "" + height + ""));
		for (Form form: forms) {
			form.setAttributes();
			svg.addContent(form);
		}
		body.addContent(svg);
	}
}