package fr.istic.nplouzeau.aoc.examples.printing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class PrintingProxy implements PrintingAsync {

    private final ExecutorService executorService = Executors.newFixedThreadPool(1);
    private final Printing servant = new PrintingImpl();

    // Rôle : Proxy
    @Override
    public Future<?> print(Document d) {
        return executorService.submit(() -> {
            servant.print(d);
        });
    }
}
