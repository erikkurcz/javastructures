package fundamental;

// TODO: docs, addNodeAtIndex, removeNodeAtIndex

public class SinglyLinked {

	public Node head = null;
	public int len = 0;

	public SinglyLinked() {
	}

	public static void main(String[] args){
		// testing here

		System.out.println("**********Testing SinglyLinked List...**********\n");

		TestAddRemoveAtHead();
		TestAddRemoveAtTail();

	}

	public void addNodeAtHead(Node n){

		Node temp = null;

		if (head == null) {
			head = n;
			len++;
		} else {
			n.setNext(head);
			head = n;
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

	public void addNodeAtTail(Node n){

		Node iter = head;
		for (int i=1;i<len;i++) { // iterate to end of list ( less than len because of .getNext())
			iter = iter.getNext();
		}

		iter.setNext(n); 
		len++; 
		return;
	}

	public Node removeNodeFromTail(){

		Node iter = head;
		Node oldTail = null;

		for (int i=1;i<len-1;i++){ // stops 1 short of end
			iter = iter.getNext();
		}

		oldTail = iter.getNext();
		iter.setNextNull();
		len--;

		return oldTail;
	}

	public Node getHead(){
		return head;
	}

	public int getLen(){
		return len;
	}

	public void printList(){

		Node iter = head;

		System.out.print("HEAD --> ");

		do {
			System.out.print(iter.getData()+" --> ");
			iter = iter.getNext();
		} while (iter != null);

		System.out.println("TAIL\tLength of: "+len);

		return;
	}

	public static void TestAddRemoveAtTail(){

		System.out.println("Testing Adding and Removing Nodes from Tail\nCreating Nodes...");
		Node a = new Node("alpha");
		Node b = new Node("bravo");
		Node c = new Node("charlie");
		Node d = new Node("delta");

		SinglyLinked sl = new SinglyLinked();

		sl.addNodeAtHead(a);
		sl.addNodeAtHead(b);
		sl.addNodeAtHead(c);
		sl.printList(); // charlie --> bravo --> alpha			
		
		sl.removeNodeFromTail(); 
		sl.printList(); // charlie --> bravo

		sl.removeNodeFromTail(); 
		sl.printList(); // charlie 

		sl.addNodeAtTail(d); // charlie --> delta
		sl.printList();

		sl.addNodeAtTail(a);
		sl.printList(); // charlie --> delta --> alpha

		System.out.println("**********Testing complete.**********\n");
	}

	public static void TestAddRemoveAtHead(){

		System.out.println("Testing Adding and Removing Nodes from Head\nCreating Nodes...");
		Node a = new Node("alpha");
		Node b = new Node("bravo");
		Node c = new Node("charlie");
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

		sl.printList();

		a = null;
		b = null;
		c = null;

		System.out.println("**********Test Complete.**********");

		return;

	}


}