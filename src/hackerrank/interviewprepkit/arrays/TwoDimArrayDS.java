package hackerrank.interviewprepkit.arrays;
/*
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 
 * Finding the sum of the biggest hourglass in two dimensional array
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoDimArrayDS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	final int INDENT = arr[0].length+1;
    	final int BOTTOM = INDENT + arr[0].length -1;
    	
    	final int SIZE = arr.length*arr[0].length;
    	int[] dataSet = new int[SIZE];
    	
    	int row = arr[0].length;
    	int columnBoundry = arr[0].length - 2;
    	long rowBoundry = (arr.length-2)*arr[0].length;
    	
    	int result = Integer.MIN_VALUE;
    	
    	for(int i = 0; i<arr.length;i++) {
    		System.arraycopy(arr[i], 0, dataSet, i*row, row);
    	}
    	for(int top = 0;top<rowBoundry;top++) {
    		if(top%row < columnBoundry) {
    			int sum = (dataSet[top]+dataSet[top+1]+dataSet[top+2])
    						+dataSet[top+INDENT]
    						+(dataSet[top+BOTTOM]+dataSet[top+BOTTOM+1]+dataSet[top+BOTTOM+2]);
    			if(sum > result) {
    				result = sum;
    			}
    		}
    	}
    	
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
