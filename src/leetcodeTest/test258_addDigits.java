package leetcodeTest;

public class test258_addDigits {
	/**
	 * abc = a * 100 + b * 10 + c
	 * abc % 9 = (a * 99 + b * 9 + a + b + c) % 9 = (a + b + c) % 9  
	 * @param num
	 * @return
	 */
    public static int addDigits(int num) {
        if (num == 0) {
        	return 0;
        }
        return (num - 1) % 9 + 1; // [0-8]->[1-9]
    }

	public static void main(String[] args) {
		System.out.println(addDigits(23));
	}

}
