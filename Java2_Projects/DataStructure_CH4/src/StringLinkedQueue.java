
public class StringLinkedQueue {

	/* Instance variables */
	private String data;
	private StringLinkedQueue link;
	private int cursor;

	public StringLinkedQueue() {

	}

	public StringLinkedQueue(String iString, StringLinkedQueue iLink) {
		data = iString;
		link = iLink;
	}

}

