package org.example.xmlxsd.logic;

public class SaxParserTest extends AbstractParserTest {
    @Override
    protected Parser createParser() {
        return new SaxParser();
    }
}
