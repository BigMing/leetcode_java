package leetcodeTest;

public class test29_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int sign = 1; // 解决正负问题
		if (dividend < 0)
			sign = -sign;
		if (divisor < 0)
			sign = -sign;
		
		long temp = Math.abs((long) dividend); // Math.abs(-2147483648) 结果还是 -2147483648. 在进行该运算前，要将其转化为long类型
		long temp2 = Math.abs((long) divisor);
		long c = 1;
		
		while (temp > temp2) {
			temp2 = temp2 << 1; // 乘2
			c = c << 1; // 结果至少乘2
		}
		
		long res = 0;
		while (temp >= Math.abs((long) divisor)) {
			while (temp >= temp2) {
				temp -= temp2; // 余数
				res += c; // 记录结果
			}
			temp2 = temp2 >> 1; // 除2
			c = c >> 1; // 看余数的倍数
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
