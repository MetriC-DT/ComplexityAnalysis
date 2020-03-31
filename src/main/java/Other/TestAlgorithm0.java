package Other;

import Complexity.*;

public class TestAlgorithm0 implements Complexity {
    @Override
    public long runTest(int complexity, Performance performance) {
        long start = System.nanoTime();
        i(complexity);
        long end = System.nanoTime();
        return end - start;
    }

    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    private void i(double n) {
        // example of a theta(n) algorithm
        if (n < 1) return;
        for (int i = 0; i < n; i++);
        i((999 * n) / 1000);
    }
}
