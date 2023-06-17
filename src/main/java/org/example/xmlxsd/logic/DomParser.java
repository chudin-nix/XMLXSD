package org.example.xmlxsd.logic;

import org.example.xmlxsd.model.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {
    private List<AbstractStone> stones;
    private DocumentBuilder docBuilder;
    public DomParser() {
        this.stones = new ArrayList<AbstractStone>();
        // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }
    public List<AbstractStone> getStones() {
        return stones;
    }
    public void buildSetStones(String fileName) {
        try {
            // parsing XML-документа и создание древовидной структуры
            Document doc;
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <>
            buildStones(root, "Topaz");
            buildStones(root, "Sapphire");
            buildStones(root, "Brilliant");
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private void buildStones(Element root, String name) {
        NodeList stonesList = root.getElementsByTagName(name);
        for (int i = 0; i < stonesList.getLength(); i++) {
            Element stonesElement = (Element) stonesList.item(i);
            AbstractStone stone;
            switch (name) {
                case "Topaz":
                    stone = buildTopaz(stonesElement);
                    break;
                case "Sapphire":
                    stone = buildSapphire(stonesElement);
                    break;
                case "Brilliant":
                    stone = buildBrilliant(stonesElement);
                    break;
                default:
                    throw new UnsupportedOperationException("UnknownElement =" + name);
            }
            stones.add(stone);
        }
    }

    private Topaz buildTopaz(Element stonesElement) {
        Topaz stone = new Topaz();
        // заполнение объекта stones
        String textElementTransparency = getElementTextContent(stonesElement, "Transparency");
        Transparency transparencyTopaz = Transparency. valueOf(textElementTransparency);

        stone.setTransparency(transparencyTopaz); // проверка на null
        stone.setName(getElementTextContent(stonesElement, "Name"));
        String type = getElementTextContent(stonesElement,"Type");
        TypeStone typeStoneElement = TypeStone.valueOf(type);
        stone.setType(typeStoneElement);

        return stone;
    }


    private Sapphire buildSapphire(Element stonesElement) {
        Sapphire stone = new Sapphire();
        // заполнение объекта stones
        stone.setName(getElementTextContent(stonesElement, "Name"));
        Double hardnessElement = Double.valueOf(getElementTextContent(stonesElement, "Hardness"));
        stone.setHardness(hardnessElement); // проверка на null
        TypeStone typeStoneElement = TypeStone.valueOf(getElementTextContent(stonesElement,"Type"));
        stone.setType(typeStoneElement);
        Rarity rarityElement = Rarity.valueOf(getElementTextContent(stonesElement, "Rarity"));
        stone.setRarity(rarityElement);
        String countryElement = getElementTextContent(stonesElement,"Country");
        stone.setCountry(countryElement);
        return stone;
    }

    private Brilliant buildBrilliant(Element stonesElement) {
        Brilliant stone = new Brilliant();
        // заполнение объекта stones
        stone.setName(getElementTextContent(stonesElement, "Name"));
        TypeStone typeStoneElement = TypeStone.valueOf(getElementTextContent(stonesElement,"Type"));
        stone.setType(typeStoneElement);
        Double hardnessElement = Double.valueOf(getElementTextContent(stonesElement,"Hardness"));
        stone.setHardness(hardnessElement); // проверка на null
        Rarity rarityElement = Rarity.valueOf(getElementTextContent(stonesElement,"Rarity"));
        stone.setRarity(rarityElement);
        Color colorElement = Color.valueOf(getElementTextContent(stonesElement,"Color"));
        stone.setColor(colorElement);
        Form formElement = Form.valueOf(getElementTextContent(stonesElement,"Form"));
        stone.setForm(formElement);
        return stone;
    }
    // получение текстового содержимого тега
    private String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    @Override
    public List<AbstractStone> parse(String file) {
        try {
            buildSetStones(file);
        } catch (DOMException e) {
            System.err.print("ошибка DOM парсера " + e);
        }
        return stones;
    }
}
