package hackerrank.interviewprepkit.hashmaps;
/*
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps&isFullScreen=true
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int result = 0;
        ArrayList<String> subsets = new ArrayList<>();
        
        for(int i =0; i<s.length(); i++) {
            for(int j=i+1 ; j<=s.length(); j++) {
                String subset = s.substring(i, j);
                subsets.add(subset);
            }
        }
        
        for (int j = 0; j < subsets.size(); j++) {
            String element = subsets.get(j);
            for (int k = j+1; k < subsets.size(); k++) {
                if(isAnagram(subsets.get(k), element)){
                    result++;
                }
            }
        }
        
        return result;
    }
    
    public static boolean isAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int[] lettermap = new int[26];
        for(int j=0; j<a.length(); j++){
            char ch = a.charAt(j);
            lettermap[ch - 'a']++;
            ch = b.charAt(j);
            lettermap[ch - 'a']--;
        }

        for(int j=0; j<lettermap.length; j++){
            if(lettermap[j] != 0){
                return false;
            }
        }
        return true;
    }
    
    

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
