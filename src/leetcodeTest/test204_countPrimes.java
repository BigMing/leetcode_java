package leetcodeTest;

public class test204_countPrimes {

	public static int countPrimes(int n) {
		// 厄拉多塞筛法
		boolean Del[] = new boolean[n]; // 标记是否被划去
		if (n <= 2) {
			return 0;
		}
		for (int i = 3; i < n; ++i) {
			if (i % 2 == 0)
				Del[i] = true; // 2的倍数全部划去
			else
				Del[i] = false;
		}
		for (int i = 3; i < n; i += 2) {
			if (!Del[i]) // 之后第一个未被划去
			{
				if (i * i > n)
					break; // 当前素数的平方大于n，跳出循环
				for (int j = 2; i * j < n; ++j)
					Del[i * j] = true; // 划去i的倍数
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
