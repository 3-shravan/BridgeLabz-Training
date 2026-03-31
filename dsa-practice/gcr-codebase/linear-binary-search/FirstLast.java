public class FirstLast {
    static int first(int[] arr, int target) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) {
                res = m;
                r = m - 1;
            } else if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return res;
    }

    static int last(int[] arr, int target) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) {
                res = m;
                l = m + 1;
            } else if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return res;
    }
}
