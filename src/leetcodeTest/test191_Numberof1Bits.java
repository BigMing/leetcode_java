package leetcodeTest;

public class test191_Numberof1Bits {
	public static int hammingWeight(int n) {
		int count = 0;
		String ns = Integer.toBinaryString(n);
		for (char i : ns.toCharArray()) {
			if (i == '1')
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(hammingWeight(2147483647));
	}
}
