package hackerrank.interviewprepkit.strings;
/*
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings&isFullScreen=true
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    	int result = 0;
    	int[] letters = new int[26];
    	for(int i =0; i<a.length(); i++) {
    		char c = a.charAt(i);
    		letters[c-97]++;
    	}
    	for(int i =0; i<b.length(); i++) {
    		char c = b.charAt(i);
    		letters[c-97]--;
    	}
    	
    	for(int i =0; i<letters.length; i++) {
    		result += Math.abs(letters[i]);
    	}

    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
