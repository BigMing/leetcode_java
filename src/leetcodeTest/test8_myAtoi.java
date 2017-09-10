package leetcodeTest;

public class test8_myAtoi {
	
	public static int myAtoi(String str) {
		long MAX_VALUE = Integer.MAX_VALUE; // ������int����Ļ�+1�����
		long ans = 0;
		str = str.trim(); //ȥ��strǰ��Ŀո�
		char [] strCharArray = str.toCharArray(); //�Ȱ�Stringת��Ϊchar����
		//����������
		boolean flag = false;
		int index = 0;
		if (index < strCharArray.length && strCharArray[index] == '+') {
			index++;
		} else if (index < strCharArray.length && strCharArray[index] == '-') {
			//��'+-'���������
			index++;
			flag = true;
		}
		// ת��Ϊ��
		for (; index < strCharArray.length; index++) {
			if (strCharArray[index] <= '9' && strCharArray[index] >= '0') {
				ans = ans * 10 + strCharArray[index] - '0';
				if (ans > MAX_VALUE) {
					ans = MAX_VALUE + 1;
					break;
				}
			} else {
				break; //str�г��ַ�����ֱ��break
			}
		}
		if (flag) {
			//������СΪ-2147483648
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
