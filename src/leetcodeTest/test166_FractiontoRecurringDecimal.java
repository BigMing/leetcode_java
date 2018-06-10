package leetcodeTest;

import java.util.HashMap;
import java.util.Map;

public class test166_FractiontoRecurringDecimal {
	/*
	 * Example 1:
	 * 
	 * Input: numerator = 1, denominator = 2 Output: "0.5" Example 2:
	 * 
	 * Input: numerator = 2, denominator = 1 Output: "2" Example 3:
	 * 
	 * Input: numerator = 2, denominator = 3 Output: "0.(6)"
	 */
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) // ���ȿ��ǳ���Ϊ0��������Ϊ0���������
			return "0";
		if (denominator == 0)
			return String.valueOf(Integer.MAX_VALUE);
		
		String res = new String(); 
		if ((numerator < 0) ^ (denominator < 0)) // ��ο����������ķ��Ų�һ�µ����
			res = res + "-";

		// ���ǵ�Int����Ϊ-2^32�����������ת��Ϊlong��һ��Ҫ��ת���������ֵ ��Ȼ�Ѿ������˷��ţ��Ϳ���ֱ��תΪ����ֵ
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		long ren = num / den; // �����������ֺ�С������
		long rem = num % den; // ����
		res = res + String.valueOf(ren);

		if (rem == 0) // û��С�����֣�ֱ�ӷ���
			return res;

		res += '.';
		// ����map�����������Լ���������Ӧ��С����λ�ã�������������Ϊѭ��С�������� 
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		int beg = res.length();
		while (rem > 0) {
			rem = rem * 10;
			ren = rem / den;
			if (map.containsKey(rem)) { // ��������ظ�����Ҫ��ȡ��ѭ���Ĳ��ִ�����
				String part1 = res.substring(0, map.get(rem)); // ѭ��ǰ
				String part2 = res.substring(map.get(rem)); // ѭ����
				res = part1 + "(" + part2 + ")";
				break;
			} else { // ��������С��
				res += String.valueOf(ren);
				map.put(rem, beg);
			}
			beg++; // ����λ�ü���������
			rem = rem % den;
		}
		return res;
	}
}
