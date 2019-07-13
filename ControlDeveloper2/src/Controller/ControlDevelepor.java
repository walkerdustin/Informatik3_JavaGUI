package Controller;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.ViewControlDevelepor;
import GUI.Panels.PanelAttributionsView;
import Model.CommandType;
import Model.ControlModel;
import Model.Direction;
import Model.Gear;

/**
 * Hauptcontroller - Koordiniert hoffentlich alle Models und Views Singleton
 * 
 * @author TheRealTripleM
 *
 */
public class ControlDevelepor {

	private static ControlDevelepor INSTANCE = null;
	// Models
	private ControlModel cM;

	// Views
	private ViewControlDevelepor vCD;

	// State Variables
	private int commandRowSelected = -1;
	private Vector<Integer> commandRowsSelected = new Vector<Integer>();

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
	 * Übergeben der ViewControlDevelepor
	 * 
	 * @param vCD
	 */
	private void setControlDeveleporView(ViewControlDevelepor vCD) {
		this.vCD = vCD;
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
		cD.setControlDeveleporView(vCD);

	}

	/**
	 * Methode die Ausgelöst wird wenn dich die selektierte Zeile ändert
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
	 * Methode um die Komplette Tabelle zu löschen
	 * 
	 * @return
	 */
	public boolean EmptyList() {
		Object[] options = { "OK", "CANCEL" };
		int selection = JOptionPane.showOptionDialog(null,
				"Sie Sind im Begriff ihre komplette Liste zu Löschen... \n Ihre ganze Arbeit,... \n Das was Sie geleistet haben,... \n Es wird gelöscht,... \n Unwiederruflich zerstört,... \n Untergehen in einen unreferenzierten Datenmatsch,... \n Einsen und Nullen ohne jegliches Zugehörichkeitsgefühl...",
				"WARNING", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
		if (selection == 0) {
			ControlModel.getInstance().listManager.EmptyList();

			this.commandRowSelected = -1;
			// UpdateTableView();
			Updater.updateAll();
			return true;
		} else {
			return false;
		}
	}

}
