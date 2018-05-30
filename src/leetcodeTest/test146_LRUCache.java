package leetcodeTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class test146_LRUCache {
	/*
	 * LRUCache cache = new LRUCache( 2 );
	 * 
	 * cache.put(1, 1); cache.put(2, 2); cache.get(1); // returns 1 cache.put(3,
	 * 3); // evicts key 2 cache.get(2); // returns -1 (not found) cache.put(4,
	 * 4); // evicts key 1 cache.get(1); // returns -1 (not found) cache.get(3);
	 * // returns 3 cache.get(4); // returns 4
	 */
	public int capacity;
	public List<Map<Integer, Integer>> list = new LinkedList<>();

	public test146_LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		int value = -1;
		for (Map<Integer, Integer> map : list) {
			if (map.get(key) != null) {
				value = map.get(key);
				list.remove(map);
				list.add(0, map);
				break;
			}
		}
		return value;
	}

	public void put(int key, int value) {
		for (Map<Integer, Integer> map : list) {
			if (map.get(key) != null) {
				list.remove(map);
				break;
			}
		}
		int size = list.size();
		Map<Integer, Integer> map = new HashMap<>();
		map.put(key, value);
		if (size < capacity) {
			list.add(0, map);
		} else {
			list.add(0, map);
			list.remove(capacity);
		}
	}
}
