package leetcodeTest;

public class test29_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int sign = 1; // �����������
		if (dividend < 0)
			sign = -sign;
		if (divisor < 0)
			sign = -sign;
		
		long temp = Math.abs((long) dividend); // Math.abs(-2147483648) ������� -2147483648. �ڽ��и�����ǰ��Ҫ����ת��Ϊlong����
		long temp2 = Math.abs((long) divisor);
		long c = 1;
		
		while (temp > temp2) {
			temp2 = temp2 << 1; // ��2
			c = c << 1; // ������ٳ�2
		}
		
		long res = 0;
		while (temp >= Math.abs((long) divisor)) {
			while (temp >= temp2) {
				temp -= temp2; // ����
				res += c; // ��¼���
			}
			temp2 = temp2 >> 1; // ��2
			c = c >> 1; // �������ı���
		}
	
		if (sign > 0 && res > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (sign > 0) {
			return (int) res;
		} else {
			return (int) -res;
		}
	}
}
