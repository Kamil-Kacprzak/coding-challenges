package hackerrank.problemsolving.algorithms;
/*
 * https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Kangaroos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        boolean result;
        if (v1 <= v2) {
            return "NO";
        } else {
        	// If difference in distance is divisible by difference in speed - they will meet
            result = (x2 - x1) % (v2 - v1) == 0;
        }
        return result == true ? "YES" : "NO";
    }
}
