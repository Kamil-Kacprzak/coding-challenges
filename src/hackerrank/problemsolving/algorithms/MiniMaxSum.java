package hackerrank.problemsolving.algorithms;

/*
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
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

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }
    
    public static void miniMaxSum(List<Integer> arr) {
    	arr.sort(null);
    	long sum = 0;
    	for(int i : arr) {
    		sum += i;
    	}
    	long min = sum - arr.get(arr.size()-1);
    	long max = sum - arr.get(0);
    	System.out.print(min + " " + max);
    }

}

