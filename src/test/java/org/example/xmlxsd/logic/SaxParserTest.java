package org.example.xmlxsd.logic;

import org.example.xmlxsd.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SaxParserTest {

    @Test
    public void testParseShouldReadStonesXMLWhenXMLFilesPassed () {
        //given
        SaxParser saxParser = new SaxParser();

        //when
        List<AbstractStone> stones = saxParser.parse("./src/test/resources/Stones.xml");

        //then
        Assert.assertEquals(3, stones.size());
        AbstractStone stone = stones.get(0);
        Assert.assertTrue(stone instanceof Topaz);
        Topaz topaz = (Topaz) stone;
        Assert.assertEquals(Transparency.TRANSPARENT, topaz.getTransparency());
    }
    @Test
    public void testParseShouldReadStonesXMLWhenObjectSapphireHaveFieldCountry () {
        //
        SaxParser saxParser = new SaxParser();

        //when
        List<AbstractStone> stones = saxParser.parse("./src/test/resources/Stones.xml");

        //then
        AbstractStone stone = stones.get(1);
        Assert.assertTrue(stone instanceof Sapphire);
        Sapphire sapphire = (Sapphire) stone;
        Assert.assertEquals("USA", sapphire.getCountry());
    }

    @Test
    public void testParseShouldReadStonesXMLWhenObjectSapphireHaveFieldRarity () {
        //given
        SaxParser saxParser = new SaxParser();

        //when
        List<AbstractStone> stones = saxParser.parse("./src/test/resources/Stones.xml");

        //then
        AbstractStone stone = stones.get(1);
        Assert.assertTrue(stone instanceof Sapphire);
        Sapphire sapphire = (Sapphire) stone;
        Assert.assertEquals(Rarity.NON_RARE, sapphire.getRarity());

    }

    @Test
    public void testParse () {
        //given
        SaxParser saxParser = new SaxParser();
        Double hardness = -42640699999999.8;

        //when
        List<AbstractStone> stones = saxParser.parse("./src/test/resources/Stones.xml");

        //then
        AbstractStone stone = stones.get(1);
        Assert.assertTrue(stone instanceof Sapphire);
        Sapphire sapphire = (Sapphire) stone;
        Assert.assertEquals(hardness, sapphire.getHardness());
    }
}

