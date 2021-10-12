package hackerrank.problemsolving.algorithms;

/*
 * https://www.hackerrank.com/challenges/time-conversion/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
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

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
    public static String timeConversion(String s) {
    	String period = s.substring(s.length()-2);
    	String result = s.substring(0, s.length()-2);
    	String hour = result.substring(0,2);
    	if(hour.equals("12") && period.equals("AM")) { 
			result = result.replaceFirst("12", "00");
    	}else if(!hour.equals("12") && period.equals("PM")){
    		int time = Integer.valueOf(hour);
    		result = result.replaceFirst(hour, String.valueOf((time+12)));
    	}else {
    		//Correct output. Nothing to change.
    	}    	
    	return result;
    }
}
