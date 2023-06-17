package org.example.xmlxsd.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Topaz.class, Brilliant.class, Sapphire.class})
public abstract class AbstractStone {
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Type")
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
