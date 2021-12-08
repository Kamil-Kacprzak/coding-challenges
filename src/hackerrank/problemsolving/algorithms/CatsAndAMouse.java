package hackerrank.problemsolving.algorithms;
/*
 * https://www.hackerrank.com/challenges/cats-and-a-mouse/problem?isFullScreen=true
 */
import java.io.*;
import java.util.*;

public class CatsAndAMouse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        int[] queries = new int[n];
        for(int i = 0; i<n; i++) {
        	int cat1 = sc.nextInt();
        	int cat2 = sc.nextInt();
        	int mouse = sc.nextInt();
        	catAndMouse(cat1,cat2,mouse);
        }
        sc.close();
    }

	private static void catAndMouse(int cat1, int cat2, int mouse) {
		int diff1 = Math.abs(mouse-cat1);
		int diff2 = Math.abs(mouse-cat2);
		if( diff1 < diff2) {
			System.out.println("Cat A");
		}else if(diff1 > diff2) {
			System.out.println("Cat B");
		}else {
			System.out.println("Mouse C");
		}
	}    
}