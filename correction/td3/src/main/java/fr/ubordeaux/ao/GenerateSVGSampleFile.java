package fr.ubordeaux.ao;

import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import fr.ubordeaux.ao.SVG;

public class GenerateSVGSampleFile {

	public static void main(String[] args) throws IOException {
		SVG svg = new SVG(400, 200);
		svg.add(new Rectangle(10, 10, 110, 110));
		svg.add(new Circle(200, 100, 40));
		generateHTML(svg);
	}

	public static void generateHTML(SVG svg) throws IOException {
		Document document = new Document();
		Element racine = new Element("html");
		document.addContent(racine);
		Element body = new Element("body");
		racine.addContent(body);
		svg.generateHTML(body);

		XMLOutputter outputPutter = new XMLOutputter(Format.getPrettyFormat());
		outputPutter.output(document, System.out);
	}

}