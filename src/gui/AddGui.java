package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

/**
 * Erstellt das GUI für das Hinzufügen von neuen Pens 
 * Einzelne Elemente entnommen aus "Musterlösung", Author: René Probst
 * 
 * @version 1.0 vom 27/04/2020
 * @author Clarissa Sullivan
 */
public class AddGui extends JPanel {

	private DefaultComboBoxModel<String> searchModel;
	private DefaultListModel<Pen>		penModel;
	private JTextField	groupInput;
	private JTextField  penInput;
	private JTextField  codeInput;
	private JButton    	penButton;
	private JButton    	groupButton;
	private JComboBox<String>  groupList;
	

	public AddGui(DefaultComboBoxModel<String> searchModel, DefaultListModel<Pen> penModel) {
		this.setLayout(new BorderLayout(10, 10));
		this.searchModel = searchModel;
		this.penModel = penModel;

		groupInput  = new JTextField(12);
		codeInput = new JTextField(12);
		penInput  = new JTextField(12);
		penButton = new JButton("Hinzufügen...");
		penButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onPenAdded(e);
			};
		});
	
		groupList = new JComboBox<String>(this.searchModel);
		groupList.setEditable(false);
		groupList.setPreferredSize(new Dimension(150, groupList.getPreferredSize().height));
		this.add(getPenPanel(), BorderLayout.CENTER);
	}
	
	
	private JPanel getPenPanel() {
		
/**
 * Panel V1
 * 		JPanel penPanel = new JPanel(new BorderLayout(5,5));
		JPanel northPanel  = new JPanel(new BorderLayout(5,5));
		JPanel inputPanel  = new JPanel(new BorderLayout(5,5));
		JPanel btnPanel    = new JPanel(new BorderLayout(5,5));
		
		btnPanel.add(penButton,BorderLayout.EAST);
		btnPanel.add(groupList, BorderLayout.NORTH);
		
		northPanel.add(penInput, BorderLayout.WEST);
		northPanel.add(btnPanel, BorderLayout.CENTER);
		northPanel.add(codeInput, BorderLayout.EAST);
		
		inputPanel.add(northPanel, BorderLayout.NORTH);
		penPanel.add(new JLabel("Name, Group, Code:"), BorderLayout.NORTH);
		penPanel.add(inputPanel, BorderLayout.CENTER);
		
**/
		
		//creates the panels for the GUI
		JPanel penPanel = new JPanel(new BorderLayout(5,5));
		JPanel compPanel  = new JPanel(new BorderLayout(5,5));
		JPanel btnPanel    = new JPanel(new BorderLayout(5,5));
		JPanel topPanel    = new JPanel(new BorderLayout(5,5));
		
		compPanel.add(penInput, BorderLayout.WEST);
		compPanel.add(groupList, BorderLayout.CENTER);
		compPanel.add(codeInput, BorderLayout.EAST);
		
		topPanel.add(new JLabel("Name"), BorderLayout.WEST);
		topPanel.add(new JLabel("Code"), BorderLayout.EAST);
		
		btnPanel.add(penButton, BorderLayout.CENTER);
		
		penPanel.add(topPanel, BorderLayout.NORTH);
		penPanel.add(compPanel, BorderLayout.CENTER);
		penPanel.add(btnPanel, BorderLayout.SOUTH);
		
		
		return penPanel;
	}
	
	private void onPenAdded(ActionEvent e) {
		Pen newPen = new Pen (penInput.getText(), groupList.getSelectedItem().toString(), codeInput.getText());
		penModel.addElement(newPen);
		codeInput.setText("");
		penInput.setText("");
	}

}