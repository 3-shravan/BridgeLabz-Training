public class RotationPoint {
    static int findMin(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[r])
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
