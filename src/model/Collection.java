package model;

import java.util.*;
import javax.swing.*;

/**
 * Model für die Collection von Pens
 * Einzelne Elemente entnommen aus "Musterlösung", Author: René Probst
 * 
 * @version 1.0 vom 27/04/2020
 * @author Clarissa Sullivan
 */
public class Collection extends DefaultListModel<Pen> {

	private Vector<Pen> allPens, selectedPens;
	private String selectedGroup;

	public Collection() {
		selectedPens = new Vector<Pen>();
		allPens = new Vector<Pen>();
		selectedGroup = null;
	}

	//returns the original size of the vector allPens
	public int getOriginalSize() {
		return allPens.size();
	}

	//adds a pen to both vectors allPens and selectedPens
	public void addPen(Pen pen) {
		allPens.add(pen);
		selectedPens.add(pen);
	}
	
	//returns the pen at a certain index
	public String getPen(int index) {
		return allPens.get(index).getName();
	}

	public void setSelectedGroup(String group) {
		selectedPens.clear();
		selectedGroup = group;
		System.out.println("Selected Group = " + selectedGroup);
		for (Pen pen : allPens) {
			if (pen.getGroup().compareToIgnoreCase(group) == 0)
				selectedPens.add(pen);
		}
		this.fireContentsChanged(this, 0, selectedPens.size());
	}

	//gets the size of either allPens or selectedPens
	public int getSize() {
		if (selectedGroup == null)
			return allPens.size();
		else
			return selectedPens.size();
	}

	//removes a pen from the vector
	public void removePen(int index) {
		allPens.remove(index);
	}

	//adds a pen to the corresponding vector
	public void addElement(Pen pen) {
		addPen(pen);
		this.fireIntervalAdded(this, getSize() - 1, getSize());
	}

	public Pen getElementAt(int index) {
		if (selectedGroup == null)
			return allPens.get(index);
		else
			return selectedPens.get(index);
	}

	public String toString() {
		String out = "All Pens;\n";
		for (Pen phrase : allPens) {
			out += phrase.toString() + "\n";
		}
		return out;
	}

}
