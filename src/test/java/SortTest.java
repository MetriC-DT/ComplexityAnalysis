import Sort.*;
import Sort.Sort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class SortTest {

    /**
     * Creates an array of 2000 integers, random numbers.
     * @param s sorter to sort array
     */
    void sortTestRandom(Sort s) {
        int[] arr1 = Sort.generateRandomArray(2000);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        assertArrayEquals(arr1, arr2);

        Arrays.sort(arr1);
        s.sort(arr2);
        assertArrayEquals(arr1, arr2);
    }

    /**
     * Creates an array of descending integers.
     * @param s sorter to sort array
     */
    void sortTestDescending(Sort s) {
        int[] arr1 = Sort.generateDescendingArray(2000);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        assertArrayEquals(arr1, arr2);

        Arrays.sort(arr1);
        s.sort(arr2);
        assertArrayEquals(arr1, arr2);
    }

    /**
     * Creates an array of increasing integers.
     * @param s sorter to sort array.
     */
    void sortTestAscending(Sort s) {
        int[] arr1 = Sort.generateAscendingArray(2000);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        assertArrayEquals(arr1, arr2);

        Arrays.sort(arr1);
        s.sort(arr2);
        assertArrayEquals(arr1, arr2);
    }

    /**
     * Tests random, ascending, and descending arrays for s.
     * @param s sorter to sort array
     */
    void testAllCases(Sort s) {
        sortTestRandom(s);
        sortTestAscending(s);
        sortTestDescending(s);
    }

    @Test
    void bubbleSortTest() {
        testAllCases(new BubbleSort());
    }

    @Test
    void MergeSortTest() {
        testAllCases(new MergeSort());
    }

    @Test
    void BadMergeSortTest() {
        testAllCases(new BadMergeSort());
    }

    @Test
    void SinkSortTest() {
        testAllCases(new SinkSort());
    }

    @Test
    void QuickSortTest() {
        testAllCases(new QuickSort());
    }
}
