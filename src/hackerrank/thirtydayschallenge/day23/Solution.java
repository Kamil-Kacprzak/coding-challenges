package hackerrank.thirtydayschallenge.day23;
/*
 * A level-order traversal, also known as a breadth-first search, visits each level of a tree's nodes from left to right, top to bottom. You are given a pointer, , pointing to the root of a binary search tree. Complete the levelOrder function provided in your editor so that it prints the level-order traversal of the binary search tree.

Hint: You'll find a queue helpful in completing this challenge.
 */
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

class Node {
	Node left, right;
	int data;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class Solution {

	static Queue<Node> nodesQueue = new LinkedList<>();
	static Queue<Integer> resultQueue = new LinkedList<>();

	static void levelOrder(Node root) {
		if(root == null) {
			return;
		}else {
			resultQueue.add(root.data);			
		}
		
		if(root.left != null) {
			nodesQueue.add(root.left);
		}
		
		if(root.right != null) {
			nodesQueue.add(root.right);
		}
		
		while(!nodesQueue.isEmpty()) {
			Node tmp = nodesQueue.poll();
			
			resultQueue.add(tmp.data);
			
			if(tmp.left != null) {
				nodesQueue.add(tmp.left);
			}
			
			if(tmp.right != null) {
				nodesQueue.add(tmp.right);
			}
		}
		
		resultQueue.stream().forEach(S -> System.out.print(S+" "));
		
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		levelOrder(root);
	}
}