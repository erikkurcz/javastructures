package fundamental;

public class SinglyLinked {

	private Node head = null;
	private int len = 0;

	public SinglyLinked() {
		
	}

	public static void main(String[] args){
		// testing here

		System.out.println("**********Testing SinglyLinked List...**********");

		System.out.println("Creating Nodes...");
		Node a = new Node("alpha");
		Node b = new Node("bravo");
		Node c = new Node("charlie");
		Node d = new Node("delta");
		System.out.println("Nodes created");

		System.out.println("Creating SingylLinked list and adding Nodes to head...");
		SinglyLinked sl = new SinglyLinked();
		sl.addNodeAtHead(a);
		sl.addNodeAtHead(b);
		sl.addNodeAtHead(c);

		sl.printList();

		System.out.println("Removing from Head of list...");
		System.out.println(sl.getHead() == c); // true
		sl.removeNodeFromHead();
		System.out.println(sl.getHead() != c); // true
		System.out.println(sl.getHead() == b); // true
		System.out.println(sl.getLen() == 2); // true
		System.out.println(c.getNext() == null); // true


		System.out.println("**********Test complete**********");

	}

	public void addNodeAtHead(Node n){

		Node temp = null;

		if (head == null) {
			head = n;
			len++;
		} else {
			temp = head;
			head = n;
			head.setNext(temp);
			len++;
		}
		return;
	}

	public Node removeNodeFromHead(){
		Node temp = null;
		temp = head;
		head = head.getNext();
		temp.setNext(null);
		len--;
		return temp;
	}

	public Node getHead(){
		return head;
	}

	public int getLen(){
		return len;
	}

	public void printList(){

		Node iter = head;

		System.out.print("HEAD ");

		do {
			System.out.print(iter.getData() + " --> ");
			iter = iter.getNext();
		} while (iter != null);

		System.out.println("TAIL");

		return;
	}

}