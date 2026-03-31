package gcr_codebase.stack_queue_hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubarrays {

    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int prefixSum = 0;
        map.put(0, new ArrayList<>(List.of(-1)));

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum)) {
                for (int startIndex : map.get(prefixSum)) {
                    System.out.println(
                        "Zero-sum subarray found from index "
                        + (startIndex + 1) + " to " + i
                    );
                }
            }

            map.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        findZeroSumSubarrays(arr);
    }
}