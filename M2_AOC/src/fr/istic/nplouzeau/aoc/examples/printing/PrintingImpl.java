package fr.istic.nplouzeau.aoc.examples.printing;

import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class PrintingImpl implements Printing {
    // Rôle : ConcreteServant
    @Override
    public void print(Document d) {
        try {
            Logger.getGlobal().info("J'imprime un joli document !");

            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
