package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a8 {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher("+213312");
		if (!isNum.matches()) {
			System.out.println("false");
		}
		System.out.println("true");
	}
}
