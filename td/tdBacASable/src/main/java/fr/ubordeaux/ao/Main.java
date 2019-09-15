package fr.ubordeaux.ao;

public class Main {
    public static void main(String[] args) {
        System.out.println("main");
        Transformer t = new Transformer();
        t.transform(new Shape());

        Transformer t2 = new RectangleTransformer();
        t2.transform(new Shape());
    }
}