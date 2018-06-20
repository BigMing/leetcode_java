package test;
//package leetcodeTest;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//public class aliTest {
//	public static void main(String[] args) {
//
//		List<Integer> order = new ArrayList<Integer>(); // 订单每个商品多少个
//		Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>(); // 组合
//
//		Scanner in = new Scanner(System.in);
//		String line = in.nextLine();
//
//		Integer n = Integer.parseInt(line.split(",")[0]);
//		Integer m = Integer.parseInt(line.split(",")[1]);
//
//		line = in.nextLine();
//		String[] itemCnt = line.split(","); // 输入a1...an
//		for (int i = 0; i < n; i++) {
//			order.add(Integer.parseInt(itemCnt[i]));
//		}
//
//		for (int i = 0; i < m; i++) { // m种组合
//			line = in.nextLine();
//			String[] bomInput = line.split(",");
//			List<Integer> bomDetail = new ArrayList<Integer>();
//
//			for (int j = 1; j <= n; j++) { // 每个组合n个商品的数量
//				bomDetail.add(Integer.parseInt(bomInput[j]));
//			}
//			boms.put(bomInput[0], bomDetail);
//		}
//		in.close();
//
//		Map<String, Integer> res = resolve(order, boms); // 返回组合名-个数
//
//		System.out.println("match result:");
//		for (String key : res.keySet()) {
//			System.out.println(key + "*" + res.get(key));
//		}
//	}
//
//	// write your code here
//	public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
//		Map<String, List<Integer>> optimalCombos = new HashMap<>();
//		Map<String, List<Integer>> currentCombos = new HashMap<>();
//		int minLeftKinds = Integer.MAX_VALUE;
//
//		return resolve(order, boms, 1);
//	}
//
//	private static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms, int depth) {
//		for (int i = 1; i <= boms.size(); i++) {
//			// System.out.println("depth = "+ depth);
//			// System.out.println("i = " + i);
//			// System.out.println("minLeftKinds = " + minLeftKinds);
//			// System.out.println("currentCombos:" + currentCombos);
//			// System.out.println("optimalCombos:" + optimalCombos);
//			// System.out.println("-------------------------------");
//
//			List<Integer> combo = boms.get("bom" + i);
//			if (isValidCombo(order, combo)) {
//				deductCombo(order, combo);
//				currentCombos.put("bom" + i, currentCombos.getOrDefault("bom" + i, 0) + 1);
//
//				resolve(order, boms, depth + 1);
//
//				addCombo(order, combo);
//				currentCombos.put("bom" + i, currentCombos.get("bom" + i) - 1);
//			} else {
//				int leftKinds = kindOfItemsInList(order);
//				if (leftKinds < minLeftKinds) {
//					minLeftKinds = leftKinds;
//					optimalCombos = new HashMap<>(currentCombos);
//				} else if (leftKinds == minLeftKinds) {
//					if (kindOfCombos(currentCombos) < kindOfCombos(optimalCombos)) {
//						optimalCombos = new HashMap<>(currentCombos);
//					}
//				}
//			}
//		}
//
//		return optimalCombos;
//	}
//
//	public static int kindOfItemsInList(List<Integer> list) {
//		int count = 0;
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) > 0) {
//				count++;
//			}
//		}
//		return count;
//	}
//
//	public static boolean isValidCombo(List<Integer> items, List<Integer> combo) {
//		for (int i = 0; i < combo.size(); i++) {
//			if (items.get(i) < combo.get(i)) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public static void deductCombo(List<Integer> items, List<Integer> combo) {
//		for (int i = 0; i < combo.size(); i++) {
//			items.set(i, items.get(i) - combo.get(i));
//		}
//	}
//
//	public static void addCombo(List<Integer> items, List<Integer> combo) {
//		for (int i = 0; i < combo.size(); i++) {
//			items.set(i, items.get(i) + combo.get(i));
//		}
//	}
//
//	public static int kindOfCombos(Map<String, Integer> combos) {
//		int count = 0;
//		for (int i = 1; i <= combos.size(); i++) {
//			if (combos.getOrDefault("bom" + i, 0) != 0) {
//				count++;
//			}
//		}
//		return count;
//	}
//}
