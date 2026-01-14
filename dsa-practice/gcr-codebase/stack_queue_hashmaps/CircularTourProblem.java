package gcr_codebase.stack_queue_hashmaps;

public class CircularTourProblem {

	static int findStart(int[] petrol, int[] distance) {
		int start = 0;
		int balance = 0;
		int totalPetrol = 0;
		int totalDistance = 0;

		for (int i = 0; i < petrol.length; i++) {
			totalPetrol += petrol[i];
			totalDistance += distance[i];

			balance += petrol[i] - distance[i];

			if (balance < 0) {
				start = i + 1;
				balance = 0;
			}
		}

		return totalPetrol >= totalDistance ? start : -1;
	}

	public static void main(String[] args) {
		int[] petrol = { 4, 6, 7, 4 };
		int[] distance = { 6, 5, 3, 5 };

		System.out.println(findStart(petrol, distance)); // Output: 1
	}

}
