public class PeakElement {
    static int findPeak(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if ((m == 0 || arr[m] > arr[m - 1]) &&
                (m == arr.length - 1 || arr[m] > arr[m + 1]))
                return m;
            else if (m > 0 && arr[m] < arr[m - 1]) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }
}
