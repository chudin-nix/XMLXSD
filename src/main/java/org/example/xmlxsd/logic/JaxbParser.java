package org.example.xmlxsd.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.example.xmlxsd.ParserException;
import org.example.xmlxsd.model.AbstractStone;
import org.example.xmlxsd.model.Stones;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.List;

public class JaxbParser implements Parser {
    @Override
    public List<AbstractStone> parse(String file) throws ParserException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Stones.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader("./src/test/resources/Stones.xml");
            Stones stones = (Stones) unmarshaller.unmarshal(reader);
            return stones.getStones();
        } catch (JAXBException | FileNotFoundException e) {
            throw new ParserException(e.getMessage(), e);
        }
    }
}
