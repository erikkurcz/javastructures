package fundamental;

public class SinglyLinked {

	Node head = null;
	int len = 0;

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

		System.out.println("**********Test complete**********");

	}

	public void addNodeAtHead(Node n){

		Node temp = null;

		if (head == null) {
			head = n;
		} else {
			temp = head;
			head = n;
			head.setNext(temp);
			len++;
		}
		return;
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