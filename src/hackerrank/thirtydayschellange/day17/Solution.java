package hackerrank.thirtydayschellange.day17;
/*
 * Write a Calculator class with a single method: int power(int,int). The power method takes two integers,  and , as parameters and returns the integer result of . If either  or  is negative, then the method must throw an exception with the message: n and p should be non-negative.
 */
import java.util.*;
import java.io.*;

class Calculator{

	public int power(int n, int p) {
		int result = n;
		try {
			if(n < 0 || p < 0) {
				throw new ArithmeticException("n and p should be non-negative");			
			}
			if(p == 0) {
				return 1;
			}else {
				for (int i = p ; i>1; i--) {
					result *= n;
				}				
			}
		}catch (ArithmeticException e) {
			throw e;
		}		
		return result;
	}
}

public class Solution{

    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
        
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}
