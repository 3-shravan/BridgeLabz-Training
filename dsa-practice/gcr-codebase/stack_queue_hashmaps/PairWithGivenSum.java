package gcr_codebase.stack_queue_hashmaps;

import java.util.HashMap;
import java.util.Map;

public class PairWithGivenSum {

	public static void findPair(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int required = target - arr[i];

			if (map.containsKey(required)) {
				System.out.println("Pair found: " + required + " and " + arr[i]);
				return;
			}
			map.put(arr[i], i);
		}

		System.out.println("No pair found");
	}

	public static void main(String[] args) {
		int[] arr = { 8, 7, 2, 5, 3, 1 };
		int target = 10;
		findPair(arr, target);
	}
}
