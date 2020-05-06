package hackerrank.thirtydayschellange.day11;
/*
 * Given a  2D Array, :

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:

a b c
  d
e f g
There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values.
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
    private static final Integer SIZE = 6;
    public static void main(String[] args) {
        int[][] arr = new int[SIZE][SIZE];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();
        
        System.out.println(findHourglass(arr).toString());
    }

    private static Integer findHourglass(int[][] arr) {
        Integer result = null;
        int boundry = SIZE -2;
        
        for(int i =0; i < boundry; i++) {
            for(int j = 0; j < boundry; j++) {
                int tmp = sumHourglass(arr,i,j);
                if(tmp > result || result == null) {
                	result = tmp;
                }
            }
        }        
        return result;
    }

    private static int sumHourglass(int[][] arr, int i, int j) {
        int sum = 0;
        int[] row = new int[3];
        
        row[0] = arr[i][j]+arr[i][j+1]+arr[i][j+2];
        row[1] = arr[i+1][j+1];
        row[2] = arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
        
        sum = row[0]+row[1]+row[2];
        
        return sum;
    }
}

