package hackerrank.problemsolving.algorithms;
/*
 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?isFullScreen=true
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

public class DivisbleSumPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
//        int result = 0;
//        ar.sort(null);
//        ListIterator<Integer> it = ar.listIterator();        
//        
//        while(it.hasNext()) {
//            int value = it.next();
//            it.remove();
//            for (int i : ar) {
//                if((value + i) % k == 0) {
//                    result++;
//                }
//            }
//        }    
//        return result;
    	int count = 0;
    	ar.sort(null);
    	List<Integer> modulos = new LinkedList<>();
    	for (int i : ar) {
    		modulos.add(i % k);
    	}
    	
    	ListIterator<Integer> it = modulos.listIterator();
    	while(it.hasNext()) {
    		int value = it.next();
    		it.remove();
    		for(int i : modulos) {
    			int tmp = value + i;
    			if(tmp == k || tmp == 0 ) {
    				count++;
    			}
    		}
    	}    	
    	return count;
    }
}
