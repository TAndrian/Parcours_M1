package fr.istic.nplouzeau.aoc.examples;

import org.junit.jupiter.api.Test;

public class NoisyOutputTest {

    @Test
    void runNoisy() {
        NoisyOutput noisyOutput = new NoisyOutput(System.err);

        noisyOutput.generate(10);
    }
}
