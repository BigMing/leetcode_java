package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class a9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n * 2; i++) {
			if (i % 2 == 0) {
				x[i / 2] = sc.nextInt();
			} else {
				y[i / 2] = sc.nextInt();
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(x[i], y[i]);
		}
		ArrayList<ArrayList<Integer>> res = subsets(x);
		List<Integer> ss = new ArrayList<>();
		for (int i = 0; i < res.size(); i++) {
			ss.add(sum(res.get(i)));
		}
		int max = 0;
		for (int i = 0; i < ss.size(); i++) {
			for (int j = 0; j < ss.size(); j++) {
				if (i != j && ss.get(i) == ss.get(j)) {
				}
			}
		}
		System.out.println(max);
	}
	
	public static int ff(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			
		}
		return 0;
	}

	public static int sum(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if (nums.length == 0 || nums == null)
			return res;
		Arrays.sort(nums); // 排序
		dfs(nums, 0, item, res); // 递归调用
		res.add(new ArrayList<Integer>()); // 最后加上一个空集
		return res;
	}

	public static void dfs(int[] nums, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
		for (int i = start; i < nums.length; i++) {
			item.add(nums[i]);
			// item是以整数为元素的动态数组，而res是以数组为元素的数组，在这一步，当item增加完元素后，item所有元素构成一个完整的子串，再由res纳入
			res.add(new ArrayList<Integer>(item));
			dfs(nums, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}
}
