package org.echocat.kata.java.part1.reader;

import org.echocat.kata.java.part1.reader.model.AbstractPrint;

import java.util.List;

/**
 * Main tasks Service.
 * See https://github.com/carlosquijano/java-kata-1#main-tasks
 *
 */
public interface PrintService {

    /**
     *
     * @throws PrintServiceException
     */
    List<AbstractPrint> findAllBooksAndMagazines() throws PrintServiceException;


    /**
     * Find all books and magazines by their authors’ email.
     *
     * @param authorEmail
     * @throws PrintServiceException
     */
    List<AbstractPrint> findAllBooksAndMagazines(String authorEmail) throws PrintServiceException;

    /**
     * Find a book or magazine by its isbn.
     *
     * @param isbn
     * @throws PrintServiceException
     */
    AbstractPrint findPrint(String isbn) throws PrintServiceException;
}
