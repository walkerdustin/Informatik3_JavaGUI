package GUI;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Controller.ControlDevelepor;
import Model.ControlModel;

public class PanelTypesView extends JPanel implements iGui { // by Dustin ... PTV muss iGui eigentlich nicht
																// implementieren, da der Content statisch ist?!
	private ControlDevelepor cD;
	private static PanelTypesView pTV = null;
	private static GUIList TypesList = null;

	private static final String HEADLINE = "Types";
	private String[] arrCommandTypes;
	private AddButton bAdd;

	private PanelTypesView(ControlDevelepor cD, String[] arrList) {

		System.out.println("ConstruktorPanel");
		this.cD = cD;
		arrCommandTypes = arrList;

		setLayout(new BorderLayout());
		add(new JLabel(HEADLINE, JLabel.CENTER), BorderLayout.NORTH);
		setSize(200, 400);

		System.out.println("PanelAngelegt");
		testList();

		bAdd = new AddButton(cD);
		add(bAdd, BorderLayout.SOUTH);

	}

	static public PanelTypesView getTypesView(ControlDevelepor cD, String[] arrList) {
		if (pTV == null) {
			pTV = new PanelTypesView(cD, arrList);
		}

		System.out.println("Panel übergeben");
		return pTV;

	}

	void testList() {

		TypesList = new GUIList(arrCommandTypes);
		add(new JScrollPane(TypesList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		// TypesList.addElement("Ameisenbär");

	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		TypesList.add("TestString");

	}

	public String getSelectedType() {

		return (String) TypesList.getSelectedValue();
	}

}
