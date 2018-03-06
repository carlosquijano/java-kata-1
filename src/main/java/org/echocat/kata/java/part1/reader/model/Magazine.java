package org.echocat.kata.java.part1.reader.model;

/**
 * A Magazine (one of the Print derived classes)
 */
public class Magazine extends AbstractPrint {

    private String publishedAt;

    public Magazine(String isbn, String title, String publishedAt) {
        super(isbn, title);
        this.publishedAt = publishedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
