//package org.example.xmlxsd.logic;
//
//public class ParserFactory {
//    SaxParser saxParser = new SaxParser();
//    DomParser domParser = new DomParser();
//
//    JaxbParser jaxbParser = new JaxbParser();
//
//    Parser create(Parser type) {
//        if (type.equals(domParser)) {
//            return new DomParser();
//        } else if (type.equals(saxParser)) {
//            return new SaxParser();
//        } else if (type.equals(jaxbParser)) {
//            return new JaxbParser();
//        }
//        throw new IllegalArgumentException("Unknown parser type: " + type);
//    }
//}