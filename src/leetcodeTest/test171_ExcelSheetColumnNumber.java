package leetcodeTest;

public class test171_ExcelSheetColumnNumber {
	/*
	 * Given a column title as appear in an Excel sheet, return its
	 * corresponding column number.
	 * 
	 * For example:
	 * 
	 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ...
	 */
	/*
	 * �������A-Z����26���Ƶ����������26�����ַ������ڵ�10������
	 * �����õ�һ����ѧ����Math.pow(a,b)=a��b���ݣ���Math.pow(26,len-1-i)����26�ģ�len-1-i������
	 */
	public int titleToNumber(String s) {
		// s���ַ�����
		int len = s.length();
		// �������ս��
		int result = 0;
		// �Ӹ�λ����ʼ�ۼӼ���
		for (int i = len - 1; i >= 0; i--) {
			// Math.pow(a,b)�Ǽ���a��b���ݣ����������26
			result += (s.charAt(i) - 'A' + 1) * Math.pow(26, len - 1 - i);
		}
		return result;
	}
}
