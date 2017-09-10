package leetcodeTest;

public class test292_canWinNim {
	/**
	 * 每次取完剩下的数量是4的倍数，则对方必输
	 */
	public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}