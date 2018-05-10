package leetcodeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class a3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] ai = new int[n];
		for (int i = 0; i < n; i++) {
			ai[i] = scanner.nextInt();
		}
		
		if (n == 1) {
			System.out.println(ai[0]);
			return;
		}
		
		int[] odds = new int[n];
		for (int i = 0; i < n; i++) {
			if (isOdd(ai[i])) {
				odds[i] = ai[i];
			}
		}
		if (odds.length == 1) {
			int res = 0;
			for (int i = 0; i < n; i++) {
				res += ai[i];
			}
			System.out.println(res);
			return;
		} else {
			int maxOdd = 0;
			for (int i = 0; i < odds.length; i++) {
				if (odds[i] > maxOdd) {
					maxOdd = odds[i];
				}
			}
			int res = maxOdd;
			for (int i = 0; i < n; i++) {
				if (!isOdd(ai[i])) {
					res += ai[i];
				}
			}
			System.out.println(res);
			return;
		}
	}
	
	public static boolean isOdd(int x) {
		if (x % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}
}
