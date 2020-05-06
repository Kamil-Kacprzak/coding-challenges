package hackerrank.thirtydayschellange.day07;
/*
 * Given an array, , of  integers, print 's elements in reverse order as a single line of space-separated numbers.


 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        printArrayReversed(arr);
        scanner.close();
    }

	private static void printArrayReversed(int[] arr) {	
		StringBuilder sb = new StringBuilder();
		for(int i : arr) {
			sb.insert(0,' ');
			sb.insert(0,i);
		}
		System.out.print(sb.toString());
	}
}
