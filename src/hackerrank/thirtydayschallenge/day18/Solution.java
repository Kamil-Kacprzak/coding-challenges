package hackerrank.thirtydayschallenge.day18;
/*
 * o solve this challenge, we must first take each character in , enqueue it in a queue, and also push that same character onto a stack. Once that's done, we must dequeue the first character from the queue and pop the top character off the stack, then compare the two characters to see if they are the same; as long as the characters match, we continue dequeueing, popping, and comparing each character until our containers are empty (a non-match means  isn't a palindrome).

Write the following declarations and implementations:

Two instance variables: one for your , and one for your .
A void pushCharacter(char ch) method that pushes a character onto a stack.
A void enqueueCharacter(char ch) method that enqueues a character in the  instance variable.
A char popCharacter() method that pops and returns the character at the top of the  instance variable.
A char dequeueCharacter() method that dequeues and returns the first character in the  instance variable.
 */
import java.io.*;
import java.util.*;

public class Solution {
    
	private String queue ="";
	private String stack = "";
	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution p = new Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }

	private char dequeueCharacter() {			
		if(queue.length() > 0 ) {
			char result = queue.charAt(0);
			queue.substring(1);
			return result;
		}else {
			return '0';
		}
	}

	private char popCharacter() {
		if(stack.length() > 0 ) {
			char result = stack.charAt(stack.length()-1);
			stack.substring(0,stack.length()-1);
			return result;
		}else {
			return '0';
		}
	}

	private void enqueueCharacter(char c) {
		queue +=c;
	}

	private void pushCharacter(char c) {
		stack +=c;
	}
}