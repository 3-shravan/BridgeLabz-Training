package gcr_codebase.stack_queue_hashmaps;

import java.util.Stack;

public class QueueUsingStack {
	private Stack<Integer> stackEnq = new Stack<>();
	private Stack<Integer> stackDeq = new Stack<>();

	public void enqueue(int data) {
		stackEnq.push(data);
		System.out.println("Enqueued: " + data);
	}

	public int dequeue() {
		if (stackDeq.isEmpty()) {
			while (!stackEnq.isEmpty()) {
				stackDeq.push(stackEnq.pop());
			}
		}
		if (stackDeq.isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		return stackDeq.pop();
	}

	public int peek() {
		if (stackDeq.isEmpty()) {
			while (!stackEnq.isEmpty()) {
				stackDeq.push(stackEnq.pop());
			}
		}
		if (stackDeq.isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		return stackDeq.peek();
	}

	public boolean isEmpty() {
		return stackEnq.isEmpty() && stackDeq.isEmpty();
	}

	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println("Dequeued: " + queue.dequeue());
		System.out.println("Front element: " + queue.peek());
		System.out.println("Dequeued: " + queue.dequeue());
		System.out.println("Is queue empty? " + queue.isEmpty());
		System.out.println("Dequeued: " + queue.dequeue());
		System.out.println("Is queue empty? " + queue.isEmpty());
	}

}
