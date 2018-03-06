package org.echocat.kata.java.part1.reader;

public class PrintServiceException extends Exception {
    public PrintServiceException(String message) {
        super(message);
    }

    public PrintServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
