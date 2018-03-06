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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Test Case that Prints to Console tasks outputs.
 *
 * Only two methods are working:
 *
 * public void printOutAllPrintsToConsole()
 * printFromISBN()
 *
 * Did not had the time to finish the autthors part, but hopefully you can see what I did from a architecture or
 * solution perspective, of course this could be improved, validation, etc.
 *
 */
public class MainAppUnitTest {

    // Usually we could autwirder this service
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

        // get all books and magazines from service
        List<AbstractPrint> l = printService.findAllBooksAndMagazines();
        assertNotNull(l);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-- PRINT ALL TO CONSOLE -----------------------------------------------------------------");

        l.forEach(o -> printDetailToConsole(o));

    }

    /**
     * Find a book or magazine by its isbn.
     *
     * @throws PrintServiceException
     */
    @Test
    public void printFromISBN() throws PrintServiceException {

        final String lookingUpFor = "5454-5587-3210";
        final String expectedTitle = "Beautiful cooking";

        final AbstractPrint p = printService.findPrint(lookingUpFor);

        // should not be null and shall match the expected title
        assertNotNull(p);
        assertEquals(p.getTitle(), expectedTitle);

        // PRINT CONSOLE
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-- PRINT ISBN 5454-5587-3210 ------------------------------------------------------------");
        printDetailToConsole(p);
    }


    /**
     * Print to Console, we could use something fancier, such as JSON processor from here, but I focused on the
     * architecture of the service from an abstraction perspective.
     *
     * @param o
     */
    private void printDetailToConsole(final AbstractPrint o) {

        System.out.println("");
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
