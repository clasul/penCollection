package app;

import model.*;
import gui.*;

/**
* Initialisiert die Applikation
* Einzelne Elemente entnommen aus "Musterlösung", Author: René Probst
* @version 1.0 vom 27/04/2020
* @author Clarissa Sullivan
*/

public class PenCollection {

	
	public static void main(String[] args) {
		Groups g     = new Groups();
		Collection col = new Collection();
		Codes cod = new Codes();
		//
		new Initialize(col, g, cod);
		System.out.println(g.toString());
		System.out.println(col.toString());
		System.out.println(cod.toString());
		//
		AppGui gui = new AppGui(g, col);
	}
}
