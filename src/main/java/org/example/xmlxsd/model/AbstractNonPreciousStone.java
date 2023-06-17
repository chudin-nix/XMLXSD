package org.example.xmlxsd.model;

public abstract class AbstractNonPreciousStone extends AbstractStone {
    private String alkaliResistance;

    public AbstractNonPreciousStone () {}

    public String getAlkaliResistance() {
        return alkaliResistance;
    }

    public void setAlkaliResistance(String alkaliResistance) {
        this.alkaliResistance = alkaliResistance;
    }
}
