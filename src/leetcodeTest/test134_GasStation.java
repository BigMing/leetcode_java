package leetcodeTest;

public class test134_GasStation {
	/*
	 * Input: gas = [1,2,3,4,5] cost = [3,4,5,1,2]
	 * 
	 * Output: 3
	 * 
	 * Explanation: Start at station 3 (index 3) and fill up with 4 unit of gas.
	 * Your tank = 0 + 4 = 4 Travel to station 4. Your tank = 4 - 1 + 5 = 8
	 * Travel to station 0. Your tank = 8 - 2 + 1 = 7 Travel to station 1. Your
	 * tank = 7 - 3 + 2 = 6 Travel to station 2. Your tank = 6 - 4 + 3 = 5
	 * Travel to station 3. The cost is 5. Your gas is just enough to travel
	 * back to station 3. Therefore, return 3 as the starting index.
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || gas.length != cost.length) {
			return -1;
		}
		int start = 0;
		int total = 0; // 加的气和消耗的气的总差值
		int sum = 0; // 从start位置开始，加的气和消耗的气的总差值
		for (int i = 0; i < gas.length; i++) {
			total += (gas[i] - cost[i]);
			if (sum < 0) { // 如是油箱没有油了
				sum = gas[i] - cost[i]; // 重新设置油箱中的油
				start = i; // 记录新的起点位置
			} else {
				sum += (gas[i] - cost[i]); // 油箱中还有油，更新油箱中的油数
			}
		}
		return total >= 0 ? start : -1;
	}
}
