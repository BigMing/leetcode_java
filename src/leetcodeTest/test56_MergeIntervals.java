package leetcodeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test56_MergeIntervals {
	/*
	 * Example 1:Input: [[1,3],[2,6],[8,10],[15,18]],Output: [[1,6],[8,10],[15,18]]
	 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
	 * Example 2:Input: [[1,4],[4,5]],Output: [[1,5]]
	 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
	 */
	public class Interval {
		int start;
		int end;

		public Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ans = new ArrayList<>();
		int size = intervals.size();
		if (size == 0)
			return ans;
		// 排序，重写comparator方法
		Comparator<Interval> comp = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		};
		Collections.sort(intervals, comp);
		ans.add(intervals.get(0)); // 维护一个结果队列，避免重复删除
		for (int i = 1; i < size; i++) {
			if (ans.get(ans.size() - 1).end >= intervals.get(i).start) {
				ans.get(ans.size() - 1).end = Math.max(ans.get(ans.size() - 1).end, intervals.get(i).end);
			} else {
				ans.add(intervals.get(i));
			}
		}
		return ans;
	}
}
