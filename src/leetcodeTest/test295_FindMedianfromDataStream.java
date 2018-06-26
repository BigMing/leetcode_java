package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test295_FindMedianfromDataStream {
	/*
	 * Example:
	 * 
	 * addNum(1) addNum(2) findMedian() -> 1.5 addNum(3) findMedian() -> 2
	 */
	List<Integer> numlist = new ArrayList<>();

	public test295_FindMedianfromDataStream() {

	}

	public void addNum(int num) { // ¶þ·Ö
		int left = 0;
		int right = numlist.size() - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int val = numlist.get(mid);

			if (val == num) {
				numlist.add(mid, num);
				return;
			} else if (val < num) {
				if (mid + 1 < numlist.size() && numlist.get(mid + 1) > num) {
					numlist.add(mid + 1, num);
					return;
				}
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		numlist.add(left, num);
	}

	public double findMedian() {
		int size = numlist.size();
		if (size % 2 == 1) { // odd
			return numlist.get((size - 1) / 2);
		}
		return (numlist.get(size / 2 - 1) + numlist.get(size / 2)) / 2.0;
	}
}
