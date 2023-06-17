package org.example.xmlxsd.logic;

public class DomParserTest extends AbstractParserTest {
    @Override
    protected Parser createParser() {
        return new DomParser();
    }
}
