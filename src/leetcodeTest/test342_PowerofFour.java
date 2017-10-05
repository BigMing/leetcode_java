package leetcodeTest;

public class test342_PowerofFour {
	public static boolean isPowerOfFour(int num) {
		// 4 16 64
		if (num <= 0) {
			return false;
		}
		// 0x55555555��1010��ɵĶ�������������ȥ������λ���Ƿ����
		return (num & (num - 1)) == 0 && (num & 0x55555555) == num;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16));
	}
}
