package hackerrank.interviewprepkit.hashmaps;

/*
 * https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps&isFullScreen=true&h_r=next-challenge&h_v=zen
 * 
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoStrings {

	// Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        HashSet<Integer> str1 = new HashSet<Integer>();
        for (char c : charArray1) {
            str1.add((int) c);
        }
        for (char c : s2.toCharArray()) {
            if (str1.contains((int) c)) {
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
