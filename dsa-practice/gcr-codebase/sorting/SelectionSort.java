package gcr_codebase.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void selectionSort(int[] scores) {
		int n = scores.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			// Find the minimum element in unsorted part
			for (int j = i + 1; j < n; j++) {
				if (scores[j] < scores[minIndex]) {
					minIndex = j;
				}
			}

			// Swap minimum with first unsorted element
			int temp = scores[minIndex];
			scores[minIndex] = scores[i];
			scores[i] = temp;
		}
	}

	// Driver code
	public static void main(String[] args) {
		int[] examScores = { 72, 88, 65, 90, 78 };

		selectionSort(examScores);

		System.out.println("Sorted Exam Scores:");
		System.out.println(Arrays.toString(examScores));
	}

}
