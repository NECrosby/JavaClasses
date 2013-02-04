/** Generic Linked List of Items **/

public class LinkedList<T> {
	
	/** Instance Variables **/
	protected Node<T> head;
	protected int size;
	
	/** Constructor **/
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	public LinkedList(Node<T> iHead, int iSize) {
		super();
		this.head = iHead;
		this.size = iSize;
	}

	/** Getters and Setters **/
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	/** Methods **/
	public void add(T data){
		if (head == null){
			head = new Node<T>(data, null);
		} else {
			head = new Node<T>(data, head);
		}
		size++;
	}
	
	public void remove(int i){
		if (i == 1){
			head = head.getLink();
		} else {
			Node<T> node = head;
			for (int index = 2; i < index; index++){
				node = node.getLink();
			}
			node.setLink(node.getLink().getLink());
		}
		size--;	
	}
	
	public String toString(){
		return toString(head);
	}

	public String toString(Node<T> node) {
		String value = "";
		if (node == null){
			value = "There currently are not any Nodes.";
		} else {
			Node<T> n = node.getLink();
			for (int i = 0; i < this.size; i++){
				value += "Node: " + n.getData() + "/n";
			}
		}
		return value;
	}
	
}
