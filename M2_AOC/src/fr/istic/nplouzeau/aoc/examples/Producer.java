package fr.istic.nplouzeau.aoc.examples;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    private final int nbOfValues;
    private BlockingQueue<String> output;

    public Producer(BlockingQueue<String> queue, int nbOfValues) {
        output = queue;
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
        Logger.getGlobal().log(Level.INFO,"Producer is starting");
        try {
            for (int i = 0; i < nbOfValues; i++) {
                output.put(String.valueOf(i));
            }
        } catch (InterruptedException e) {
            Logger.getGlobal().severe("Interrupted exception caught");
        }
    }
}
