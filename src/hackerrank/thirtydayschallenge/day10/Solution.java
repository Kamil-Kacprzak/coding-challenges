package hackerrank.thirtydayschallenge.day10;
/*
 * Given a base- integer, , convert it to binary (base-). Then find and print the base- integer denoting the maximum number of consecutive 's in 's binary representation.
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
    private static boolean counting = false;
    
    public static void main(String[] args) {
        Integer n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(countConsecutives(Integer.toBinaryString(n),'1').toString());
        scanner.close();
    }

	private static Integer countConsecutives(String  input, char lookUp) {
		int result = 0;		
		int counter = 0;
		
		for (char c : input.toCharArray()) {
			if(c == lookUp) {
				if(!counting) {
					counting = true;
				}
				counter++;
			}else {
				result = compareResults(result,counter);	
				counter = 0;
			}
		}		
		result = compareResults(result,counter);
		
		return result;			
	}

	private static int compareResults(int result, int counter) {
		if(counting) {
			counting = false;
			if(result < counter) {
				result = counter;
			}
		}
		return result;
	}
}