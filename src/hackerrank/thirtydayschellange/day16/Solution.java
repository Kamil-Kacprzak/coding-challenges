package hackerrank.thirtydayschellange.day16;
/*
 * Read a string, , and print its integer value; if  cannot be converted to an integer, print Bad String.

Note: You must use the String-to-Integer and exception handling constructs built into your submission language. If you attempt to use loops/conditional statements, you will get a  score.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        try{
        	System.out.println(Integer.parseInt(S));
        }catch(NumberFormatException e) {
        	System.out.println("Bad String");
        }
        in.close();
    }
}