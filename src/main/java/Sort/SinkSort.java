package Sort;

public class SinkSort extends Sort {
    @Override
    public void sort(int[] arr) {
        boolean changed = true;
        for (int k = arr.length - 1; k > 0 && changed; k--) {
            changed = false;
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j+1]) {
                    changed = true;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
