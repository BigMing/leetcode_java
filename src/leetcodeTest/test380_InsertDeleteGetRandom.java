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
	 * �ص������������������ɾ����
	 * 
	 * ˼����ʵҲ�ܼ򵥣�ʹ��һ��HashMap����ÿ��ֵ��λ�þͿ����ˣ�Ȼ��ȫ��ֵ�浽һ��ArrayList���棬ɾ����ʱ��ɾ�����Ǹ�λ�õ�ֵ���е���
	 * ����ArrayList�������һλ��ֵ�ᵽҪɾ�����Ǹ�λ���ϸ��ǣ�Ȼ��ֱ��ɾ��ArrayList�����һ��
	 */
	// ������������ArrayList�еĹ�ϵ���������ٶ�λ
	private HashMap<Integer, Integer> locations;
	// �洢ԭʼ����
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
