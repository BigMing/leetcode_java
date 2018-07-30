package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class a7 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }
        
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
        	list.add(locations[i].split(","));
        }
        
        int[][] dis = new int[num][num]; // 点点之间距离
        for (int i = 0; i < num; i++) {
        	for (int j = 0; j < num; j++) {
        		if (i == j) {
					dis[i][j] = 0;
				} else {
					String[] strings = list.get(i);
					double x = Math.pow(Integer.parseInt(strings[0]), 2);
					double y = Math.pow(Integer.parseInt(strings[1]), 2);
					double sum = Math.sqrt(x + y);
					dis[i][j] = (int) sum;
				}
        	}
        }
        
        for (int i = 0; i < num; i++) {
        	for (int j = 0; j < num; j++) {
        		for (int k = 0; k < num; k++) {
        			String[] s = list.get(k);
        			
        		}
        	}
        }
    }
}
