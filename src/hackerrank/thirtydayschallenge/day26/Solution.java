package hackerrank.thirtydayschallenge.day26;
/*
 * Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:

If the book is returned on or before the expected return date, no fine will be charged (i.e.: .
If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, .
If the book is returned after the expected return month but still within the same calendar year as the expected return date, the .
If the book is returned after the calendar year in which it was expected, there is a fixed fine of .
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
    	int returnedDay = scan.nextInt();
    	int returnedMonth = scan.nextInt();
    	int returnedYear = scan.nextInt();
    	
    	scan.nextLine();
    	
    	int expectedDay = scan.nextInt();
    	int expectedMonth = scan.nextInt();
    	int expectedYear = scan.nextInt();
    	
    	scan.close();
    	
    	if(returnedYear < expectedYear){
 			System.out.println(0);
 		}else if(returnedYear > expectedYear) {
    		System.out.println(10000);
    	}else {
    		if ( expectedMonth < returnedMonth) {
    			System.out.println(500*(returnedMonth-expectedMonth));
    		}else if ( expectedDay < returnedDay) {
    				System.out.println(15*(returnedDay-expectedDay));
    		}else {
    			System.out.println(0);
    		}
    	}    	
    }
}