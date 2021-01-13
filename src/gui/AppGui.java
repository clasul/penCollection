package gui;

import javax.swing.*;

import model.*;

import java.awt.*;

/**
* Initialisiert das gesamte GUI
* Einzelne Elemente entnommen aus "Musterlösung", Author: René Probst
* @version 1.0 vom 27/04/2020
* @author Clarissa Sullivan
*/

public class AppGui extends JFrame {
	
	//
	private DefaultComboBoxModel<String> searchModel;
	private DefaultListModel<Pen> penModel;
	//
	private JTabbedPane tabbedPane;
	private DisplayGui	displayPane;
	private AddGui    addPane;
	
	public AppGui(DefaultComboBoxModel<String> searchModel, DefaultListModel<Pen> penModel) {
		super("Pen Collection");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.penModel  = penModel;
		this.searchModel  = searchModel;
		
		tabbedPane = new JTabbedPane();
		initDisplay(this.searchModel);
		initAdd();
		this.add(tabbedPane, BorderLayout.CENTER);
		pack();
		
		this.setVisible(true);
	}
	
	private void initAdd() {
		addPane = new AddGui(searchModel, penModel);
		tabbedPane.add("Hinzufügen...", addPane);
	}
	
	private void initDisplay(DefaultComboBoxModel<String> searchModel) {
		displayPane = new DisplayGui(searchModel, penModel);
		tabbedPane.add("Alle", displayPane);
	}
	

}
