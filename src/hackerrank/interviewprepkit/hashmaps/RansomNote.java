package hackerrank.interviewprepkit.hashmaps;

/*
 *  https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps&isFullScreen=true
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	Map<String,Integer> magazineCheck = new HashMap<>();
    	
    	for(String s : magazine) {
    		int value = magazineCheck.getOrDefault(s, 0)+1;
    		magazineCheck.put(s, value);	
    	}
    	
    	for(String s : note) {
    		if(magazineCheck.containsKey(s)) {
    			if(magazineCheck.get(s) > 0) {
    				int value = magazineCheck.get(s)-1;
    				if(value > 0) {
    					magazineCheck.put(s, value);
    				}else {
    					magazineCheck.remove(s);
    				}
    			}else {
    				System.out.println("No");
    				return;
    			}
    		}else {
    			System.out.println("No");
    			return;
    		}
    	}
    	System.out.println("Yes");
    	return;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);
        
        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
