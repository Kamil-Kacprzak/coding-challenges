package hackerrank.problemsolving.algorithms;
/*
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    	int plusCount = 0, minusCount = 0;
    	for (int i : arr) {
    		if(i > 0) {
    			plusCount++;
    		}else if (i < 0) {
    			minusCount++;
    		}    		
    	}
    	final DecimalFormat df = new DecimalFormat("#0.000000");
    	double size = arr.size();
    	double plusRatio = (double) plusCount/size;
    	double minusRatio = (double) minusCount/size;
    	double zeroRatio = 1.0 - (plusRatio+minusRatio);
    	System.out.println(df.format(plusRatio));
    	System.out.println(df.format(minusRatio));
    	System.out.println(df.format(zeroRatio));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
