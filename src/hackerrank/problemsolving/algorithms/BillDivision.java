package hackerrank.problemsolving.algorithms;
/*
 * https://www.hackerrank.com/challenges/bon-appetit/problem?isFullScreen=true
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BillDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
    
    public static void bonAppetit(List<Integer> bill, int k, int b) {
    	bill.set(k, 0);
    	int sum = bill.stream().reduce(0, Integer::sum) / 2;
    	boolean correct = sum == b ? true : false;
    	
    	if(correct) {
    		System.out.println("Bon Appetit");
    	}else {
    		int diff = Math.abs(sum - b);
    		System.out.println(diff);
    	}
    }
}
