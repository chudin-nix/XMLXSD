package org.example.xmlxsd.model;

public class Brilliant extends AbstractPreciousStone {
    private Color color;

    private Form form;

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Color getColor() {

        return color;
    }

    public void setColor(Color color) {

        this.color = color;
    }
}
