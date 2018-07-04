package leetcodeTest;

import java.util.Random;

public class test384_ShuffleanArray {
	int[] init;

	public test384_ShuffleanArray(int[] nums) {
		init = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return init;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] random = new int[init.length];
		for (int i = 0; i < random.length; i++) {
			random[i] = i;
		}
		Random r = new Random();
		for (int i = random.length - 1; i >= 0; i--) {
			int t = r.nextInt(i + 1);
			int swap = random[i];
			random[i] = random[t];
			random[t] = swap;
		}
		for (int i = 0; i < random.length; i++) {
			random[i] = init[random[i]];
		}
		return random;
	}
}
