package org.example.xmlxsd.logic;

import org.example.xmlxsd.ParserException;
import org.example.xmlxsd.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

public abstract class AbstractParserTest {

    @Test
    public void testParseShouldParseStonesXMLWhenStoneTopazHasFieldTransparency () throws ParserException {
        //given
        Parser parser = createParser();

        //when
        List<AbstractStone> stones = parser.parse("./src/test/resources/Stones.xml");

        //then
        Assert.assertEquals(3, stones.size());
        AbstractStone stone = stones.get(0);
        Assert.assertTrue(stone instanceof Topaz);
        Topaz topaz = (Topaz) stone;
        Assert.assertEquals(Transparency.TRANSPARENT, topaz.getTransparency());
    }

    @Test
    public void testParseShouldParseStonesXMLWhenStoneTopazHasFieldTypeStone () throws ParserException {
        //given
        Parser parser = createParser();

        //when
        List<AbstractStone> stones = parser.parse("./src/test/resources/Stones.xml");

        //then
        AbstractStone stone = stones.get(0);
        Assert.assertTrue(stone instanceof Topaz);
        Topaz topaz = (Topaz) stone;
        Assert.assertEquals(TypeStone.NON_PRECIOUS, topaz.getType());

    }

    @Test
    public void testParseShouldParseStonesXMLWhenStoneTopazHazFieldName () throws ParserException {
        //given
        Parser parser = createParser();
        //todo переделать на конкретное имя камня
        String testString = "nameTest";

        //when
        List<AbstractStone> stones = parser.parse("./src/test/resources/Stones.xml");

        //then
        AbstractStone stone = stones.get(0);
        Assert.assertTrue(stone instanceof Topaz);
        Topaz topaz = (Topaz) stone;
        String topazName = topaz.getName();
        Assert.assertEquals(testString.getClass(), topazName.getClass());
    }
    @Test
    public void testParseShouldParseStonesXMLWhenStoneSapphireHasFieldCountry () throws ParserException {
        //
        Parser parser = createParser();

        //when
        List<AbstractStone> stones = parser.parse("./src/test/resources/Stones.xml");

        //then
        AbstractStone stone = stones.get(1);
        Assert.assertTrue(stone instanceof Sapphire);
        Sapphire sapphire = (Sapphire) stone;
        Assert.assertEquals("USA", sapphire.getCountry());
    }

    @Test
    public void testParseShouldParseStonesXMLWhenStoneSapphireHasFieldRarity () throws ParserException {
        //given
        Parser parser = createParser();

        //when
        List<AbstractStone> stones = parser.parse("./src/test/resources/Stones.xml");

        //then
        AbstractStone stone = stones.get(1);
        Assert.assertTrue(stone instanceof Sapphire);
        Sapphire sapphire = (Sapphire) stone;
        Assert.assertEquals(Rarity.NON_RARE, sapphire.getRarity());

    }

    @Test
    public void testParseShouldParseStonesXMLWhenStoneSapphireHasFieldHardness () throws ParserException {
        //given
        Parser parser = createParser();
        Double hardness = -42640699999999.8;

        //when
        List<AbstractStone> stones = parser.parse("./src/test/resources/Stones.xml");

        //then
        AbstractStone stone = stones.get(1);
        Assert.assertTrue(stone instanceof Sapphire);
        Sapphire sapphire = (Sapphire) stone;
        Assert.assertEquals(hardness, sapphire.getHardness());
    }

    @Test
    public void testParseShouldParseStonesXMLWhenStoneSapphireHasFieldTypeStone () throws ParserException {
        //given
        Parser parser = createParser();

        //when
        List<AbstractStone> stones = parser.parse("./src/test/resources/Stones.xml");

        //then
        AbstractStone stone = stones.get(1);
        Assert.assertTrue(stone instanceof Sapphire);
        Sapphire sapphire = (Sapphire) stone;
        Assert.assertEquals(TypeStone.PRECIOUS, sapphire.getType());
    }

    @Test
    public void testParseShouldParseStonesXMLWhenStoneSapphireHasFiledName () throws ParserException {
        //given
        Parser parser = createParser();
        //todo переделать на конкретное имя камня
        String testString = "testName";

        //when
        List<AbstractStone> stones = parser.parse("./src/test/resources/Stones.xml");

        //then
        AbstractStone stone = stones.get(1);
        Assert.assertTrue(stone instanceof Sapphire);
        Sapphire sapphire = (Sapphire) stone;
        String nameStone = sapphire.getName();
        Assert.assertEquals(testString.getClass(), nameStone.getClass());
    }

    @Test
    public void testParseShouldParseNotValidStonesXMLWhenFileIsNotValid () throws ParserException {
        //given
        Parser parser = createParser();

        //when
        List<AbstractStone> stones = parser.parse("./src/test/resources/NotValidStones.xml");

        //then

    }
    protected abstract Parser createParser ();
}

