package org.example.xmlxsd;

public class ParserException extends Exception {
    public ParserException (String message, Exception parent) {
        super(message, parent);
    }
}
