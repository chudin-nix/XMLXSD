package org.example.xmlxsd.logic;

import org.example.xmlxsd.model.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.*;

public class SaxParser extends DefaultHandler implements Parser {


    private List<AbstractStone> stones;
    private AbstractStone current = null;
    private String currentElement = null;

    public SaxParser() {
        stones = new ArrayList<>();
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        switch (localName) {
            case "Topaz":
                current = new Topaz();
                break;
            case "Sapphire":
                current = new Sapphire();
                break;
            case "Brilliant":
                current = new Brilliant();
                break;
            default:
                currentElement = localName;

        }
    }
    public void endElement(String uri, String localName, String qName) {
        if ("Topaz".equals(localName) || "Sapphire".equals(localName) || "Brilliant".equals(localName))  {
            stones.add(current);
            current = null;
        }
        currentElement = null;

    }
    public void characters(char[] ch, int start, int length) {
        String text = new String(ch, start, length).trim();;
        if (currentElement != null) {
            switch (currentElement) {
                case "Transparency":
                    Transparency transparency = Transparency.valueOf(text);
                    ((Topaz) current).setTransparency(transparency);
                    break;
                case "Country":
                    ((Sapphire) current).setCountry(text);
                    break;
                case "Rarity":
                    if (current instanceof Sapphire) {
                        Rarity rarity = Rarity.valueOf(text);
                        ((Sapphire) current).setRarity(rarity);
                    } else {
                        Rarity rarity = Rarity.valueOf(text);
                        ((Brilliant) current).setRarity(rarity);
                    }
                    break;
                case "Hardness":
                    if (current instanceof Sapphire) {
                        Double hardness = ((Sapphire) current).getHardness();
                        ((Sapphire) current).setHardness(hardness);
                    }else {
                        Double hardness = ((Brilliant) current).getHardness();
                        ((Brilliant) current).setHardness(hardness);
                    }
                    break;
            }
        }
    }
    @Override
    public List<AbstractStone> parse(String file) {
        try {
            // создание SAX-анализатора
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.parse(file);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }
        return stones;
    }
}
