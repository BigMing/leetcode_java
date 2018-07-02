package leetcodeTest;

import java.util.List;

public class test341_FlattenNestedListIterator {
	/*
	 * Given a nested list of integers, implement an iterator to flatten it.
	 * 
	 * Each element is either an integer, or a list -- whose elements may also
	 * be integers or other lists.
	 * 
	 * Example 1: Given the list [[1,1],2,[1,1]],
	 * 
	 * By calling next repeatedly until hasNext returns false, the order of
	 * elements returned by next should be: [1,1,2,1,1].
	 * 
	 * Example 2: Given the list [1,[4,[6]]],
	 */
	// 这道题的思想是在调用hasNext的时候，将NestedInteger拆分，然后将第一个元素保存到域变量中即可。其他元素添加到链表的首部。

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	List<NestedInteger> nestedList;
	int data;

	public test341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
		this.nestedList = nestedList;
	}

	public Integer next() {
		return data;
	}

	public boolean hasNext() {
		while (nestedList != null && nestedList.size() > 0) {
			NestedInteger tmpInt = nestedList.remove(0);
			if (tmpInt.isInteger()) {
				data = tmpInt.getInteger();
				return true;
			} else {
				nestedList.addAll(0, tmpInt.getList());
			}
		}
		return false;
	}
}
