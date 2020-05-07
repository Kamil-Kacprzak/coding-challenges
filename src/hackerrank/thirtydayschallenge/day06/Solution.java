package hackerrank.thirtydayschallenge.day06;
/*
 * Given a string, , of length  that is indexed from  to , print its even-indexed and odd-indexed characters as  space-separated strings on a single line (see the Sample below for more detail).

Note:  is considered to be an even index.
 */
import java.io.*;
import java.util.*;

public class Solution {

	private static final Scanner scan = new Scanner(System.in);
	private static final int EVEN = 0;
	private static final int ODD  = 1;
	
	private static StringBuilder[] evenOddStringSeparator(String s) {
		StringBuilder[] results = new StringBuilder[2];
		for(int i = 0; i< results.length;i++) {
			results[i] = new StringBuilder();
		}

		char 	 charAt;
		
		for (int i = 0; i<s.toCharArray().length;i++) {
			
			if ( i%2 == 0) {
				charAt = s.charAt(i);
				results[EVEN].append(charAt);
			}else {
				charAt = s.charAt(i);
				results[ODD].append(charAt);
			}	
		}
		return results;
	}
	
	public static void main(String[] args) {
		
		int n = scan.nextInt();
	    scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	    String[] input = new String[n];
	    
	    for( int i = 0; i<n; i++) {
		   input[i] = scan.nextLine();
	    }
	    
	    StringBuilder[] output;
	    
	    for (String s : input) {
	    	output = evenOddStringSeparator(s);
	    	System.out.println(output[EVEN]+" "+output[ODD]);
	    }

        scan.close();
    }
}

