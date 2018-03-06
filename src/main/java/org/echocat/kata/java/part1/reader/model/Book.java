package org.echocat.kata.java.part1.reader.model;

/**
 * A Book (one of the Print derived classes)
 */
public class Book extends AbstractPrint {

    private String description;

    public Book(String isbn, String title, String description) {
        super(isbn, title);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
