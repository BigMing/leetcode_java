package test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		// 获取连通线,每一个点对应的左边都是2x+1的关系
		sc = new Scanner(System.in);
		String str[] = sc.nextLine().split(";");
		String arr[][] = new String[2 * x + 1][2 * y + 1];
		// 渲染墙
		for (int i = 0; i < 2 * x + 1; i++) {
			for (int j = 0; j < 2 * y + 1; j++) {
				arr[i][j] = "[W]";
			}
		}
		// 处理连接点
		for (String s : str) {
			String twoPoints[] = s.split(" "); // 拿到两个点
			try {
				stringFormatErrorHandler(twoPoints); // 有效性3
				numberFormatErrorHandler(twoPoints); // 有效性1
				isValidConnection(twoPoints); // 有效性4
			} catch (Exception e) {
				return;
			}
			String[] xy1 = twoPoints[0].split(",");
			String[] xy2 = twoPoints[1].split(",");
			int onex = Integer.parseInt(String.valueOf(xy1[0])); // 可以去掉每个数前面的0
			int oney = Integer.parseInt(String.valueOf(xy1[2]));
			int twox = Integer.parseInt(String.valueOf(xy2[0]));
			int twoy = Integer.parseInt(String.valueOf(xy2[1]));
			try {
				rangeErrorHandler(onex, oney, twox, twoy, x, y); // 有效性2
			} catch (Exception e) {
				return;
			}
			arr[2 * onex + 1][2 * oney + 1] = "[R]"; // 先把坐标标记为R
			arr[2 * twox + 1][2 * twoy + 1] = "[R]";
			// x坐标相等，y不等，y之间有墙，连接墙
			if (onex == twox) {
				if (oney > twoy)
					arr[2 * onex + 1][2 * oney] = "[R]";
				else
					arr[2 * onex + 1][2 * twoy] = "[R]";
			} else { // 否则y坐标相等
				if (onex > twox)
					arr[2 * onex][2 * oney + 1] = "[R]";
				else
					arr[2 * twox][2 * oney + 1] = "[R]";
			}
		}
		printArr(arr);
	}

	public static void printArr(String arr[][]) {
		int x = arr[0].length;
		int y = arr.length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	public static void rangeErrorHandler(int onex, int oney, int twox, int twoy, int x, int y) throws Exception {
		if (onex >= x || twox >= x || oney >= y || twoy >= y) {
			System.out.print("Number out of range");
			throw new Exception();
		}
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static void numberFormatErrorHandler(String twoPoints[]) throws Exception {
		String[] xy1 = twoPoints[0].split(",");
		String[] xy2 = twoPoints[1].split(",");
		System.out.println("sdad");
		if (!isNumeric(xy1[0]) || !isNumeric(xy1[1]) || !isNumeric(xy2[0]) || !isNumeric(xy2[1])) { // 此处已经限制了只能是无符号数
			System.out.print("Invalid number format");
			throw new Exception();
		}
	}

	public static void isValidConnection(String twoPoints[]) throws Exception {
		String[] xy1 = twoPoints[0].split(",");
		String[] xy2 = twoPoints[1].split(",");
		int onex = Integer.parseInt(String.valueOf(xy1[0])); // 可以去掉每个数前面的0
		int oney = Integer.parseInt(String.valueOf(xy1[2]));
		int twox = Integer.parseInt(String.valueOf(xy2[0]));
		int twoy = Integer.parseInt(String.valueOf(xy2[1]));
		if (onex == twox) {
			if (Math.abs(oney - twoy) != 1) {
				System.out.print("maze format error");
				throw new Exception();
			}
		} else if (oney == twoy) {
			if (Math.abs(onex - twox) != 1) {
				System.out.print("maze format error");
				throw new Exception();
			}
		} else {
			System.out.print("maze format error");
			throw new Exception();
		}
	}

	public static void stringFormatErrorHandler(String twoPoints[]) throws Exception {
		if (twoPoints.length != 2) {
			System.out.print("inconcrrent command format");
			throw new Exception();
		}
		int index = 0;
		for (String s : twoPoints) {
			index = 0;
			while (s.charAt(index) >= '0' && s.charAt(index) <= '9' && index < s.length()) {
				index++;
			} // 可能是多位数
			if (s.charAt(index) != ',') { // 主要判断了是否满足,和;的格式
				System.out.print("inconcrrent command format");
				throw new Exception();
			} else { // 是","
				index++;
				while (s.charAt(index) >= '0' && s.charAt(index) <= '9' && index < s.length()) {
					index++;
				}
			}
		}
	}
}
