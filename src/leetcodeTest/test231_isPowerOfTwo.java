package leetcodeTest;

public class test231_isPowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
        return ((n & (n - 1)) == 0); //二进制并运算
    }
	
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(4));
	}
}
