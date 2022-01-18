package fr.istic.nplouzeau.aoc.examples.printing;

import java.util.concurrent.Future;

public interface PrintingAsync {
    // Rôle : Service
    Future<?> print(Document d);
}
