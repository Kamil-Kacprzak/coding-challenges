package hackerrank.interviewprepkit.arrays;
/*
 *  https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

// Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int counter = 0;
        
        for(int i =0; i< q.length; i++) {
            if(q[i] > i+3) {
                System.out.println("Too chaotic");
                return;
            }else {
                if(q[i] <= i+1) {
                    for(int j = i; j < q.length; j++){
                        if(q[i]> q[j]){
                            counter++;
                            break;
                        }
                    }
                }else if(q[i] == i+2) {
                    counter++;
                }else {
                    counter+=2;
                }
            }
        }
       System.out.println(counter);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
