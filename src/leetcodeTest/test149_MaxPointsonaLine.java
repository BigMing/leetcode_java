package leetcodeTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class test149_MaxPointsonaLine {
	/*
	 * Given n points on a 2D plane, find the maximum number of points that lie
	 * on the same straight line.
	 */
	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		int length = points.length;
		if (length <= 2)
			return length;

		int max = 2;
		HashMap<Double, Integer> maps = new HashMap<>();
		for (int i = 0; i < length; i++) {
			maps.clear();
			Point now = points[i];
			int dulplicate = 1;
			int vertical = 0;

			for (int j = i + 1; j < length; j++) {
				Point cmp = points[j];
				if (now.x == cmp.x && now.y == cmp.y) // 重复的点
					dulplicate++;
				else if (now.x == cmp.x) { // 垂直的点
					vertical++;
				} else {
					double slope = (cmp.y == now.y) ? 0.0 : (1.0) * (cmp.y - now.y) / (cmp.x - now.x);
					if (maps.containsKey(slope)) {
						maps.put(slope, maps.get(slope) + 1);
					} else
						maps.put(slope, 1);
				}
			}
			Iterator iterator = maps.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry) iterator.next();
				int value = (int) entry.getValue(); // i这个点的不同向量个数
				if (value + dulplicate > max)
					max = value + dulplicate;
			}
			max = Math.max(vertical + dulplicate, max); // 再看下和垂直的比较
		}
		return max;
	}
	
	public static void main(String[] args) {
		double a = 94911151 / 94911150 * 1.0;
		double b = 94911152 / 94911151 * 1.0;
		System.out.println(a);
		System.out.println(b);
	}
}
