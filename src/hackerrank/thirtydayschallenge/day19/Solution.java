package hackerrank.thirtydayschallenge.day19;
/*
 * he AdvancedArithmetic interface and the method declaration for the abstract divisorSum(n) method are provided for you in the editor below.

Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface. The implementation for the divisorSum(n) method must return the sum of all divisors of .
 */
import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
   int divisorSum(int n);
}
class Calculator implements AdvancedArithmetic {
   
	public int divisorSum(int n) {
		int result = 0; 
		
		Vector<Integer>  divisors = getNumberDivisors(n);
		for( int p : divisors) {
			result += p;
		}
		return result;
    }

	private Vector<Integer> getNumberDivisors(int n) {
		Vector<Integer> divisors = new Vector<>();
		
		for( int i = 1; i<= Math.sqrt(n) ; i++) {
			if( n%i == 0) {
				if(n/i == i) {
					divisors.add(i);
				}else {
					divisors.add(i);
					divisors.add(n/i);
				}
			}
		}
		return divisors;
	}
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}
