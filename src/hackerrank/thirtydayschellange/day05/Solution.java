package hackerrank.thirtydayschellange.day05;
/*
 * Given an integer, , print its first  multiples. Each multiple  (where ) should be printed on a new line in the form: n x i = result.
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
        scanner.close();
        
        for (int i=1; i<=10; i++) {
        	System.out.println(n+" x "+i+" = "+i*n);
        }
    }
}
