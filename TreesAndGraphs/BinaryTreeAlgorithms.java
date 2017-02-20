package TreesAndGraphs;

import java.util.ArrayList;

/**
 * 
 * @author prateek
 * Texas A&M University
 */
public class BinaryTreeAlgorithms {
	
	/**
	 * Design an algorithm and write code to !nd the !rst common ancestor of two nodes
		in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
		necessarily a binary search tree.
	 * @param args
	 */
	public static TreeNode firstCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root==null)
			return null;
		
		if(root == p) return root;
		if(root == q) return root;
		
		TreeNode left = firstCommonAncestor(root.left,p,q);
		TreeNode right = firstCommonAncestor(root.right, p, q);
		
		if(left!=null && right!=null){
			return root;
		}
		
		return left!=null?left:right;
	}
	
	/**
	 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds
		of nodes. Create an algorithm to decide if T2 is a subtree of T1.
	 * @param args
	 */
	public static boolean subTree(TreeNode t1, TreeNode t2){
		//Can be done easily using recursion
		return true;
	}
	
	/**
	 * You are given a binary tree in which each node contains a value. Design an algorithm
		to print all paths which sum up to that value. Note that it can be any path in the tree
		it does not have to start at the root
	 * @param args
	 */
	public static void printAllPathsWithValue(TreeNode root, int s){
		if(root==null) return;
		printAllPaths(root,s,new ArrayList<Integer>(),0);
	}
	
	private static void printAllPaths(TreeNode root, int s, ArrayList<Integer> buffer,int level) {
		if(root==null) return;
		buffer.add(root.val);
		int tmp = s;
		for(int i=level;i>-1;i--){
			tmp -= buffer.get(i);
			if(tmp==0) printList(buffer,i,level);
		}
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		
		printAllPaths(root.left, s, c1, level+1);
		printAllPaths(root.right, s, c2, level+1);
	}
	

	private static void printList(ArrayList<Integer> buffer, int i, int level) {
		for(int x=i;x<=level;x++){
			System.out.print(buffer.get(x)+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.left.right = new TreeNode(6);
		root.left.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		
		printAllPathsWithValue(root,1);
	}
}
