package gcr_codebase.stack_queue_hashmaps;

import java.util.Stack;

public class SortStackRecursion {

	public static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		int top = stack.pop();

		sortStack(stack);
		insertInSortedOrder(stack, top);

	}

	private static void insertInSortedOrder(Stack<Integer> stack, int top) {
		if (stack.isEmpty() || top >= stack.peek()) {
			stack.push(top);
			return;
		}
		int temp = stack.pop();
		insertInSortedOrder(stack, top);
		stack.push(temp);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(34);
		stack.push(3);
		stack.push(31);
		stack.push(98);
		stack.push(92);
		stack.push(23);

		System.out.println("Original Stack: " + stack);
		sortStack(stack);
		System.out.println("Sorted Stack: " + stack);
	}
}
