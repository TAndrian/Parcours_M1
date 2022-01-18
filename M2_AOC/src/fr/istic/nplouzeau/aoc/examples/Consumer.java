package fr.istic.nplouzeau.aoc.examples;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {

    private final int nbOfValues;
    private final BlockingQueue<String> input;

    public Consumer(BlockingQueue<String> queue, int nbOfValues) {
        input = queue;
        this.nbOfValues = nbOfValues;
    }


    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        Logger.getGlobal().log(Level.INFO,()->"Consumer is starting");

        try {
            for (int i = 0; i < nbOfValues; i++) {
                System.out.println(input.take());
            }
        } catch (InterruptedException e) {
            Logger.getGlobal().severe(()->"Interrupted exception caught");

        }
    }
}
