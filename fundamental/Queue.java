package fundamental;

import java.util.NoSuchElementException;

public class Queue {

	private Node head;
	private Node tail;
	private int len = 0;

	// should the above be within the initializer?
	// TODO figure out how to use interfaces so i dont have to type this all out again
	public Queue (){
	}

	public static void main(String[] args){
		// testing here

		System.out.println("********** Testing Queue **********");

		Node a = new Node("alpha");
		Node b = new Node("bravo");
		Node c = new Node("charlie");

		Queue q = new Queue();

		q.push(a); // alpha
		q.push(b); // HEAD --> alpha --> bravo
		q.push(c); // HEAD --> alpha --> bravo --> charlie

		System.out.println("Len is: "+q.getLen()); // 3
		System.out.println(q.toString()); // HEAD --> alpha --> bravo --> charlie

		Node nah = q.pop(); 
		System.out.println("Len is: "+q.getLen());
		System.out.println(q.toString()); // HEAD --> bravo --> charlie

		System.out.println("Check if popped value is alpha: "+(a == nah)); // true
		System.out.println("Len is: "+q.getLen()); // 2

		Node whatsthis = q.peek();
		System.out.println("Peeked value is bravo: "+(whatsthis == b));
		System.out.println("Len is: "+q.getLen()); // still 2

		System.out.println(q.toString()); // HEAD --> bravo --> charlie
		q.pop();
		System.out.println("Ensuring bravo (just popped) has no next:"+(b.getNext() == null)); // false

		System.out.println(q.toString()); // HEAD --> charlie

		q.push(a); 
		System.out.println(q.toString()); // HEAD --> charlie --> alpha
		System.out.println("Len is: "+q.getLen());

		q.pop();
		q.pop();

		System.out.println("Is this empty? "+q.isEmpty()); // true
		System.out.println(q.toString()); // throws error as queue is empty

		System.out.println("********** Testing Complete **********");

	}

	public void push(Node n){

		if (isEmpty()){
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			tail = n;
		}

		len++;
		return;
	}

	public Node pop(){

		if (isEmpty()){
			throw new NoSuchElementException("No items in Queue!");
		}

		Node oldhead = head;
		head = head.getNext();
		oldhead.setNextNull();
		len--;
		return oldhead;
	}

	public Node peek(){

		if (isEmpty()){
			throw new NoSuchElementException("No items in Queue!");
		}

		return head;
	}

	public boolean isEmpty(){
		return getLen()==0;
	}

	public int getLen(){
		return len;
	}

	public String toString(){

		if (isEmpty()) {
			throw new NoSuchElementException("No items in Queue!");
		}

		Node iter = head;
		String out = "\n**** HEAD ****\n";

		do {
			out += String.valueOf(iter.getData())+"\n";
			iter = iter.getNext();
		} while (iter != null);

		return out + "**** TAIL ****\n__________\n";
	}
}