import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    public static void main(String[] args) {
        int size = 10_000;
        int[] arr1 = randomArray(size);
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        long start = System.nanoTime();
        bubbleSort(arr1);
        long end = System.nanoTime();
        System.out.println("Bubble Sort: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        Arrays.sort(arr2); // Merge/TimSort
        end = System.nanoTime();
        System.out.println("Merge Sort (TimSort): " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        end = System.nanoTime();
        System.out.println("Quick Sort: " + (end - start) / 1_000_000.0 + " ms");
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;
        return i + 1;
    }

    static int[] randomArray(int size) {
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(size);
        }
        return arr;
    }
}
