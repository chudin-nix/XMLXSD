package org.example.xmlxsd;

import org.example.xmlxsd.logic.Parser;
import org.example.xmlxsd.logic.SaxParser;
import org.example.xmlxsd.logic.XmlValidator;
import org.example.xmlxsd.model.Topaz;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class Director {
    Parser parser;
    XmlValidator validator;

    // тут пока заглушка
    List<Topaz> parse(String file) {

        return null;
    }

    public static void main(String[] args) {

        try {
            // создание SAX-анализатора
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SaxParser handler = new SaxParser();
            reader.setContentHandler(handler);
            reader.parse("file:///D:/Обучение/Java/Projects/XMLXSD/src/main/resources/Stones.xml");
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }
    }
}