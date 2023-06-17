package org.example.xmlxsd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Topaz")
public class Topaz extends AbstractNonPreciousStone {
    @XmlElement(name = "Transparency")
    private Transparency transparency;

    public Topaz() {}

    public Transparency getTransparency() {
        return transparency;
    }

    public void setTransparency(Transparency transparency) {
        this.transparency = transparency;
    }
}
