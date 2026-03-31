package gcr_codebase.stack_queue_hashmaps;

import java.util.Stack;

public class StockSpanProblem {

	public static void main(String[] args) {
		int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
		int[] span = calculateSpan(prices);
		for (int s : span) {
			System.out.print(s + " ");
		}

	}

	private static int[] calculateSpan(int[] prices) {

		int n = prices.length;
		int[] span = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}
			span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
			stack.push(i);

		}
		return span;

	}
}
