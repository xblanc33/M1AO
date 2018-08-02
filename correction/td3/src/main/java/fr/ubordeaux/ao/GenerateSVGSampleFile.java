package fr.ubordeaux.ao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fr.ubordeaux.ao.SVG;

public class GenerateSVGSampleFile {
    public static void main(String[] args) {
        SVG svg = new SVG(400, 200);
        svg.add(new Rectangle(10, 10, 110, 110));
        svg.add(new Circle(200, 100, 40));
        try {
            generateHTML(svg.toSVG());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static void generateHTML(String svg) throws IOException {
        FileWriter fw = new FileWriter(new File("svg.html"));
        fw.write("<!DOCTYPE html>\n");
        fw.write("<html>\n");
        fw.write("\t<body>\n");
        fw.write("\t\t"+svg+"\n");
        fw.write("\t</body>\n");
        fw.write("</html>");
        fw.flush();
        fw.close();
    }
}