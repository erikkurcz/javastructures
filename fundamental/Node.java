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
		return String.valueOf(data);
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

	public Node getPrev(){
		return prev;
	}

	public void setPrev(Node n){
		prev = n;
	}

}