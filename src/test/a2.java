package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class a2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		List<Long> list = new ArrayList<Long>();

		while (count-- != 0) {
			list.add(in.nextLong());
		}

		for (Long num : list) {
			if (num % 2 == 0) {
				for (int i = 2; i <= num; i += 2) {
					if ((num / i) % 2 != 0) {
						System.out.println((num / i) + " " + i);
						break;
					} else {
						continue;
					}
				}
			} else {
				System.out.println("NO");
			}
		}
	}
}
