package org.echocat.kata.java.part1.reader.model;

import java.util.List;

/**
 * This is our base class, a Print could be either a base parent for a Book or a Magaazine or something else ?.
 */
public abstract class AbstractPrint {

    private String isbn;
    private String title;

    public AbstractPrint(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    private List<Author> authorList;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
