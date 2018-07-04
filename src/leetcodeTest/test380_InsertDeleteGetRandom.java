package leetcodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class test380_InsertDeleteGetRandom {
	/*
	 * Design a data structure that supports all following operations in average
	 * O(1) time.
	 * 
	 * insert(val): Inserts an item val to the set if not already present.
	 * remove(val): Removes an item val from the set if present. getRandom:
	 * Returns a random element from current set of elements. Each element must
	 * have the same probability of being returned.
	 */
	/*
	 * 重点在于如何做到常数内删除？
	 * 
	 * 思想其实也很简单，使用一个HashMap保存每个值的位置就可以了，然后全部值存到一个ArrayList里面，删除的时候讲删除的那个位置的值进行调换
	 * ，将ArrayList里面最后一位的值提到要删除的那个位置上覆盖，然后直接删除ArrayList的最后一个
	 */
	// 用来索引下在ArrayList中的关系，做到快速定位
	private HashMap<Integer, Integer> locations;
	// 存储原始数据
	private ArrayList<Integer> list;
	private Random random;

	/** Initialize your data structure here. */
	public test380_InsertDeleteGetRandom() {
		this.locations = new HashMap<Integer, Integer>();
		this.list = new ArrayList<Integer>();
		this.random = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (locations.containsKey(val) == true)
			return false;
		locations.put(val, list.size());
		list.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (locations.containsKey(val) == false)
			return false;
		int tmpLocation = locations.get(val);
		if (tmpLocation != list.size() - 1) {
			int lastVal = list.get(list.size() - 1);
			list.set(tmpLocation, lastVal);
			locations.put(lastVal, tmpLocation);
		}
		list.remove(list.size() - 1);
		locations.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}
}
