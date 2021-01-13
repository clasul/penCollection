package gui;

import javax.swing.*;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import model.*;

/**
 * Erstellt das GUI für die Anzeige von allen hinzugefügten Pens. 
 * Ermöglicht dem Benutzer, nach Gruppe zu sortieren. 
 * Einzelne Elemente entnommen aus "Musterlösung", Author: René Probst
 * 
 * @version 1.0 vom 27/04/2020
 * @author Clarissa Sullivan
 */

public class DisplayGui extends JPanel {

	private DefaultComboBoxModel<String> searchModel;
	private DefaultListModel<Pen> penModel;
	private JComboBox<String> groupList;
	private JList<Pen> penList;
	private JTable table;
	private TableModel model;

	public DisplayGui(DefaultComboBoxModel<String> searchModel, DefaultListModel<Pen> penModel) {
		this.setLayout(new BorderLayout(10, 10));
		this.searchModel = searchModel;
		this.penModel = penModel;
		groupList = new JComboBox<String>(this.searchModel);
		groupList.setEditable(false);
		groupList.setPreferredSize(new Dimension(150, groupList.getPreferredSize().height));
		groupList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onThemeSelection(e);

			}
		});
		//
		penList = new JList<Pen>(this.penModel);
		penList.setCellRenderer(new MyCellRenderer());
		//
		this.add(getGroupPanel(), BorderLayout.WEST);
		this.add(getPenPanel(), BorderLayout.CENTER);
	}

	private JPanel getGroupPanel() {
		JPanel themePanel = new JPanel(new BorderLayout(5, 5));
		JPanel comboboxPanel = new JPanel(new BorderLayout(5, 5));
		comboboxPanel.add(groupList, BorderLayout.NORTH);
		themePanel.add(new JLabel("Group:"), BorderLayout.NORTH);
		themePanel.add(comboboxPanel, BorderLayout.CENTER);
		return themePanel;
	}

	private JPanel getPenPanel() {
		JPanel phrasePanel = new JPanel(new BorderLayout(5, 5));
		phrasePanel.add(new JLabel("Pens:"), BorderLayout.NORTH);
		phrasePanel.add(new JScrollPane(penList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
		return phrasePanel;
	}

	private void onThemeSelection(ActionEvent e) {
		((Collection) penModel).setSelectedGroup(groupList.getSelectedItem().toString());
	}

}

class MyCellRenderer extends JPanel implements ListCellRenderer<Object> {

	JTextField penGroup;
	JTextField penName;
	JTextField penCode;
	JScrollPane scroller;

	MyCellRenderer() {
		penGroup = new JTextField(12);
		penGroup.setEditable(false);
		penGroup.setBackground(new Color(248, 240, 176));
		penName = new JTextField(12);
		penName.setEditable(false);
		penName.setBackground(new Color(248, 240, 176));
		penCode = new JTextField(12);
		penCode.setEditable(false);
		penCode.setBackground(new Color(248, 240, 176));
		scroller = new JScrollPane(penName, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		this.setLayout(new BorderLayout());
		penGroup.setText(((Pen) value).getGroup());
		penName.setText(((Pen) value).getName());
		penCode.setText(((Pen) value).getCode());
		this.add(penGroup, BorderLayout.WEST);
		this.add(penName, BorderLayout.CENTER);
		this.add(penCode, BorderLayout.EAST);
		return this;
	}
}
