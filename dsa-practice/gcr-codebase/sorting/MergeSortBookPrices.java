package gcr_codebase.sorting;

import java.util.Arrays;

public class MergeSortBookPrices {
	public static void main(String[] args) {
		int[] bookPrices = { 499, 299, 799, 199, 599 };
		mergeSort(bookPrices, 0, bookPrices.length - 1);

		System.out.println("Sorted Book Prices:");
		System.out.println(Arrays.toString(bookPrices));

	}

	private static void mergeSort(int[] bookPrices, int left, int right) {
		if (right > left) {

			int mid = left + (right - left) / 2;
			mergeSort(bookPrices, left, mid);
			mergeSort(bookPrices, mid + 1, right);

			merge(bookPrices, left, mid, right);
		}

	}

	private static void merge(int[] bookPrices, int left, int mid, int right) {

		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];
		for (int i = 0; i < n1; i++) {
			leftArray[i] = bookPrices[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArray[j] = bookPrices[mid + 1 + j];
		}
		int i = 0, j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				bookPrices[k] = leftArray[i];
				i++;
			} else {
				bookPrices[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			bookPrices[k++] = leftArray[i++];
		}

		while (j < n2) {
			bookPrices[k++] = rightArray[j++];
		}
	}
}
