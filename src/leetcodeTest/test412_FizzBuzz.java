package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test412_FizzBuzz {
	/*
	 * 
	 * Write a program that outputs the string representation of numbers from 1
	 * to n.
	 * 
	 * But for multiples of three it should output ¡°Fizz¡± instead of the number
	 * and for the multiples of five output ¡°Buzz¡±. For numbers which are
	 * multiples of both three and five output ¡°FizzBuzz¡±.
	 * 
	 * Example:
	 * 
	 * n = 15,
	 * 
	 * Return: [ "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz",
	 * "Buzz", "11", "Fizz", "13", "14", "FizzBuzz" ]
	 */
	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i / 3 * 3 == i && i / 5 * 5 == i)
				res.add("FizzBuzz");
			else if (i / 3 * 3 == i)
				res.add("Fizz");
			else if (i / 5 * 5 == i)
				res.add("Buzz");
			else
				res.add(Integer.toString(i));
		}
		return res;
	}
}
