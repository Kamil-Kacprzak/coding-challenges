package hackerrank.interviewprepkit.strings;

/*
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings&isFullScreen=true
 *  */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlokcAndTheValidString {

	//TODO: Refactor + 1 failed test case
    // Complete the isValid function below.
//    static String isValid(String s) {
//    	s = s.toLowerCase();
//    	int[] letterOcurrence = new int[26];
//    	for(int i = 0; i<s.length(); i++) {
//    		char letter = s.charAt(i);
//    		letterOcurrence[letter -97]++;
//    	}
//
//    	boolean isAdjusted = false;
//    	boolean prevMatch = false;
//    	int commonNumber = 0;
//    	for(int i = 0; i< letterOcurrence.length; i++) {
//    		if(letterOcurrence[i] != 0){
//    			commonNumber = letterOcurrence[i];
//    		}else {
//    			continue;
//    		}    		
//    		
//    		if(commonNumber != letterOcurrence[i+1] && letterOcurrence[i+1] != 0) {
//    			if(!isAdjusted && !prevMatch) {
//    				
//    				if(i+2 < letterOcurrence.length && letterOcurrence[i+1] == letterOcurrence[i+2]) {
//    					isAdjusted = true;
//        				int badNum = letterOcurrence[i];
//        				commonNumber = letterOcurrence[i+1];
//        				letterOcurrence[i] = badNum == commonNumber+1? badNum-1 : badNum == commonNumber-1? badNum+1 : -1;
//        				if(letterOcurrence[i] == -1) {
//        					return "NO";
//        				}
//    				}
//    			}
//    			else if(!isAdjusted) {
//    				isAdjusted = true;
//    				int badNum = letterOcurrence[i+1];
//    				letterOcurrence[i+1] = badNum == commonNumber+1? badNum-1 : (badNum == commonNumber-1? badNum+1 : -1);
//    				if(letterOcurrence[i+1] == -1) {
//    					return "NO";
//    				}
//    			}
//    			else {
//    				return "NO";
//    			}
//    		}
//    		prevMatch  = true;
//    	}
//    	return "YES";
//    }
	
	static String isValid(String s) {
		s.toLowerCase();
		HashMap<Character, Integer> letters = new HashMap<>();
		for(char c : s.toCharArray()) {
			if(letters.containsKey(c)) {
				int value = letters.get(c);
				letters.put(c, ++value);
			}else {
				letters.put(c, 1);
			}
		}
		
//		Has
//		for()
		
		return "YES";
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
