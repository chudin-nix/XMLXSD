package org.example.xmlxsd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Sapphire")
public class Sapphire extends AbstractPreciousStone {
    @XmlElement(name = "Country")
    private String country;

    public Sapphire () {}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
