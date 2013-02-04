
public class IntNode {
	
	/* Instance variables */
	private int data;
	private IntNode link;
	
	/* Constructors */
	public IntNode() {
		
	}
	public IntNode(int initialData, IntNode initialLink) {
		data = initialData;
		link = initialLink;
	}
	
	/* Getters and Setters */
	public int getData() {
		return data;
	}
	public void setData(int newData) {
		data = newData;
	}
	public IntNode getLink() {
		return link;
	}
	public void setLink(IntNode newLink) {
		link = newLink;
	}
	
	/* Accessors and Mutators */
	public void addNodeAfter(int element) {
		link = new IntNode(element, link);
	}
	public void removeNodeAfter() {
		link = link.link;		
	}
	public static int listLength(IntNode head) {
		IntNode cursor;
		int answer = 0;
		for (cursor = head; cursor != null; cursor = cursor.link) {
			answer++;
		}
		return answer;
	}
	public static void removeNode(IntNode head) {
		head = head.getLink();
	}
}

