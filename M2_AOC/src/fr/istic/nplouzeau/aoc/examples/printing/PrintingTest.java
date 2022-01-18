package fr.istic.nplouzeau.aoc.examples.printing;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class PrintingTest {
    // Rôle : Client

    @Test
    void testSimple() throws InterruptedException, ExecutionException {
        PrintingAsync printingAsync = new PrintingProxy();
        Document d = new Document();

        Future<?> f = printingAsync.print(d);
        f.get();
        Logger.getGlobal().info("L'impression est finie !");
    }
}
