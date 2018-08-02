package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Set;

public class SVG {
    private int width;
    private int heigth;

    private Set<Form> forms;

    public SVG(int width, int heigth) {
        if (width==0 || heigth==0) throw new SVGException("SVG is too small");
        this.width = width;
        this.heigth = heigth;
        forms = new HashSet<Form>();
    }

    public void add(Form form) {
        forms.add(form);
    }

    public void remove(Form form) {
        forms.remove(form);
    }

    public String toSVG() {
        String svg;
        svg = "<svg width=\""+width+"\" height=\""+heigth+"\">\n";
        for (Form form : forms) {
            svg = svg + "\t" + form.toSVG() + "\n";
        }
        svg = svg + "</svg>";
        return svg;
    }
}