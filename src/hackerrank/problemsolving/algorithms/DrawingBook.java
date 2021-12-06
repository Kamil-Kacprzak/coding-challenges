package hackerrank.problemsolving.algorithms;
/*
 * https://www.hackerrank.com/challenges/drawing-book/problem?isFullScreen=true
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

public class DrawingBook {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
    public static int pageCount(int n, int p) {
   		int pBackward = n%2 == 0 ? n - p + 1 : n - p;
   		return Math.min(p/2, pBackward/2);   	
    }
    
    public static int pageCount2O_n(int n, int p) {
    	int frontResult = 0;
    	int backResult = 0;
    	for(int atPage = 1; atPage< n; atPage += 2) {
    		if (p <= atPage) {
    			break;
    		}else {
    			frontResult++;    			
    		}
    	}
    	for(int atPage = n%2 == 0 ? n : n-1; atPage > 1; atPage -=2) {
    		if (p >= atPage) {
    			break;
    		}else {
    			backResult++;
    		}
    	}
    	return frontResult < backResult ?  frontResult : backResult;
    }
    
    public static int pageCountO_n(int n, int p) {
    	int count = 0;
    	int backPage = n%2 == 0 ? n : n-1;
    	for(int atPage = 1; atPage< n; atPage += 2) {
    		if (p <= atPage || p >= backPage) {
    			break;
    		}else {
    			count++;  
    			backPage -= 2;
    		}
    	}
    	return count;
    }
    

}
