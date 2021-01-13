package app;
import model.*;

/**
* Initialisiert die erwünschten vorhandenen Pens und 
* Einzelne Elemente entnommen aus "Musterlösung", Author: René Probst
* @version 1.0 vom 27/04/2020
* @author Clarissa Sullivan
*/

public class Initialize {

	private Groups groups;
	private Collection collection;
	private Codes codes;

	public Initialize(Collection collection, Groups groups, Codes codes) {
		this.collection = collection;
		this.groups = groups;
		this.codes = codes;

		//Die anbei definierten Gruppen passen sich dem Real-Life Modell der Pens an, und verändert sich daher nicht.
		groups.addGroup("E");
		groups.addGroup("BG");
		groups.addGroup("B");
		groups.addGroup("BV");
		groups.addGroup("V");
		groups.addGroup("RV");
		groups.addGroup("R");
		groups.addGroup("YR");
		groups.addGroup("Y");
		groups.addGroup("YG");
		groups.addGroup("G");
		groups.addGroup("F");
		groups.addGroup("W");
		groups.addGroup("C");
		groups.addGroup("N");
		groups.addGroup("T");

		//Pens für die Collection definieren, welche angezeigt werden.
		collection.addPen(new Pen("Name", "Group", "Code"));
		collection.addPen(new Pen("Cool Gray No.3", "C", "C3"));
		collection.addPen(new Pen("Deep Magenta", "RV", "RV17"));
		collection.addPen(new Pen("Copper", "E", "E18"));
		collection.addPen(new Pen("Mint Green", "BG", "BG13"));
		collection.addPen(new Pen("Blue Berry", "BV", "BV04"));
		collection.addPen(new Pen("Salmon Red", "R", "R05"));
		collection.addPen(new Pen("Yellowish Green", "YG", "YG06"));
		collection.addPen(new Pen("Lemon Yellow", "Y", "Y13"));
	}

	public static void main(String[] args) {
		Groups g = new Groups();
		Collection col = new Collection();
		Codes cod = new Codes();
		Initialize i = new Initialize(col, g, cod);
		System.out.println(cod);
	}
}
