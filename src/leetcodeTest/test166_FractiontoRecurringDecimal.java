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
		if (numerator == 0) // 首先考虑除数为0，被除数为0的特殊情况
			return "0";
		if (denominator == 0)
			return String.valueOf(Integer.MAX_VALUE);
		
		String res = new String(); 
		if ((numerator < 0) ^ (denominator < 0)) // 其次考虑两个数的符号不一致的情况
			res = res + "-";

		// 考虑到Int类型为-2^32的溢出，所以转化为long，一定要先转换再求绝对值 既然已经考虑了符号，就可以直接转为绝对值
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		long ren = num / den; // 区别整数部分和小数部分
		long rem = num % den; // 余数
		res = res + String.valueOf(ren);

		if (rem == 0) // 没有小数部分，直接返回
			return res;

		res += '.';
		// 采用map来存余数，以及该余数对应的小数的位置，这样方便我们为循环小数打括号 
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		int beg = res.length();
		while (rem > 0) {
			rem = rem * 10;
			ren = rem / den;
			if (map.containsKey(rem)) { // 如果出现重复，需要截取出循环的部分打括号
				String part1 = res.substring(0, map.get(rem)); // 循环前
				String part2 = res.substring(map.get(rem)); // 循环后
				res = part1 + "(" + part2 + ")";
				break;
			} else { // 不包含的小数
				res += String.valueOf(ren);
				map.put(rem, beg);
			}
			beg++; // 更新位置计数和余数
			rem = rem % den;
		}
		return res;
	}
}
