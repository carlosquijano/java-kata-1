package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.reader.PrintService;
import org.echocat.kata.java.part1.reader.PrintServiceException;
import org.echocat.kata.java.part1.reader.csv.PrintServiceImpl;
import org.echocat.kata.java.part1.reader.model.AbstractPrint;
import org.echocat.kata.java.part1.reader.model.Book;
import org.echocat.kata.java.part1.reader.model.Magazine;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainAppUnitTest {


    PrintService printService;

    @Before
    public void setUp() {
        // initialize our CSV implemntation of Print service.
        printService = new PrintServiceImpl();
    }

    @Test
    public void testGetHelloWorldText() throws Exception {
        assertThat(MainApp.getHelloWorldText(), is("Hello world!"));
    }

    /**
     * Print out all books and magazines (could be a GUI, console, …) with all their details (with a meaningful output format).
     *
     * @throws PrintServiceException
     */
    @Test
    public void printOutAllPrintsToConsole() throws PrintServiceException {
        PrintServiceImpl service = new PrintServiceImpl();
        service.findAllBooksAndMagazines().forEach(o -> printDetailToConsole(o));
    }


    /**
     * Print to Console, we could use something fancier, such as JSON processor from here, but I focused on the
     * architecture of the service from an abstraction perspective.
     *
     * @param o
     */
    private void printDetailToConsole(final AbstractPrint o) {

        if (o instanceof Book) {
            System.out.println("-- BOOK INFORMATION-------");
            System.out.println("BOOK ISBN : " +  o.getIsbn());
            System.out.println("BOOK TITLE : " + o.getTitle());
            System.out.println("BOOK DESCRIPTION : " + ((Book) o).getDescription());

        } else if (o instanceof Magazine) {
            System.out.println("-- MAGAZINE INFORMATION----");
            System.out.println("MAGAZINE ISBN : " +  o.getIsbn());
            System.out.println("MAGAZINE TITLE : " + o.getTitle());
            System.out.println("MAGAZINE PUBLISH DATE : " + ((Magazine) o).getPublishedAt());
        }

        System.out.println("");

    }



}
