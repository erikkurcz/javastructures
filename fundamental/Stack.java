package fundamental;

import java.util.NoSuchElementException;
// designing so only the head reset to a new item or be removed

public class Stack {

	private Node head;
	private int len = 0;

	public Stack (){
	}

	public static void main(String[] args){

		System.out.println("\n********** Testing Stack **********");

		Stack stk = new Stack();

		Node a = new Node("Alpha");
		Node b = new Node("Bravo");
		Node c = new Node("Charlie");

		stk.push(c);
		System.out.println(stk.toString());
		System.out.println("Len is: "+stk.getLen()); // 1

		stk.push(b);
		stk.push(a);

		System.out.println(stk.toString()); // alpha --> bravo --> charlie
		System.out.println("Len is "+stk.getLen()); // 3

		System.out.println("Peek result: "+stk.peek().getData()); // alpha

		Node nahfam = stk.pop();
		System.out.print("Popped value is equal to Alpha: "); // true
		System.out.print(nahfam == a);
		System.out.println("\n");
		System.out.println(stk.toString()); // bravo --> charlie

		System.out.println(nahfam.getNext()); // null

		System.out.println(stk.peek().getData()); // bravo
		System.out.println("Len of stack: "+stk.getLen()); // 2

		stk.pop();
		System.out.println(stk.toString()); // charlie

		stk.push(nahfam); // add back
		System.out.println(stk.toString()); // alpha --> charlie

		stk.pop(); // now just charlie
		System.out.println(stk.toString());

		Node blank = stk.pop(); // throws error
		System.out.println("Check if popped item is c:"+(blank == c)); // true
		System.out.println("Length of stack: "+stk.getLen()); // 0
		System.out.println(stk.toString()); // throws error as no items in list

		System.out.println("********** Testing over **********");
	}

	public Node pop() {

		if (isEmpty()) {
			throw new NoSuchElementException("No items to remove!");
		} 

		Node oldhead = head;
		head = head.getNext();
		oldhead.setNextNull(); // order matters here
		len--;
		return oldhead;
	}

	public void push(Node n) {

		n.setNext(head);
		head = n;
		len++;
		return;
	}

	public Node peek(){
		if (isEmpty()){
			throw new NoSuchElementException("No items in Stack!");
		}
		return head;
	}

	public int getLen() {
		return len;
	}

	public boolean isEmpty(){
		return len == 0;
	}

	public String toString(){

		if (isEmpty()) {
			throw new NoSuchElementException("No items in Stack!");
		}
		String out = "\n***HEAD***\n";

		Node iter = head;
		do {
			out += String.valueOf(iter.getData())+"\n";
			iter = iter.getNext();
		} while (iter != null);

		return out+"___________________\n";
	}

}