package TreesAndGraphs;
/**
 * 
 * @author prateek
 * Texas A&M University
 *
 */
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
public class BalancedTree {
	
	/**
	 * Check if tree is balanced
	 * @param args
	 */
	static boolean TreeBalanced(TreeNode root){
		if(root==null) return true;
		if(root.left==null && root.right==null) return true;
		
		return Math.abs(maxheight(root)-minheight(root))<=1;
	}
	/*
	 * Find Max Depth of the tree;
	 */
	private static int maxheight(TreeNode root) {
		if(root==null) return 0;
		return 1+Math.max(maxheight(root.left), maxheight(root.right));
	}
	
	private static int minheight(TreeNode root) {
		if(root==null) return 0;
		return 1+Math.max(minheight(root.left), minheight(root.right));
	}
	
	/*
	 * Create tree with minimal height 
	 */
	
	public static TreeNode createMinimalTree(int[] arr){
		return createMinimalTree(arr,0,arr.length-1);
	}
	
	private static TreeNode createMinimalTree(int[] arr, int start, int end) {
		if(end<start)
			return null;
		
		int mid = start + (end-start)/2;
		TreeNode root = new TreeNode(mid);
		
		root.left = createMinimalTree(arr, start, mid-1);
		root.right = createMinimalTree(arr, mid+1, end);
		
		return root;
	}
	/*
	 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
	 */
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(4);
//		root.left.left = new TreeNode(3);
//		System.out.println(TreeBalanced(root));
//		
		
	}
}
