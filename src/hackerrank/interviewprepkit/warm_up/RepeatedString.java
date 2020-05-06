package hackerrank.interviewprepkit.warm_up;
/*
 * Lilah has a string, , of lowercase English letters that she repeated infinitely many times.

Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.

For example, if the string  and , the substring we consider is , the first  characters of her infinite string. There are  occurrences of a in the substring.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    public static long repeatedString(String s, long n) {		
		long contains = n/s.length();		
		long counter = countLetters(s,s.length(),'a');;
		long fix = countLetters(s,n%s.length(),'a');

		long result = (contains*counter)+fix;
    	return result;
    }

    public static long countLetters(String s, long length, char letterToFind) {
    	long count = 0;
    	for (int i = 0 ; i < length ; i++) {
    		if(s.charAt(i) == letterToFind) {
    			count++;    			
    		}
    	}
    	return count;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
