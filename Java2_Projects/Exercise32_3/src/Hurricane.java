// Naomi Crosby - Chapter 32 - Exercise 32.3

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Hurricane extends JPanel {
	private static final long serialVersionUID = 1L;

	// Properties
	private String name = "Big Sandy ";
	private int category = 0;
	private boolean isWarningNeeded = false;
	private int[] acceptableCategories = {1, 2, 3, 4, 5};
	private ArrayList<ActionListener> actionListenerList;

	// Constructors
	public Hurricane() {

	}
	public Hurricane(int cat) {
		this.category = cat;
	}

	// ***** Accessors & Mutators - Setters & Getters ***** 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(int category) {
		this.category = category; 
		if (category > 2) {
			processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		} 
	}
	public int getCategory() {
		return this.category;
	}
	public String setWarningMessage() {   
		String messageValue = "";
		int category = this.getCategory();
		String hurricaneName = name;
		if (this.category < 3){
			messageValue = "Hurricane " + hurricaneName + "is a Category: " + category;
		} else {
			messageValue = "WARNING! \tHurricane " + hurricaneName + "is a Category: " + category;
		}
		return messageValue;
	}
	public boolean isWarningNeeded() {
		this.isWarningNeeded = false;
		if (category > 2) {
			isWarningNeeded = true;
		}
		return isWarningNeeded;
	}	
	public synchronized void addActionListener(ActionListener listener) {
		if (actionListenerList == null){
			actionListenerList = new ArrayList<ActionListener>(2);
		}

		if (!actionListenerList.contains(listener)) {
			actionListenerList.add(listener);
		}
	}
	public synchronized void removeActionListener(ActionListener listener) {
		if (actionListenerList != null && actionListenerList.contains(listener)) {
			actionListenerList.remove(listener);
		}
	}
	private void processEvent(ActionEvent e) {
		ArrayList list;

		synchronized (this) {
			if (actionListenerList == null) return;
			list = (ArrayList)actionListenerList.clone();
		}

		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = (ActionListener)list.get(i);
			listener.actionPerformed(e);
		}
	}
}
