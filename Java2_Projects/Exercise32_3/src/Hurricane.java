// Naomi Crosby - Chapter 32 - Exercise 32.3

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hurricane extends JPanel {
	private static final long serialVersionUID = 1L;

	// Properties
	private String name = "Hurricane Big Sandy ";
	private int category = 0;
	private int[] categories = {1, 2, 3, 4, 5};
	//private String warningMessage = toString();
	private boolean isWarningNeeded;
	private ArrayList<ActionListener> actionListenerList;
	
	// Constructors
	public Hurricane() {
		
	}
	public Hurricane(String name) {
		this.name = name;
	}

	// ***** Accessors & Mutators - Setters & Getters ***** 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCategory(int category) {
		if (category > 2) {
			processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		} 
	}
	
	public int getCategory() {
		return this.category;
	}
	
	public boolean isWarningNeeded(int cat) {
		int category = cat;
		boolean isWarningNeeded = false;
		if (category > 2) {
			isWarningNeeded = true;
		}
		return isWarningNeeded;
	}
	public String setWarningMessage(String name) {
		String messageValue = "";
		boolean warningNeeded = this.isWarningNeeded;
		String hurricaneName = name;
		if (!warningNeeded){
			messageValue = "Hurricane " + hurricaneName + "is a Category: " + category;
		} else {
			messageValue = "Hurricane " + hurricaneName + "is a Category: " + category + " = WARNING!";
		}
		return messageValue;
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
