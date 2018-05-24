package leetcodeTest;

public class test125_ValidPalindrome {
	/*
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * Note: For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 * 
	 * Example 1:
	 * 
	 * Input: "A man, a plan, a canal: Panama" Output: true Example 2:
	 * 
	 * Input: "race a car" Output: false
	 */
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		int left = 0;
		int right = s.length() - 1;
		char l;
		char r;
		while (left < right) {
			while (left < s.length() && !isAlphanumericCharacters(s.charAt(left))) { // ºöÂÔ·Ç×ÖÄ¸ºÍÊý×Ö
				left++;
			}
			while (right >= 0 && !isAlphanumericCharacters(s.charAt(right))) {
				right--;
			}
			if (left < right) {
				l = s.charAt(left);
				r = s.charAt(right);
				if (toLowerCase(l) == toLowerCase(r)) {
					left++;
					right--;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isAlphanumericCharacters(char c) {
		return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	
	private char toLowerCase(char c) {
		if (c >= 'A' && c <= 'Z') {
			return (char) (c + 32);
		} else {
			return c;
		}
	}
	
	public static void main(String[] args) {
		System.out.println('0' - 0);
	}
}
