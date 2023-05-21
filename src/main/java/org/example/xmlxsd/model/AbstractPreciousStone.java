package org.example.xmlxsd.model;

public class AbstractPreciousStone extends AbstractStone {
    private Rarity rarity;
    private Double hardness;

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
