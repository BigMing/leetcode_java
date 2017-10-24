package leetcodeTest;

public class test13_RomantoInteger {
	/*
	 * �����У� I 1 V 5 X 10 L 50 C 100 D 500 M 1000
	 * ����������һ�������֣�XCVIII��ʾ98����ô�������Ǵ�X��ʼ��X��ʾ������10С��C100�������Ǽ�ȥX���õ�-10��
	 * ��C��ʾ������100����V��ʾ��5�������100��90���Դ����ƣ����Եõ�-10+100+5+1+1+1=98
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
