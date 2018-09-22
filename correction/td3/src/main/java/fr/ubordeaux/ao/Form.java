package fr.ubordeaux.ao;

import org.jdom2.Element;

public abstract class Form {
    private int x;
    private int y;

    public Form(int x, int y) {
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
    
    	public abstract Element createElement();
    	
}