
public class TestLinkedQueue {

	public static void main(String[] args) {
		// create two empty queues, make sure they print out correctly
		Node<String> last = null;
		last = new Node<String>("naomi", last);
		last = new Node<String>("josh", last);
		
		LinkedQueue<String> q1 = new LinkedQueue<String>(last, 1);
		q1.insert(last);

		System.out.println ("1: Q1 = '" + q1.toString());
		System.out.println ("1: Q1 size= " + q1.getSize());
		
	}
}


