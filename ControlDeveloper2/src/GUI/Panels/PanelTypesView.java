package GUI.Panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.iUpdater;
import GUI.Bedienelemente.Button.ButtonAdd;
import GUI.Bedienelemente.List.ListGui;
import Model.ControlModel;

/**
 * Klasse zum Erstellen des Panels TypesView - SINGELTON
 * 
 * @author TheRealTripleM
 *
 */
public class PanelTypesView extends JPanel implements iUpdater {
	private static PanelTypesView pTV = null;
	private static ListGui TypesList = null;

	private static final String HEADLINE = "Types";
	private String[] arrCommandTypes;

	/**
	 * Konstruktor, erstellt Grunddarstellung
	 * 
	 * @param cD
	 * @param arrList - Stringarray zur Listeerstellung
	 */
	private PanelTypesView(ControlDevelepor cD, String[] arrList) {

		// Updater.add(this); // registrieren beim Observer

		System.out.println("ConstruktorPanelTypesView");
		arrCommandTypes = arrList;

		setLayout(new BorderLayout());
		add(new JLabel(HEADLINE, JLabel.CENTER), BorderLayout.NORTH);
		setSize(200, 400); // JAVA DOC sagt: This method changes layout-related information, and
							// therefore,invalidates the component hierarchy.
							// die größe dieses Component sollte vom übergeordeten Panel geregelt werden...
		System.out.println("PanelAngelegt");
		testList();

		JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ButtonPanel.add(new ButtonAdd(cD));
		add(ButtonPanel, BorderLayout.SOUTH);

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

	/**
	 * Metode um Ausgewaehltes Element aus der Liste zu bekommen
	 * 
	 * 
	 * @return
	 */
	public String getSelectedType() {

		return (String) TypesList.getSelectedValue();
	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub

	}

}
