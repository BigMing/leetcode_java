package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class a0 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		int[] rilist = new int[N];
		for (int i = 0; i < N; i++) {
			rilist[i] = in.nextInt();
		}

		int X = in.nextInt();

		double res = calculate(N, rilist, X);

		DecimalFormat df = new DecimalFormat("0.000");
		System.out.println(df.format(res * N));
	}

	public static double calculate(int n, int[] ri, int x) {
		double[] sqlist = new double[n];
		sqlist[0] = ri[0] * ri[0];
		for (int i = 1; i < n; i++) {
			sqlist[i] = (ri[i] * ri[i] - ri[i - 1] * ri[i - 1]);
		}
		double sumsq = ri[n - 1] * ri[n - 1];
		double qiwang = 0.0;
		for (int i = 0; i < n; i++) {
			qiwang += sqlist[i] / (sumsq) * (n - i);
		}
		return qiwang;
	}
}
