package fr.istic.nplouzeau.aoc.examples;

import java.time.LocalDateTime;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class TimedProducer extends RecursiveAction {
    private final BlockingQueue<String> output;
    private final int periodInSeconds;
    private final ScheduledExecutorService executor;

    public TimedProducer(BlockingQueue<String> queue, int periodInSeconds) {
        output = queue;
        this.periodInSeconds = periodInSeconds;
        executor = Executors.newSingleThreadScheduledExecutor();
    }


    /**
     * The main computation performed by this task.
     */
    @Override
    protected void compute() {
        // Every periodInSeconds seconds, write the current time in the output queue
        ScheduledFuture<?> future =
            executor.scheduleAtFixedRate(() -> {
                try {
                    output.put(LocalDateTime.now().toString());
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
