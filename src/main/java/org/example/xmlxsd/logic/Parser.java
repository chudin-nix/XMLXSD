package org.example.xmlxsd.logic;

import org.example.xmlxsd.model.AbstractStone;

import java.util.List;

public interface Parser {
    List<AbstractStone> parse (String file);


}
