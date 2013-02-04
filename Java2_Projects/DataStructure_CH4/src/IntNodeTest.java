
public class IntNodeTest {

	public static void main(String[] args) {

		IntNode head = null;
		head = new IntNode(10, head);
		head = new IntNode(20, head);
		head = new IntNode(30, head);
		IntNode temp = head;

		printLinkedList(temp);
		int count = IntNode.listLength(temp);
		System.out.println("There are " + count + " nodes in the list.");
	}

	public static void printLinkedList(IntNode temp) {
		while (temp.getLink() != null){
			System.out.println("Node: " + temp.getData());
			temp = temp.getLink();
			if (temp.getLink() == null) {
				System.out.println("Node: " + temp.getData());
			}
		}
	}
}
