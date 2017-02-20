package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author prateek
 * Texas A&M University
 */

class TreeParent{
	int val;
	TreeParent left;
	TreeParent right;
	TreeParent parent;
	TreeParent(int val){
		this.val = val;
	}
}
public class BinarySearchTree {
	
	/**
	 * Given a binary search tree, design an algorithm which creates a linked list of all the
		nodes at each depth (i.e., if you have a tree with depth D, you’ll have D linked lists)
	 * @param args
	 */
	public static List<List<Integer>> listOfNodesatDepthD(TreeNode root){
		LinkedList<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for(int i=0;i<size;i++){
				TreeNode node = queue.pop();
				if(node.left!=null)
					queue.addLast(node.left);
				if(node.right!=null)
					queue.addLast(node.right);
				temp.add(node.val);
			}
			result.add(temp);
		}
		return result;
	}
	
	/**
	 * Write an algorithm to !nd the ‘next’ node (i.e., in-order successor) of a given node in
		a binary search tree where each node has a link to its parent
		Time Complexity O(log n)
	 * @param args
	 */
	public static TreeParent inorderSuccessor(TreeParent t){
		TreeParent temp = t;
		
		if(temp!=null){
			if(temp.right!=null || temp.parent==null){
				temp=temp.right;
				while(temp.left!=null){
					temp=temp.left;
				}
				return temp;
			}else{
				if(temp == temp.parent.left){
					return temp;
				} else if(temp==temp.parent.right){
					TreeParent p = temp.parent;
					while(p!=null){
						if(p.left==temp){
							break;
						}
						temp = p;
						p=temp.parent;
					}
					return p;
				}
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		System.out.println(listOfNodesatDepthD(root).toString());
	}
}
