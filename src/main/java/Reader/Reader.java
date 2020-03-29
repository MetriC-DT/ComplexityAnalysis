package Reader;

import Complexity.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Reader implements Complexity {
    static String filename = "READER.txt";

    /**
     * Runs the test and returns the time in nanoseconds it took to complete.
     * @param complexity  the complexity of the test (i.e. size of array)
     * @param performance BEST, WORST, AVERAGE
     * @return time in nanoseconds test completed
     */
    @Override
    public long runTest(int complexity, Performance performance) {
        generateIntStringFile(complexity);
        long start = System.nanoTime();
        read();
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Reads a string from file line by line.
     */
    public abstract void read();

    /**
     * Reads integers from a file
     */
    public abstract void readInt();

    /**
     * Name of item/algorithm tested
     * @return name
     */
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    /**
     * Generates a string of integers and saves it to file
     * @param length number of integers
     */
    public static void generateIntStringFile(int length) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            s.append(i).append("\n");
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(s.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
