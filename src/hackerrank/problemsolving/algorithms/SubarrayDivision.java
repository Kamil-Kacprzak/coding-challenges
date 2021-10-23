package hackerrank.problemsolving.algorithms;
/*
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem?isFullScreen=false
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

public class SubarrayDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = birthday(s, d, m);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
    public static int birthday(List<Integer> s, int d, int m) {
    	int result = 0;
    	for(int i = 0; i + m <= s.size(); i++) {
    		List<Integer> subList = s.subList(i, i+m);
    		int sum = subList.stream().reduce(0, Integer::sum);
    		if(sum == d) {
    			++result;
    		}
    	}
    	return result;
    }

}
