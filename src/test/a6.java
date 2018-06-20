package test;
//package leetcodeTest;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.util.StringTokenizer;
//import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.Future;
//import java.util.concurrent.RecursiveTask;
//
///**
// *
// * 
// * 
// * @author xxx
// * 
// *         ͳ�ƴ�Ƶ
// * 
// */
//
//public class WordCount extends RecursiveTask<Map<String, Integer>> {
//	private String path;
//
//	public WordCount(String path) {
//		this.path = path;
//
//	}
//
//	@Override
//	protected Map<String, Integer> compute() {
//		String text = readTextFromFile(path);// ��ȡ�ĵ����ݣ�����һ���ַ���
//		Map<String, Integer> map = statisticWord(text);// ���ַ����ִʣ�ͳ�ƴ�Ƶ
//		return map;
//	}
//
//	/**
//	 *
//	 * 
//	 * 
//	 * @param path
//	 * 
//	 * @return String �ַ���
//	 * 
//	 */
//	public static String readTextFromFile(String path) {
//
//		// ��ʵ��(1)......
//		StringBuilder sb = new StringBuilder();
//		String s = "";
//		BufferedReader br = new BufferedReader(new FileReader(path));
//		while ((s = br.readLine()) != null) {
//			sb.append(s + "\n");
//		}
//		br.close();
//		String str = sb.toString();
//		return str;
//	}
//
//	/**
//	 * 
//	 * ͳ��һ���ַ�����Ƶ
//	 * 
//	 * @param text
//	 * 
//	 * @return
//	 * 
//	 */
//
//	public static Map<String, Integer> statisticWord(String text) {
//
//		// ��ʵ��(2)......
//		String[] str = text.split(" ");
//		Map<String, Integer> res = new HashMap<>();
//		for (String s : str) {
//			if (!res.containsKey(str)) {
//				res.put(s, 1);
//			} else {
//				res.put(s, res.get(s) + 1);
//			}
//		}
//		return res;
//	}
//
//	/**
//	 * 
//	 * �ϲ�ÿ���ĵ���Ƶͳ�ƽ��
//	 * 
//	 * @param maps
//	 * 
//	 * @return map
//	 * 
//	 */
//
//	public static Map<String, Integer> merge(Map<String, Integer>[] maps) {
//
//		// ��ʵ��(3)......
//		Map<String, Integer> res = new HashMap<>();
//		for (Map<String, Integer> map : maps) {
//			for (Map.Entry<String, Integer> entry : map.entrySet()) {
//				if (!res.containsKey(entry.getKey())) {
//					res.put(entry.getKey(), 1);
//				} else {
//					res.put(entry.getKey(), res.get(entry.getKey()) + 1);
//				}
//			}
//		}
//		return res;
//	}
//
//	public static void main(String[] args) {
//		String dir = "docs";
//		// ͳ�����·��docsĿ¼���ı����浥�ʵĴ�Ƶ
//		// ��ʵ��(4)......ע��
//		ForkJoinPool forkjoinPool = new ForkJoinPool();
//		WordCount task = new WordCount(dir);
//		Future<Map<String, Integer>> result = forkjoinPool.submit(task);
//		try {
//			result.get();
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//}