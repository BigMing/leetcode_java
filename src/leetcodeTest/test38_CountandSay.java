package leetcodeTest;

public class test38_CountandSay {
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		// �ݹ���ã�Ȼ����ַ�������
		String str = countAndSay(n - 1) + "*"; // Ϊ��strĩβ�ı�ǣ�����ѭ������
		char[] c = str.toCharArray();
		int count = 1; // count��x
		String s = "";
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == c[i + 1]) {
				count++; // ��������
			} else {
				s = s + count + c[i]; // �����*������﷽��ͳһ����
				count = 1; // ��ʼ��
			}
		}
		return s;
	}
}
