package leetcodeTest;

public class test204_CountPrimes {
	/*
	 * Count the number of prime numbers less than a non-negative number, n.
	 * 
	 * Example:
	 * 
	 * Input: 10 Output: 4 Explanation: There are 4 prime numbers less than 10,
	 * they are 2, 3, 5, 7.
	 */
	public static int countPrimes(int n) {
		// ��������ɸ��
		boolean Del[] = new boolean[n]; // ����Ƿ񱻻�ȥ
		if (n <= 2) {
			return 0;
		}
		for (int i = 3; i < n; ++i) {
			if (i % 2 == 0)
				Del[i] = true; // 2�ı���ȫ����ȥ
			else
				Del[i] = false;
		}
		for (int i = 3; i < n; i += 2) { // 3,5,7,9....
			if (!Del[i]) { // ֮���һ��δ����ȥ
				if (i * i > n)
					break; // ��ǰ������ƽ������n������ѭ��
				for (int j = 2; i * j < n; ++j)
					Del[i * j] = true; // ��ȥi�ı���
			}
		}
		int count = 0;
		for (int i = 2; i < n; ++i) {
			if (!Del[i])
				++count;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(3));
	}

}
