package fundamental;

// TODO docs...yeesh

public class Node {

	private Node next = null;
	private Node prev = null;
	private Object data = null;

	public Node(Object givendata){
		data = givendata;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object newdata) {
		data = newdata;
		return;
	}

	public Node getNext(){
		return next;
	}

	public void setNext(Node n){
		next = n;
	}

	public void setNextNull(){
		next = null;
	}

	public Node getPrev(){
		return prev;
	}

	public void setPrev(Node n){
		prev = n;
	}

	public void setPrevNull(){
		prev = null;
	}

	public static void printNode(Node n){
		System.out.println("Node data: "+n.getData()+
			"\nNode next: "+n.getNext()+
			"\nNode prev: "+n.getPrev()+
			"\nMemory Location: "+n);
	}

}