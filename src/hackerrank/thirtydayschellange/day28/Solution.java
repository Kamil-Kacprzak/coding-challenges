package hackerrank.thirtydayschellange.day28;
/*
 * Consider a database table, Emails, which has the attributes First Name and Email ID. Given  rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends in .
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        List<String> tmpResult = new ArrayList();
        
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            
            Matcher m = Pattern.compile("@gmail.com").matcher(emailID);
            if(m.find()) {
            	tmpResult.add(firstName);
            }
        }
        String[] result = new String[tmpResult.size()];
        tmpResult.toArray(result);
        Arrays.sort(result);
        for( String r : result) {
        	System.out.println(r);
        }

        scanner.close();
        
        
    }
}
