package leetcodeTest;

public class test344_ReverseString {
	/*
	 * Write a function that takes a string as input and returns the string
	 * reversed.
	 * 
	 * Example: Given s = "hello", return "olleh".
	 */
	public static String reverseString(String s) {
		String result = "";
		char[] ch = s.toCharArray();
		for (int i = ch.length - 1; i >= 0; i--) {
			result += ch[i];
		}
		return result;
	}

	public static String reverseString3(String s) {
		return new StringBuffer(s).reverse().toString();
	}

	public static String reverseString4(String s) {
		char[] ch = s.toCharArray();
		int halfLength = s.length() / 2;
		char temp;
		for (int i = 0; i < halfLength; i++) {
			temp = ch[s.length() - 1 - i];
			ch[s.length() - 1 - i] = ch[i];
			ch[i] = temp;
		}
		return new String(ch);
	}

	public static String reverseString7(String s) {
		int length = s.length();
		if (length <= 1) {
			return s;
		}
		String leftStr = s.substring(0, length / 2);
		String rightStr = s.substring(length / 2, length);
		return reverseString7(rightStr) + reverseString7(leftStr);
	}
}
