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
import Controller.Updater;
import Model.ControlModel;

/**
 * Klasse zum Erstellen des Panels TypesView - SINGELTON
 * 
 * @author TheRealTripleM
 *
 */
public class PanelTypesView extends JPanel {
	private ControlDevelepor cD;
	private static PanelTypesView pTV = null;
	private static ListGui TypesList = null;

	private static final String HEADLINE = "Types";
	private String[] arrCommandTypes;
	private ButtonAdd bAdd;

	/**
	 * Konstruktor, erstellt Grunddarstellung
	 * 
	 * @param cD
	 * @param arrList - Stringarray zur Listeerstellung
	 */
	private PanelTypesView(ControlDevelepor cD, String[] arrList) {

		// Updater.add(this); // registrieren beim Observer

		System.out.println("ConstruktorPanel");
		this.cD = cD;
		arrCommandTypes = arrList;

		setLayout(new BorderLayout());
		add(new JLabel(HEADLINE, JLabel.CENTER), BorderLayout.NORTH);
		setSize(200, 400);

		System.out.println("PanelAngelegt");
		testList();

		bAdd = new ButtonAdd(cD);
		add(bAdd, BorderLayout.SOUTH);

	}

	/**
	 * Methode die das Panel TypesView liefert
	 * 
	 * @param cD
	 * @param arrList
	 * @return instance of PanelTypesView
	 */
	static public PanelTypesView getTypesView(ControlDevelepor cD, String[] arrList) {
		if (pTV == null) {
			pTV = new PanelTypesView(cD, arrList);
		}

		System.out.println("Panel uebergeben");
		return pTV;

	}

	/**
	 * Testfunktion
	 */
	void testList() {

		TypesList = new ListGui(arrCommandTypes);
		add(new JScrollPane(TypesList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);

	}

	@Override
//	public void updateView() {
//		// TODO Auto-generated method stub
//		TypesList.add("TestString");
//
//	}

	/**
	 * Metode um Ausgewaehltes Element aus der Liste zu bekommen
	 * 
	 * 
	 * @return
	 */
	public String getSelectedType() {

		return (String) TypesList.getSelectedValue();
	}

}
