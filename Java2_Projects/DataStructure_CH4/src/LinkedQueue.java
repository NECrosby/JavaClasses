// Naomi Crosby

public class LinkedQueue<T> extends Node<T> implements Comparable {

	/** Instance variables **/
	protected Node<T> last, first;
	protected int size = 0;

	/** Constructor **/
	public LinkedQueue() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	public LinkedQueue(Node<T> iLast, int iSize) {
		super();
		this.last = iLast;
		this.size = iSize;
	}

	/** Getters and Setters **/
	public Node<T> getFirst() {
		return last;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}

	public Node<T> getLast() {
		return last;
	}

	public void setLast(Node<T> last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/** Methods **/
	public void makeEmpty(){
		last = null;
		first = null;
		size = 0;
	}

	public void insert(T node) {
		Node<T> n = new Node<T>(node, null);
		if (last != null) { 
			last.setLink(n); 
		} else { 
			last = n;
			if (first == null){
				first = last;
			}
		}
		size++;
	}

	public Node<T> deleteMin(){
		Node<T> value = first;
		if (first != null) { 
			first = first.getLink();
		} 
		// special case: queue empty
		if (first == null) {
			last = null;
		}
		return value;
	}

	public Node<T> deleteMax(){
		Node<T> value = last;
		if (last != null) { 
			last = last.getLink();
		} 
		// special case: queue empty
		if (last == null) {
			first = null;
		}
		return value;
	}

	public Node<T> findMin(){
		Node<T> tempMin = first;
		/*for(int i = 0; i < size; i++){
			if(first.value > next.value) {
				tempMin = next;
			}
		}*/
		return tempMin;
	}

	public Node<T> findMax(){
		Node<T> tempMax = first;
		/*for(int i = 0; i < size; i++){
			if(first.value < next.value) {
				tempMax = next;
			}
		}*/
		return tempMax;
	}

	public boolean isEmpty(){
		return (first == null) && (last == null);
	}

	public String toString () {
		return last == null ? "empty" 
				: toString (last.getLink() /* first node */, size);
	}

	private String toString (Node<T> node, int count) {
		return count == 0 ? "" : node.getData() + " : " + toString (node.getLink(), count - 1);
	}

	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

