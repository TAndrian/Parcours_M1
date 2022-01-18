package fr.istic.nplouzeau.aoc.examples;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class TimedConsumer extends RecursiveAction {

    private final BlockingQueue<String> input;
    private final int periodInSeconds;
    private final ScheduledExecutorService executor;

    public TimedConsumer(BlockingQueue<String> queue, int periodInSeconds) {
        input = queue;
        this.periodInSeconds = periodInSeconds;
        executor = Executors.newSingleThreadScheduledExecutor();
    }


    /**
     * The main computation performed by this task.
     */
    @Override
    protected void compute() {
        ScheduledFuture<?> future =
            executor.scheduleAtFixedRate(() -> {
                try {
                    System.out.println(input.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, 0, periodInSeconds, TimeUnit.SECONDS);
        try {
            sleep(10000);
            future.cancel(true);
         } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
