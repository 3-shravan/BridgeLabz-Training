package gcr_codebase.sorting;

import java.util.Arrays;

public class CountingSort {

	public static void countingSort(int[] ages) {
		int minAge = 10;
		int maxAge = 18;

		int range = maxAge - minAge + 1;
		int[] count = new int[range];
		int[] output = new int[ages.length];

		// Step 1: Count frequency of each age
		for (int age : ages) {
			count[age - minAge]++;
		}

		// Step 2: Compute cumulative count
		for (int i = 1; i < range; i++) {
			count[i] += count[i - 1];
		}

		// Step 3: Build output array (stable sort)
		for (int i = ages.length - 1; i >= 0; i--) {
			int age = ages[i];
			int index = count[age - minAge] - 1;
			output[index] = age;
			count[age - minAge]--;
		}

		// Step 4: Copy output to original array
		for (int i = 0; i < ages.length; i++) {
			ages[i] = output[i];
		}
	}

	// Driver code
	public static void main(String[] args) {
		int[] studentAges = { 15, 12, 14, 10, 18, 12, 16, 14 };

		countingSort(studentAges);

		System.out.println("Sorted Student Ages:");
		System.out.println(Arrays.toString(studentAges));
	}

}
