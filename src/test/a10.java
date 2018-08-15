package test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class a10 {
	static HashSet set = new HashSet();
	static LinkedList<LinkedList> lists = new LinkedList<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str[] = in.nextLine().split(",");
		int row = Integer.parseInt(str[0]);
		int column = Integer.parseInt(str[1]);

		if (row <= 0 || column <= 0) {
			System.out.print(0 + "," + 0);
			return;
		}

		String arr[][] = new String[row][column];
//		in = new Scanner(System.in);
		for (int i = 0; i < row; i++) {
			String input[] = in.nextLine().split(",");
			for (int j = 0; j < column; j++) {
				arr[i][j] = input[j];
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j].equals("1")) {
					if (!set.contains(i + "," + j)) {
						LinkedList list = new LinkedList();
						caculate(arr, i, j, list);
						lists.add(list);
					}
				}
			}
		}
		int max = 0;
		for (LinkedList list : lists) {
			max = list.size() > max ? list.size() : max;
		}
		System.out.print(lists.size() + "," + max);

	}

	public static void caculate(String arr[][], int x, int y, LinkedList list) {
		if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || set.contains(x + "," + y)) {
			return;
		}
		if (arr[x][y].equals("1")) {
			set.add(x + "," + y);
			list.add(x + "," + y);
			caculate(arr, x + 1, y, list);
			caculate(arr, x, y + 1, list);
			caculate(arr, x - 1, y, list);
			caculate(arr, x, y - 1, list);
			caculate(arr, x + 1, y + 1, list);
			caculate(arr, x - 1, y - 1, list);
			caculate(arr, x + 1, y - 1, list);
			caculate(arr, x - 1, y + 1, list);
		}
	}
}
