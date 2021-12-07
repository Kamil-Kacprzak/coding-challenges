package hackerrank.problemsolving.algorithms;
/*
 * https://www.hackerrank.com/challenges/electronics-shop/problem?isFullScreen=true
 */

import java.io.*;
import java.util.*;

public class ElectronicsShop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int budget = sc.nextInt();
        final int keyboardCount = sc.nextInt();
        final int usbCount = sc.nextInt();
        Integer[] keyboards = new Integer[keyboardCount];
        Integer[] usbs	=	new Integer[usbCount];
        
        for(int i = 0; i<keyboardCount; i++) {
        	keyboards[i] = sc.nextInt();
        }
        
        for(int i = 0; i<usbCount; i++) {
        	usbs[i] = sc.nextInt();
        }
        sc.close();
        //Function required by the challenge description
        System.out.println(getMoneySpent(keyboards, usbs, budget));
    }

    // O(n*m)
//    private static int getMoneySpent(int[] keyboards, int[] usbs, int budget) {
//		int result = -1;
//		for(int i = keyboards.length-1; i>=0; i--) {
//			for(int j = usbs.length-1; j>=0; j--) {
//				int tmp = keyboards[i] + usbs[j];
//				if(tmp <= budget && tmp > result) {
//					result = tmp;
//				}
//			}
//		}
//		return result;
//	}
    
//     O(n+m); sorting O(n log n)
  private static int getMoneySpent(Integer[] keyboards, Integer[] usbs, int b) {
        Arrays.sort(keyboards); 
        Arrays.sort(usbs);   
        int result = -1;
        int i = 0;
        int j = usbs.length - 1;
        while (i < keyboards.length && j >= 0) { 
            int tmp = keyboards[i] + usbs[j];
            if (tmp > b) {
                j--; // look for a cheaper usb
            } else {
                if (tmp > result) {
                    result = tmp;
                }
                i++; // look for a more expensive keyboard
            }
        }
        return result;
    }
    
//    //Recursive algorithm
//    private static Integer getMoneySpent(Integer[] keyboards, Integer[] usbs, int budget) {
//    	//Sort from most to least expensive
//    	Arrays.sort(keyboards,Collections.reverseOrder());
//    	Arrays.sort(usbs, Collections.reverseOrder()); 
//    	//If the sum of two cheapest items exceed budget, return -1, since it's not possible to buy it
//    	if(keyboards[keyboards.length-1] + usbs[usbs.length-1] > budget) {
//    		return -1;
//    	}
//    	//Determine which array is longer in order to pass it to function
//    	if(keyboards.length >= usbs.length) {
//    		return findMaxInDiag(keyboards, usbs, budget, 0, keyboards.length, usbs.length);
//
//    	}else {
//    		return findMaxInDiag(usbs,keyboards , budget, 0, usbs.length, keyboards.length);
//    	}
//    }
//    /*
//     * Recursive function, looking on the diagonal of a table made from 2 arrays, 
//     * for the first most expensive pair. If multiple pairs can be formed on one depth - find max
//     *
//     *EDIT: Error in logic, first pair on diagonal doesn't have to be the biggest overall. 
//     *All need to be checked which leaves the solution with O(n*m) - double loop with so many extra steps
//     *Quick mod to make it work, 
//     *				IT'S UGLY THERE, DON'T LOOK... please don't look
//     *
//     *  x/y		|   |    |   |
//     *  ----  1   2   3    4
//     *  ----  2   3   4    5
//     *  ----  3   4   5    6
//     */ 
//    private static List<Integer> potentialMax = new LinkedList<Integer>();
//    private static int findMaxInDiag(Integer[] bigArr, Integer[] smallArr, int budget, int depth, int bigSize, int smallSize){
//    	boolean found = false;    	
//    	int adjust = 0;
//    	// List of all values meeting contract on diagonal
//    	
//    	//If depth is higher than the size of one of the arrays, create adjustment to avoid out of band exception
//    	if (depth > smallSize -1) {
//    		adjust = depth - (smallSize-1);
//    	}    	
//    	//Add all matching pairs on diagonal 
//	    	for (int smallArrInc = depth - adjust, bigArrInc = 0 + adjust;
//	    		smallArrInc >= 0 && bigArrInc < bigArr.length;
//	    		smallArrInc--,bigArrInc++ ) {
//		    		int tmp = bigArr[bigArrInc] + smallArr[smallArrInc];	
//		    		
//		    		if(tmp <= budget) {
//		    			potentialMax.add(tmp);
//		    		}    		
//		    		if(bigArrInc == bigSize -1 && smallArrInc == smallSize-1) {
//		    			found = true;
//		    		}
//	    	}  
//    	//If a match was found return the max out of all matches, otherwise look for a match on higher depth
//    	if(!found) {
//			return findMaxInDiag(bigArr, smallArr, budget, depth+1, bigSize, smallSize);
//		}else {
//			return Collections.max(potentialMax);
//		}
//    }
}




