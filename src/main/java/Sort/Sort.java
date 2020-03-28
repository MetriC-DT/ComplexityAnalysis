package Sort;

import Complexity.*;

import java.util.Random;

public abstract class Sort implements Complexity {
    static Random r = new Random();

    public abstract void sort(int[] arr);

    /**
     * generates an array of random integers with size complexity.
     * @param complexity size of array
     * @return random integer array with size complexity
     */
    static int[] generateRandomArray(int complexity) {
        int[] arr = new int[complexity];
        for (int i = 0; i < complexity; i++) {
            arr[i] = r.nextInt();
        }
        return arr;
    }

    /**
     * generates an array of increasing integers with size complexity.
     * @param complexity size of array
     * @return increasing integer array with size complexity
     */
    static int[] generateAscendingArray(int complexity) {
        int[] arr = new int[complexity];
        for (int i = 0; i < complexity; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * generates array of descending integers
     * @param complexity size of array
     * @return descending integer array with size complexity
     */
    static int[] generateDescendingArray(int complexity) {
        int[] arr = new int[complexity];
        for (int i = 0; i < complexity; i++) {
            arr[i] = complexity - i;
        }
        return arr;
    }

    @Override
    public long runTest(int complexity, Performance performance) {
        int[] arr;
        if (performance == Performance.AVERAGE) {
            arr = generateRandomArray(complexity);
        } else if (performance == Performance.BEST) {
            arr = generateAscendingArray(complexity);
        } else {
            arr = generateDescendingArray(complexity);
        }

        long start = System.nanoTime();
        sort(arr);
        long end = System.nanoTime();
        return end - start;
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }
}
