package model;

import java.util.*;
import javax.swing.*;

/**
 * Model für die Groups der Pens
 * Einzelne Elemente entnommen aus "Musterlösung", Author: René Probst
 * 
 * @version 1.0 vom 27/04/2020
 * @author Clarissa Sullivan
 */
public class Groups extends DefaultComboBoxModel<String> {
	private Vector<String> groups;

	public Groups() {
		groups = new Vector<String>();
	}

	//adds a new group to the vector 
	public void addGroup(String group) {
		groups.add(group);
		Collections.sort(groups, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	//removes a group from the vector
	public void removeGroup(int index) {
		groups.remove(index);
	}

	//fetches the element at a certain index
	public String getElementAt(int index) {
		return groups.get(index);
	}

	//returns the size of the vector groups
	public int getSize() {
		return groups.size();
	}

	//signals to the GUI that a new group has been added
	public void addElement(String group) {
		addGroup(group);
		this.fireIntervalAdded(this, 0, getSize());
	}
	
	public String toString() {
		String out = "Grouplist: ";
		for (String group : groups) {
			out += group + ", ";
		}
		return out;
	}
}
