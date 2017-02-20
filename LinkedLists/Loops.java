package LinkedLists;

public class Loops {
	public static Boolean isLoopPresent(Node n){
		Node n1 = n.next;
		Node n2 = n.next.next;
		
		while(n1!=null && n2!=null){
			if(n1.data==n2.data)
				return true;
			else{
				n1=n1.next;
				if(n2.next==null) n2=null;
				else n2= n2.next.next;
			}
		}
		return false;
	}
	
	public static Node findStartOfLoop(Node n){
		Node n1 = n.next;
		Node n2 = n.next.next;
		
		while(n1!=null && n2!=null){
			if(n1.data==n2.data)
				break;
			else{
				n1=n1.next;
				if(n2.next==null) n2=null;
				else n2= n2.next.next;
			}
		}
		
		n1 = n;
		while(n1!=null && n2!=null){
			if(n1.data == n2.data){
				return n1;
			}else{
				n1=n1.next;
				n2=n2.next;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.appendToTail(2);
		n1.appendToTail(3);
		n1.appendToTail(4);
		
		n1.appendToTail(5);
		n1.next.next.next.next = n1;
		System.out.println(findStartOfLoop(n1).data);
	}
}
