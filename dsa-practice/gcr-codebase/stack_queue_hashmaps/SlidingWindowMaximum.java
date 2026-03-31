package gcr_codebase.stack_queue_hashmaps;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {

		int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] result = maxSlidingWindow(arr, k);
		for (int num : result) {
			System.out.print(num + " ");
		}
	}

	private static int[] maxSlidingWindow(int[] arr, int k) {

		int n = arr.length;
		int result[] = new int[n - k + 1];
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < arr.length; i++) {

			while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}

			while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
				deque.pollLast();
			}

			deque.offerLast(i);

			if (i >= k - 1) {
				result[i - k + 1] = arr[deque.peekFirst()];
			}

		}
		return null;
	}

}
