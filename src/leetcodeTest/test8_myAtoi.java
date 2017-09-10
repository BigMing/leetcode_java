package leetcodeTest;

public class test8_myAtoi {
	
	public static int myAtoi(String str) {
		long MAX_VALUE = Integer.MAX_VALUE; // 这里用int定义的话+1会出错
		long ans = 0;
		str = str.trim(); //去掉str前面的空格
		char [] strCharArray = str.toCharArray(); //先把String转化为char数组
		//考虑正负号
		boolean flag = false;
		int index = 0;
		if (index < strCharArray.length && strCharArray[index] == '+') {
			index++;
		} else if (index < strCharArray.length && strCharArray[index] == '-') {
			//有'+-'的情况出现
			index++;
			flag = true;
		}
		// 转化为数
		for (; index < strCharArray.length; index++) {
			if (strCharArray[index] <= '9' && strCharArray[index] >= '0') {
				ans = ans * 10 + strCharArray[index] - '0';
				if (ans > MAX_VALUE) {
					ans = MAX_VALUE + 1;
					break;
				}
			} else {
				break; //str中出现非数字直接break
			}
		}
		if (flag) {
			//负数最小为-2147483648
			ans = -ans;
		}
		if (ans > MAX_VALUE) {
			ans = MAX_VALUE;
		}
        return (int) ans;
    }
	
	public static void main(String[] args) {
		System.out.println(myAtoi("-"));
	}
}
