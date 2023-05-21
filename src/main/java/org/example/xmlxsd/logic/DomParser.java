package org.example.xmlxsd.logic;

import org.example.xmlxsd.model.AbstractStone;
import org.example.xmlxsd.model.Topaz;
import org.example.xmlxsd.model.Transparency;
import org.example.xmlxsd.model.TypeStone;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DomParser implements Parser {
    private Set<Topaz> stones;
    private DomParser docBuilder;
    public StudentsDOMBuilder() {
        this.stones = new HashSet<Topaz>();
        // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }
    public Set<Topaz> getStudents() {
        return stones;
    }
    public void buildSetStones(String fileName) {
        Document doc = null;
        try {
            // parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <student>
            NodeList studentsList = root.getElementsByTagName("student");
            for (int i = 0; i < studentsList.getLength(); i++) {
                Element stonesElement = (Element) studentsList.item(i);
                Topaz stones = buildStones(stonesElement);
                stones.add(stones);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }
    private Topaz buildStones(Element stonesElement) {
        Topaz stones = new Topaz();
        // заполнение объекта stones
        Transparency transparencyAttribute = Transparency.valueOf(stonesElement.getAttribute("transparency"));
        stones.setTransparency(transparencyAttribute); // проверка на null
        stones.setName(getElementTextContent(stonesElement, "name"));
        TypeStone typeStoneAttribute = TypeStone.valueOf(stonesElement.getAttribute("type"));
        stones.setType(typeStoneAttribute);
        return stones;
    }
    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    @Override
    public List<AbstractStone> parse(String file) {
        return null;
    }
}
