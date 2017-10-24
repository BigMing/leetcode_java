package leetcodeTest;

public class test13_RomantoInteger {
	/*
	 * 本题中： I 1 V 5 X 10 L 50 C 100 D 500 M 1000
	 * 假设现在有一罗马数字，XCVIII表示98，那么现在我们从X开始，X表示的数字10小于C100，则我们减去X，得到-10，
	 * 而C表示的数字100大于V表示的5，则加上100得90，以此类推，可以得到-10+100+5+1+1+1=98
	 */
	public int romanToInt(String s) {
		int res = 0;
		char max = 'I';
		for (int i = s.length() - 1; i >= 0; --i) {
			if (getVal(s.charAt(i)) >= getVal(max)) {
				max = s.charAt(i);
				res += getVal(s.charAt(i));
			} else {
				res -= getVal(s.charAt(i));
			}
		}
		return res;
	}

	private int getVal(char a) {
		switch (a) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
}
