package fr.istic.nplouzeau.aoc.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

/*
 * A class that prints a few hello world messages, using asynchronous calls
 * implemented by the ExecutorService.
 * Note that the use of sleep is not the best way to manage time in
 * real applications, better use ScheduledExecutorService instead.
 */
public class DelayedHello {

    private final ExecutorService executorService;

    public DelayedHello(int howManyThreads) {
        executorService = Executors.newFixedThreadPool(howManyThreads);
    }

    public void sayHello(int howManyHellos, long sleepTimeInMilliseconds)  {
        for (int i = 0; i < howManyHellos; i++) {
            executorService.submit(() -> {
                /* That's a Callable lambda, because it returns something
                 * and therefore the compiler infers it must be a Callable since call() returns a value
                 * If you don't put a return statement then the compiler will infer
                 * that's a Runnable (which cannot throw InterruptedException)
                 */

                Logger.getGlobal().info("Hello there!");


                    sleep(sleepTimeInMilliseconds); // Just to occupy the thread for demo purposes
                    return null;

            });
        }

    }
}
