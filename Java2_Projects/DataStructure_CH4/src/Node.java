/** Generic Node Class for creating generic lists **/

public class Node<T> {
	
	/** Instance Variables **/
	private T data;
	private Node<T> link;
	
	/** Constructors **/
	public Node(){
		
	}
	
	public Node(T iData, Node<T> iLink){
		data = iData;
		link = iLink;
	}

	/** Getters and Setters **/
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLink() {
		return link;
	}

	public void setLink(Node<T> link) {
		this.link = link;
	}
}
