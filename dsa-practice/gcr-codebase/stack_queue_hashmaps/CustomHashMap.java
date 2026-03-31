package gcr_codebase.stack_queue_hashmaps;

public class CustomHashMap<K, V> {

	// Node class for Linked List
	private static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private static final int DEFAULT_CAPACITY = 16;
	private Entry<K, V>[] buckets;
	private int size;

	@SuppressWarnings("unchecked")
	public CustomHashMap() {
		buckets = new Entry[DEFAULT_CAPACITY];
		size = 0;
	}

	// Hash function
	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % buckets.length;
	}

	// PUT operation
	public void put(K key, V value) {
		int index = getIndex(key);
		Entry<K, V> head = buckets[index];

		// Update if key exists
		Entry<K, V> current = head;
		while (current != null) {
			if (current.key.equals(key)) {
				current.value = value;
				return;
			}
			current = current.next;
		}

		// Insert new entry
		Entry<K, V> newEntry = new Entry<>(key, value);
		newEntry.next = head;
		buckets[index] = newEntry;
		size++;
	}

	// GET operation
	public V get(K key) {
		int index = getIndex(key);
		Entry<K, V> current = buckets[index];

		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		return null;
	}

	// REMOVE operation
	public void remove(K key) {
		int index = getIndex(key);
		Entry<K, V> current = buckets[index];
		Entry<K, V> prev = null;

		while (current != null) {
			if (current.key.equals(key)) {
				if (prev == null) {
					buckets[index] = current.next;
				} else {
					prev.next = current.next;
				}
				size--;
				return;
			}
			prev = current;
			current = current.next;
		}
	}

	// SIZE
	public int size() {
		return size;
	}

	// DISPLAY (for debugging)
	public void display() {
		for (int i = 0; i < buckets.length; i++) {
			Entry<K, V> current = buckets[i];
			System.out.print("Bucket " + i + ": ");
			while (current != null) {
				System.out.print("[" + current.key + "=" + current.value + "] -> ");
				current = current.next;
			}
			System.out.println("null");
		}
	}

	// MAIN METHOD (Testing)
	public static void main(String[] args) {
		CustomHashMap<String, Integer> map = new CustomHashMap<>();

		map.put("apple", 10);
		map.put("banana", 20);
		map.put("orange", 30);
		map.put("apple", 40); // update

		System.out.println("apple: " + map.get("apple")); // 40
		System.out.println("banana: " + map.get("banana")); // 20

		map.remove("banana");
		System.out.println("banana: " + map.get("banana")); // null

		System.out.println("Size: " + map.size());

		map.display();
	}
}
