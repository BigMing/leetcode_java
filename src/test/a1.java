package test;

public class a1 {
	public static void main(String[] args) {

		String testString = "1234567890";
		char[] testChar = testString.toCharArray();

		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (panduan(i, testString)) {
				System.out.println(i);
				return;
			}
		}
	}

	public static boolean panduan(int guess, String testString) {
		char[] testChar = testString.toCharArray();
		String str = String.valueOf(guess);
		char[] strChar = str.toCharArray();
		boolean[] flag = new boolean[strChar.length];
		for (int i = 0; i < strChar.length; i++) {
			flag[i] = true;
		}
		for (int i = 0; i < strChar.length; i++) {
			for (int j = 0; j < testChar.length; j++) {
				if (strChar[i] == testChar[j]) {
					flag[i] = false;
				}
			}
		}
		for (int i = 0; i < flag.length; i++) {
			if (flag[i] == true) { // 有一位没有
				return true;
			}
		}
		return false;
	}
}
