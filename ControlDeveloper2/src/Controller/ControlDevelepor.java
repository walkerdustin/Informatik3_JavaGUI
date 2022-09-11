package Controller;

import javax.swing.JOptionPane;

import GUI.ViewControlDevelepor;
import GUI.Panels.PanelAttributionsView;
import Model.ControlModel;

/**
 * Hauptcontroller - Koordiniert hoffentlich alle Models und Views Singleton
 * 
 * @author TheRealTripleM
 *
 */
public class ControlDevelepor {

	private static ControlDevelepor INSTANCE = null;

	// State Variables
	private int commandRowSelected = -1;
	// private Vector<Integer> commandRowsSelected = new Vector<Integer>();

	private ControlDevelepor() {
		// cM = ControlModel.getInstance();
	};

	/**
	 * Methode die die Instance des ControlDeleper liefert.
	 * 
	 * @return
	 */
	public static ControlDevelepor getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ControlDevelepor();
		}
		return INSTANCE;
	}

	/**
	 * Main_methode dient zum Aufrufen
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Programm gestartet");

		ControlDevelepor cD = getInstance();
		ViewControlDevelepor vCD = ViewControlDevelepor.getInstance();
	}

	/**
	 * Methode die Ausgel�st wird wenn dich die selektierte Zeile �ndert
	 * 
	 * @param selectedRow
	 */
	public void CommandSelectionChanged(int selectedRow) {
		String selection = ControlModel.getInstance().listManager.getCommandTypeAt(selectedRow);
		System.out.println("CommandSelection changed to : \"" + selection + "\"");

		this.commandRowSelected = selectedRow;
		PanelAttributionsView.getInstance().updateView();

	}

	/**
	 * Methode die die aktuellselektierte Zeile leifert
	 * 
	 * @return
	 */
	public int getSelectedRow() {
		return commandRowSelected;
	}

	/**
	 * Methode um die Komplette Tabelle zu l�schen
	 * 
	 * @return
	 */
	public boolean EmptyList() {
		Object[] options = { "OK", "CANCEL" };
		int selection = JOptionPane.showOptionDialog(null,
				"Sie Sind im Begriff ihre komplette Liste zu L�schen... \n Ihre ganze Arbeit,... \n Das was Sie geleistet haben,... \n Es wird gel�scht,... \n Unwiederruflich zerst�rt,... \n Untergehen in einen unreferenzierten Datenmatsch,... \n Einsen und Nullen ohne jegliches Zugeh�richkeitsgef�hl...",
				"WARNING", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
		if (selection == 0) {
			this.commandRowSelected = -1;
			ControlModel.getInstance().listManager.EmptyList();

			// UpdateTableView();
			return true;
		} else {
			return false;
		}
	}

}
