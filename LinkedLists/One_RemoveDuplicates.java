package LinkedLists;

import java.util.HashMap;

public class One_RemoveDuplicates {
	/**
	 * Using Hash with timeComplexity O(n) and space complexity O(n)
	 * @param head
	 */
	public static void RemoveDuplicates(Node head) {
		HashMap<Integer, Integer> map = new HashMap<>();
		if(head==null || head.next==null) return;
		Node n = head;
		Node previous = null;
		while(n!=null){
			if(map.containsKey(n.data)){
				previous.next = n.next;
			} else {
				map.put(n.data, 1);
				previous = n;
			}
			n=n.next;
		}
	}
	/**
	 * Without using memory
	 * @param head
	 */
	public static void RemoveDuplicatesWithoutSpace(Node head) {
		
	}
	
	public static void main(String[] args) {
		Node a = new Node(1);
		a.appendToTail(2);
		a.appendToTail(1);
		RemoveDuplicates(a);
		while(a!=null){
			System.out.println(a.data);
			a=a.next;
		}
		
	}
}
