package org.example.xmlxsd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Brilliant")
public class Brilliant extends AbstractPreciousStone {
    @XmlElement
    private Color color;
    @XmlElement
    private Form form;

    public Brilliant () {}

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
