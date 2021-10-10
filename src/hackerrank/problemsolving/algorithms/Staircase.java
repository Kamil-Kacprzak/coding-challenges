package hackerrank.problemsolving.algorithms;
/*
 * https://www.hackerrank.com/challenges/staircase/problem
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;


public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        staircase(n);

        bufferedReader.close();
    }
    
    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    //Commented solution kept for educational purpose 
    //Also, valid solution before Java 11
    public static void staircase(int n) {
    	String print;
//    	String spaces;
    	for (int i = 1; i <= n; i++) {
//    		print = String.join("", Collections.nCopies(i, "#"));
//    		spaces = new String (new char[n-i]).replace("\0"," ");
//    		print = spaces + print;
    		print = " ".repeat(n-i) + "#".repeat(i);
    		System.out.println(print);
		}
    }
}
