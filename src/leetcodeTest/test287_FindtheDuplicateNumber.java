package leetcodeTest;

public class test287_FindtheDuplicateNumber {
	/*
	 * Given an array nums containing n + 1 integers where each integer is
	 * between 1 and n (inclusive), prove that at least one duplicate number
	 * must exist. Assume that there is only one duplicate number, find the
	 * duplicate one.
	 * 
	 * Example 1:
	 * 
	 * Input: [1,3,4,2,2] Output: 2 Example 2:
	 * 
	 * Input: [3,1,3,4,2] Output: 3
	 */
	/*
	 * 限制：
	 * 
	 * 不能修改数组
	 * 
	 * 空间复杂度O(1)
	 * 
	 * 时间复杂度小于O(n^2)
	 */
	/*
	 * 按照抽屉原理，整个数组中如果小于等于n/2的数的数量大于n/2，说明1到n/2这个区间是肯定有重复数字的。比如6个抽屉，如果有7个袜子要放到抽屉里
	 * ，那肯定有一个抽屉至少两个袜子。这里抽屉就是1到n/2的每一个数，而袜子就是整个数组中小于等于n/2的那些数。这样我们就能知道下次选择的数的范围，
	 * 如果1到n/2区间内肯定有重复数字，则下次在1到n/2范围内找，否则在n/2到n范围内找。下次找的时候，还是找一半。
	 */
	public int findDuplicate(int[] nums) {
		int min = 0, max = nums.length - 1;
		while (min <= max) {
			int mid = min + (max - min) / 2;
			int count = 0; // 计算总数组中有多少小于等于中间数
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid) {
					count++;
				}
			}
			if (count > mid) { // 小于等于中间数的个数>中间数
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return min;
	}

	/*
	 * 假设数组中没有重复，那我们可以做到这么一点，就是将数组的下标和1到n每一个数一对一的映射起来。比如数组是213,则映射关系为0->2, 1->1,
	 * 2->3。假设这个一对一映射关系是一个函数f(n)，其中n是下标，f(n)是映射到的数。如果我们从下标为0出发，根据这个函数计算出一个值，
	 * 以这个值为新的下标，再用这个函数计算，以此类推，直到下标超界。实际上可以产生一个类似链表一样的序列。比如在这个例子中有两个下标的序列，0->2->
	 * 3。
	 * 
	 * 但如果有重复的话，这中间就会产生多对一的映射，比如数组2131,则映射关系为0->2, {1，3}->1,
	 * 2->3。这样，我们推演的序列就一定会有环路了，这里下标的序列是0->2->3->1->1->1->1->...，而环的起点就是重复的数。
	 */
	public int findDuplicate1(int[] nums) {
		int slow = 0;
		int fast = 0;
		do {
			slow = nums[slow]; // 走一步
			fast = nums[nums[fast]]; // 走两步
		} while (slow != fast); // 未重复时
		int find = 0;
		while (find != slow) {
			slow = nums[slow];
			find = nums[find];
		}
		return find;
	}
}
