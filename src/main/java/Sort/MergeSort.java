package Sort;

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
            while (lIndex < mid && hIndex < high) {
                if (array[hIndex] < array[lIndex]) {
                    int tmp = array[hIndex];
                    System.arraycopy(array, lIndex, array, lIndex + 1, hIndex - lIndex);
                    array[lIndex] = tmp;
                    hIndex++;
                    lIndex++;
                    mid++;
                } else {
                    lIndex++;
                }
            }
        }
    }

}
