package org.example.xmlxsd.model;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "Stones")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stones {
    @XmlElements({
            @XmlElement(name = "Topaz", type = Topaz.class),
            @XmlElement(name = "Sapphire", type = Sapphire.class),
            @XmlElement(name = "Brilliant", type = Brilliant.class)
    })
    private List<AbstractStone> stones;

    public List<AbstractStone> getStones() {
        return stones;
    }

    public void setStones(List<AbstractStone> stones) {
        this.stones = stones;
    }
}
