package model;

/**
* Model für die Pens der penCollection
* Einzelne Elemente entnommen aus "Musterlösung", Author: René Probst
* @version 1.0 vom 27/04/2020
* @author Clarissa Sullivan
*/
public class Pen {
	private String name;
	private	String group;
	private String code;
	
	public Pen() {
	}
	
	public Pen(String name, String group, String code){
		this.setPen(name, group, code);
	}
	
	//sets a new pen with its respective name, group and code
	public void setPen(String name, String group, String code){
		setName(name);
		setGroup(group);
		setCode(code);
	}
	
	//sets a new code with its respective number
	private void setCode(String code) {
		this.code = code;
		
	}
	
	//gets and returns the code of a pen
	public String getCode() {
		return code;	
	}

	//sets the name of a pen
	public void setName(String name) {
		this.name = name;
	}
	
	//gets and returns the name of a pen
	public String getName() {
		return name;
	}
	
	//sets the group of a pen (from a predefined list of groups)
	public void setGroup(String group) {
		this.group = group;
	}
	
	//gets and returns the corresponding group of a pen
	public String getGroup() {
		return group;
	}

	//converts to string, e.g. for output to the console
	public String toString() {
		return name + ": \t" + group;
	}
}
