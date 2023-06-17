package org.example.xmlxsd.logic;

public class JaxbParserTest extends AbstractParserTest{
    @Override
    protected Parser createParser() {
        return new JaxbParser();
    }
}
