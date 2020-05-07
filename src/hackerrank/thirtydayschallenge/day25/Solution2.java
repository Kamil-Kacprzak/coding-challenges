package hackerrank.thirtydayschallenge.day25;

/*
 * A prime is a natural number greater than  that has no positive divisors other than  and itself. Given a number, , determine and print whether it's  or .

Note: If possible, try to come up with a  primality algorithm, or see what sort of optimizations you come up with for an  algorithm. Be sure to check out the Editorial after submitting your code!
 */
import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	final int T = scan.nextInt();
    	
    	int[] input = new int[T];
    	
    	for ( int i = 0; i<T; i++) {
    		input[i] = scan.nextInt();
    	}
    	scan.close();

    	for(int i : input) {
    		if(checkForPrimes(i)) {
    			System.out.println("Prime");
    		}else {
    			System.out.println("Not prime");
    		}
    	}
    }

	private static boolean checkForPrimes(int i) {
		boolean isPrime = true;
		if(i<2) {
			return false;
		}else {
			for(int n = 2; n <= Math.sqrt(i); n++) {
				if(i%n == 0) {
					isPrime = false;
					break;
				}
			}
			return isPrime;
		}
	}
}