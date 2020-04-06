package Sort;

import java.util.Arrays;

public class MergeSort extends Sort {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    /**
     * applies mergesort to an array from index low to high
     * @param array array to mergesort
     * @param low lower bound
     * @param high top bound
     */
    private void mergeSort(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;
        } else {
            int mid = (high + low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid, high);

            int lIndex = low;
            int hIndex = mid;
            int i = 0;

            // we will never need the entire space between high and low
            int[] merged = new int[high - low - 1];

            while (lIndex < mid && hIndex < high) {
                if (array[hIndex] < array[lIndex]) {
                    merged[i++] = array[hIndex++];
                } else {
                    merged[i++] = array[lIndex++];
                }
            }

            if (lIndex < mid) {
                // copies the highest numbers between low and high to the highest position possible < high
                System.arraycopy(array, lIndex, array, high - mid + lIndex, mid - lIndex);

                // copies numbers from merged back into array[]
                System.arraycopy(merged, 0, array, low, i);
            } else {
                // we do not need to copy the highest numbers mid <= n < high
                // into the highest positions < high since they should be in
                // place anyway
                // copies numbers from merged back into array[]
                System.arraycopy(merged, 0, array, low, i);
            }
        }
    }
}
