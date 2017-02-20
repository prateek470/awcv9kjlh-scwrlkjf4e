package LinkedLists;
/**
 * You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
the list. Write a function that adds the two numbers and returns the sum as a linked
list.
 * @author prateek
 *
 */
public class Four_SumLinkedList {
	public static Node SumList(Node n1, Node n2){
		Node res= new Node(0);
		int carry = 0;
		while(n1!=null && n2!=null){
			int sum = n1.data+n2.data+carry;
			res.appendToTail(sum%10);
			carry = sum/10;
			n1=n1.next;
			n2=n2.next;
		}
		
		while(n2!=null){
			int sum = n2.data+carry;
			res.appendToTail(sum%10);
			carry = sum/10;
			n2=n2.next;
		}
		while(n1!=null){
			int sum = n1.data+carry;
			res.appendToTail(sum%10);
			carry = sum/10;
			n1=n1.next;
		}
		if(carry>0) res.appendToTail(carry);
		return res.next;
		
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(3);
		n1.appendToTail(1);
		n1.appendToTail(2);
		
		Node n2 = new Node(5);
		n2.appendToTail(9);
		n2.appendToTail(9);
		
		Node res = SumList(n1,n2).reverseList();
		while(res!=null){
			System.out.println(res.data);
			res=res.next;
		}
		
	}
}
