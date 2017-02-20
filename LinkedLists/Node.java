package LinkedLists;

public class Node {
	int data;
	Node next = null;
	Node(int d){
		this.data = d;
	}
	
	void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		while(n.next!=null) n=n.next;
		n.next = end;
	}
	
	Node reverseList() {
		Node head = this;
		if(head == null || head.next==null) return head;
		Node n = head;
		Node previous = null;
		Node next = null;
		while(n!=null){
			next = n.next;
			n.next = previous;
			previous = n;
			n=next;
		}
		return previous;
	}
	
	public Node reverseList(Node head) {
        if(head==null || head.next==null) return head;
        
        Node fake = new Node(0);
        fake.next = head;
        
        Node previous = fake;
        Node start = head;
        Node end = start.next;
        while(end!=null){
            start.next = end.next;
            end.next = previous.next;
            previous.next = end;
            end = start.next;
        }
        return fake.next;
    }
}
