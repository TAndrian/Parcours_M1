package fr.istic.nplouzeau.aoc.examples;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class DelayedHelloTest {

    @Test
    void delayOne() throws InterruptedException {
        /*
        * Two messages will print at once (cause we have 2 threads)
        * and the third one will have to wait
         */
        DelayedHello delayedHello = new DelayedHello(2);
        delayedHello.sayHello(3, 3000);

        sleep(10000); // Needed because delayedHello uses asynchronous execution
        Logger.getGlobal().info("Fin du cas de test");

    }

}
