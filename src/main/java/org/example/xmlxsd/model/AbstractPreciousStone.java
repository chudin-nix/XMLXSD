package org.example.xmlxsd.model;

import javax.xml.bind.annotation.XmlElement;

public abstract class AbstractPreciousStone extends AbstractStone {
    @XmlElement(name = "Rarity")
    private Rarity rarity;
    @XmlElement(name = "Hardness")
    private Double hardness;

    public AbstractPreciousStone () {}

    public Rarity getRarity() {
        return rarity;
    }

    public Double getHardness() {
        return hardness;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public void setHardness(Double hardness) {
        this.hardness = hardness;
    }
}
