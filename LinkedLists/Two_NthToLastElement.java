package LinkedLists;

public class Two_NthToLastElement {
	public static Node nthToLast(Node head, int n) {
		if(head==null || n<=0) return null;
		Node p1 = head;
		Node p2 = head;
		while(p2.next != null && n>0){
			p2=p2.next;
			n--;
		}
		if(n>0) return null;
		
		while(p2.next!=null){
			p1=p1.next;
			p2=p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		
	}
}
