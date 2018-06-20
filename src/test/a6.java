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
// *         统计词频
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
//		String text = readTextFromFile(path);// 读取文档内容，返回一个字符串
//		Map<String, Integer> map = statisticWord(text);// 将字符串分词，统计词频
//		return map;
//	}
//
//	/**
//	 *
//	 * 
//	 * 
//	 * @param path
//	 * 
//	 * @return String 字符串
//	 * 
//	 */
//	public static String readTextFromFile(String path) {
//
//		// 请实现(1)......
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
//	 * 统计一条字符串词频
//	 * 
//	 * @param text
//	 * 
//	 * @return
//	 * 
//	 */
//
//	public static Map<String, Integer> statisticWord(String text) {
//
//		// 请实现(2)......
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
//	 * 合并每个文档词频统计结果
//	 * 
//	 * @param maps
//	 * 
//	 * @return map
//	 * 
//	 */
//
//	public static Map<String, Integer> merge(Map<String, Integer>[] maps) {
//
//		// 请实现(3)......
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
//		// 统计相对路径docs目录下文本里面单词的词频
//		// 请实现(4)......注：
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