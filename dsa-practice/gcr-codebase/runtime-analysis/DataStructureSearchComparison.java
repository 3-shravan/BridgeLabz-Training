import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureSearchComparison {

    public static void main(String[] args) {
        int n = 1_000_000;
        int target = n - 1;

        int[] arr = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long start = System.nanoTime();
        arraySearch(arr, target);
        long end = System.nanoTime();
        System.out.println("Array Search: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search: " + (end - start) / 1_000_000.0 + " ms");
    }

    static boolean arraySearch(int[] arr, int target) {
        for (int i : arr) {
            if (i == target)
                return true;
        }
        return false;
    }
}
