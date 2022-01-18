package fr.istic.nplouzeau.aoc.examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class ProdConsTest {

    private static final long TEST_CASE_MAX_EXECUTION_TIME = 5;
    private static final int QUEUE_CAPACITY = 10;
    private static final int NB_OF_VALUES = 10;
    private static final int PRODUCTION_PERIOD = 2;

    private Producer producer;
    private Consumer consumer;
    private ExecutorService executorService;

    @BeforeEach
    void setup() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
        producer = new Producer(queue, NB_OF_VALUES);
        consumer = new Consumer(queue, NB_OF_VALUES);
        executorService = Executors.newCachedThreadPool();
    }

    @AfterEach
    void stopThread() {
        executorService.shutdownNow();
    }

    @Test
    @DisplayName("Simple run, no oracle")
    void simpleRun() throws InterruptedException {
        executorService.submit(producer);
        executorService.submit(consumer);
        // Wait for the tasks to complete, at most TEST_TEST_CASE_MAX_EXECUTION_TIME seconds
        executorService.awaitTermination(TEST_CASE_MAX_EXECUTION_TIME, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Timed prod cons")
    void timedRun() {
        ForkJoinPool pool = new ForkJoinPool();

        pool.invoke(new RecursiveAction() {
                        @Override
                        protected void compute() {
                            BlockingQueue<String> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
                            TimedProducer timedProducer = new TimedProducer(queue, PRODUCTION_PERIOD);
                            TimedConsumer timedConsumer = new TimedConsumer(queue, PRODUCTION_PERIOD);
                            invokeAll(timedConsumer, timedProducer);
                        }
                    }
        );


    }

}
