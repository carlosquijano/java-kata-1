package org.echocat.kata.java.part1.reader.csv;

import org.echocat.kata.java.part1.reader.PrintService;
import org.echocat.kata.java.part1.reader.PrintServiceException;
import org.echocat.kata.java.part1.reader.model.AbstractPrint;
import org.echocat.kata.java.part1.reader.model.Book;
import org.echocat.kata.java.part1.reader.model.Magazine;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * CSV Implementation for PrintService.
 *
 */
public class PrintServiceImpl implements PrintService {

    public static final String DATA_RESOURCE_PATH = "org/echocat/kata/java/part1/data/";

    @Override
    public List<AbstractPrint> findAllBooksAndMagazines() throws PrintServiceException {

        // holder for our prints objects
        List<AbstractPrint> list = new LinkedList<>();

        // stream books to list
        streamLinesFromResource("books.csv", true)
                .map(line -> Arrays.asList(line.split(";")))
                .map(b -> new Book(b.get(1), b.get(0), b.get(3)))
                .forEachOrdered(list::add);

        // stream magazines to list
        streamLinesFromResource("magazines.csv", true)
                .map(line -> Arrays.asList(line.split(";")))
                .map(b -> new Magazine(b.get(1), b.get(0), b.get(3)))
                .forEachOrdered(list::add);

        // sort list by title
        list.sort(Comparator.comparing(AbstractPrint::getTitle));

        return list;

    }

    @Override
    public AbstractPrint findPrint(String isbn) {
        return  null;
    }

    @Override
    public List<AbstractPrint> findAllBooksAndMagazines(String authorEmail) {
        return  null;
    }



    /**
     * Read lines from resources in data classpath.
     *
     * @param resourceName the name of resource (it should existe in the data package)
     * @param skipFirstLine true if we want to skip the first line, usually a header
     * @return
     * @throws PrintServiceException
     */
    private Stream<String> streamLinesFromResource(final String resourceName, boolean skipFirstLine) throws PrintServiceException {
        try {
            final String resourcePath = DATA_RESOURCE_PATH + resourceName;
                return Files.lines(Paths.get(ClassLoader.getSystemResource(resourcePath).toURI())).skip((skipFirstLine) ? 1 : 0);
        } catch (IOException | URISyntaxException e) {
            throw new PrintServiceException("Error retrieving data", e);
        }
    }


}
