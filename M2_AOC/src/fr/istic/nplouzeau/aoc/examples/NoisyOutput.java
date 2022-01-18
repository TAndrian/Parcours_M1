package fr.istic.nplouzeau.aoc.examples;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * A perfectly useless class that writes at random intervals in a print stream,
 * generating a bad random sequence of digits in the most time inefficient possible way ;)
 */
public class NoisyOutput {

    private static final int POOL_SIZE = 10;
    private static final long MAX_WAITING_PER_DIGIT_IN_MS = 1000;
    private final PrintStream output;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(POOL_SIZE);

    public NoisyOutput(PrintStream output) {
        this.output = output;
    }

    public void generate(int howManyDigits) {
        Random random = new Random();

        for (int i = 0; i < howManyDigits; i++) {
            int finalI = i; // Needed because in the lambda body we use the loop index, which is not final obviously

            // Launch an asynchronous execution of a lambda that will write a number
            // in the stream after a random delay between 0 and 999 milliseconds
            executorService.schedule(() -> output.print(finalI % 10),
                random.nextInt() % MAX_WAITING_PER_DIGIT_IN_MS, TimeUnit.MILLISECONDS);
        }
        try {
            // Be patient, we need some time to let all a number of howManyDigits
            // asynchronous to finish... This is a vastly oversized upper bound for the delay
            executorService.awaitTermination(MAX_WAITING_PER_DIGIT_IN_MS * howManyDigits, TimeUnit.MILLISECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
