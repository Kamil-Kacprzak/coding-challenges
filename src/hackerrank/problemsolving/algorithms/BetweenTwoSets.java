package hackerrank.problemsolving.algorithms;

import static java.util.stream.Collectors.toList;

/*
 * https://www.hackerrank.com/challenges/between-two-sets/problem?isFullScreen=true
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    	int aLCM = a.stream().reduce(a.get(0), (c,d) -> lcm(c,d));
    	int bGCD = b.stream().reduce(b.get(0), (c,d) -> gcd(c,d));    	
    	int result = (bGCD % aLCM == 0) ? divisors(bGCD / aLCM) : 0;    	
    	return result;
    }
    
    private static int divisors(int n) {
    	int divCount = 0;
    	int sqrt = (int) Math.sqrt(n);
    	
    	for(int i = 1; i <= sqrt; i++) {
    		if (n % i == 0) {
    			divCount += 2;
    		}
    	}
    	// For sqrt which is a divisor, count it once
    	if(sqrt * sqrt == n) {
    		divCount--;
    	}
    	
		return divCount;
	}
    //Greatest common divisor - Euclid's method with modulo in order to perform multiple subtractions at once
	public static int gcd( int a, int b) {
    	if(b == 0) {
    		return a;
    	}
    	return gcd(b, a % b);
    }
    // Least common multiple - a * b in case no divisor exist(gcd = 1)
    public static int lcm(int a, int b) {
    	return (a * b) / gcd(a, b);
    }
}
