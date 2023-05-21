package org.example.xmlxsd.logic;

import org.example.xmlxsd.model.AbstractStone;
import org.example.xmlxsd.model.Topaz;
import org.example.xmlxsd.model.Transparency;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaxParser extends DefaultHandler implements Parser {

    // тут я создаю set с типом Topaz, т.к. у меня xml с топазом
    private Set<Topaz> stones;
    private Topaz current = null;
    private Transparency currentEnum = null;
    private EnumSet<Transparency> withText;

    // тут пока написал так, потому что у меня в XML Topaz
    public SaxParser() {
        stones = new HashSet<Topaz>();
        withText = EnumSet.range(Transparency.TRANSPARENT, Transparency.NON_TRANSPARENT);
    }
    public Set<Topaz> getStones() {

        return stones;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("Topaz".equals(localName)) {
            current = new Topaz();
            String firstAttributes = attrs.getValue(0);
            //вот тут первый атрибут Stones.xsd, я ожидал что это будет TRANSPARENT, нужно разобраться почему
            current.setTransparency(Transparency.valueOf(firstAttributes));
            if (attrs.getLength() == 2) {
                String secondAttributes = attrs.getValue(1);
                current.setTransparency(Transparency.valueOf(secondAttributes));
            }
        } else {
            Transparency temp = Transparency.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if ("stones".equals(localName)) {
            stones.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case TRANSPARENT, NON_TRANSPARENT:
                    current.setTransparency(Transparency.valueOf(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
    @Override
    public List<AbstractStone> parse(String file) {
        return null;
    }
}
