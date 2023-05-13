package org.example.XMLXSD.model;

public class AbstractStone {
    private String name;
    private TypeStone type;

    public String getName() {
        return name;
    }

    public TypeStone getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TypeStone type) {
        this.type = type;
    }
}
