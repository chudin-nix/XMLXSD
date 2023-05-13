package org.example.XMLXSD.logic;

import org.example.XMLXSD.model.AbstractStone;

import java.util.List;

public interface Parser {
    List<AbstractStone> parse (String file);
}
