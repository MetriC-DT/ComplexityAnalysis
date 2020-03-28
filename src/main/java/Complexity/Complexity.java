package Complexity;

public interface Complexity {

    /**
     * Runs the test and returns the time in nanoseconds it took to complete.
     * @param complexity the complexity of the test (i.e. size of array)
     * @param performance BEST, WORST, AVERAGE
     * @return time in nanoseconds test completed
     */
    long runTest(int complexity, Performance performance);

    /**
     * Name of item/algorithm tested
     * @return name
     */
    String name();
}
