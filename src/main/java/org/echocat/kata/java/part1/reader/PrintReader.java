package org.echocat.kata.java.part1.reader;

import org.echocat.kata.java.part1.reader.model.AbstractPrint;

import java.util.List;

public interface PrintReader<T extends AbstractPrint> {

    List<T> readAll() throws PrintServiceException;

}
