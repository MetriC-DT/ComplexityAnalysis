import Sort.*;
import Sort.Sort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class SortTest {

    void sortTestRandom(Sort s) {
        int[] arr1 = Sort.generateRandomArray(2000);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        assertArrayEquals(arr1, arr2);

        Arrays.sort(arr1);
        s.sort(arr2);
        assertArrayEquals(arr1, arr2);
    }

    void sortTestDescending(Sort s) {
        int[] arr1 = Sort.generateDescendingArray(2000);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        assertArrayEquals(arr1, arr2);

        Arrays.sort(arr1);
        s.sort(arr2);
        assertArrayEquals(arr1, arr2);
    }

    void sortTestAscending(Sort s) {
        int[] arr1 = Sort.generateAscendingArray(2000);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        assertArrayEquals(arr1, arr2);

        Arrays.sort(arr1);
        s.sort(arr2);
        assertArrayEquals(arr1, arr2);
    }

    @Test
    void bubbleSortTest() {
        Sort s = new BubbleSort();
        sortTestRandom(s);
        sortTestAscending(s);
        sortTestDescending(s);
    }

    @Test
    void MergeSortTest() {
        Sort s = new MergeSort();
        sortTestRandom(s);
        sortTestAscending(s);
        sortTestDescending(s);
    }

    @Test
    void SinkSortTest() {
        Sort s = new SinkSort();
        sortTestRandom(s);
        sortTestAscending(s);
        sortTestDescending(s);
    }

    @Test
    void QuickSortTest() {
        Sort s = new QuickSort();
        sortTestRandom(s);
        sortTestAscending(s);
        sortTestDescending(s);
    }
}
