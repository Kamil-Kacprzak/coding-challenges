package hackerrank.thirtydayschellange.day25;
/*
 * Solution for the task based on Sieve of Eratosthenes
 */
import java.io.*;
import java.util.*;
/*
 * A prime is a natural number greater than  that has no positive divisors other than  and itself. Given a number, , determine and print whether it's  or .

Note: If possible, try to come up with a  primality algorithm, or see what sort of optimizations you come up with for an  algorithm. Be sure to check out the Editorial after submitting your code!
 */
public class Solution {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	final int T = scan.nextInt();
    	
    	int[] input = new int[T];
    	
    	for ( int i = 0; i<T; i++) {
    		input[i] = scan.nextInt();
    	}
    	scan.close();
    	
    	boolean[] prime = checkForPrimes(input);

    	for(int i : input) {
    		if(prime[i]) {
    			System.out.println("Prime");
    		}else {
    			System.out.println("Not prime");
    		}
    	}
    }

	private static boolean[] checkForPrimes(int[] input) {
		int[] tmp;
		tmp = input.clone();
		Arrays.sort(tmp);
		final int last = tmp.length-1;
		
		boolean prime[] = new boolean[tmp[last]+1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		for(int i = 2; i<= Math.sqrt(tmp[last]); i++) {
			for(int t = i+i; t<tmp[last]+1; t = t+i) {
				prime[t] = false;
			}
		}
		
		return prime;
	}
}