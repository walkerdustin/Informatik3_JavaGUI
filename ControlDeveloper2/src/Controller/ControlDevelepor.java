package Controller;

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
	 * Add-Methode: Wird ausgelï¿½st von AddButton im PanelTypesView Koordiniert das
	 * Hinzufï¿½gen eines neuen (leeren) Commands
	 */
	public void addType() {
		String strCommand = vCD.getSelectedType();
		System.out.println("Folgender Command wird angelegt: " + strCommand);
		vCD.addCommand(strCommand);
		Updater.updateAll();
	}

	/**
	 * Methode um einen Command in der Tabelle zu löschen
	 */
	public void removeCommand() {
		vCD.removeCommand(vCD.getSelectedCommandRow());

	}

	/**
	 * Methode um einen Command in der Tabelle um eins nach oben zu verschieben
	 */
	public void UpCommand() {
		vCD.upCommand(vCD.getSelectedCommandRow());

	}

	/**
	 * Methode um einen Command in der Tabelle um eins anch unten zu verschieben
	 */
	public void DownCommand() {
		vCD.downCommand(vCD.getSelectedCommandRow());

	}

//	Dustin sagt das kann / muss in Control Model .... Dustin hat das jetzt einfach so gemacht.
//	public void stop() {
//		// TODO CommandsPanel StopButton FUnktion implementieren
//		System.out.println("Stop");
//
//	}
//
//	public void start() {
//		// TODO CommandsPanel StartButton FUnktion implementiren
//		System.out.println("Start");
//		vCD.testList();
//
//	}

	/**
	 * Methode die Ausgelöst wird wenn dich die selektierte Zeile ändert
	 * 
	 * @param selectedRow
	 */
	public void CommandSelectionChanged(int selectedRow) {
		String selection = vCD.getCommandTypeAt(selectedRow);
		System.out.println("CommandSelection changed to : \"" + selection + "\"");

		this.commandRowSelected = selectedRow;
		PanelAttributionsView.getInstance().updateView();

//
//		switch (selection) {
//		case "Direction":
//			vCD.openDirectionPanel();
//			break;
//		case "Gear":
//			vCD.openGearPanel();
//			break;
//		case "Pause":
//			vCD.openPausePanel();
//			break;
//
//		default:
//			System.err.println("Stored NameString is invalid");
//			break;
//		}

	}

	/**
	 * Methode die die aktuellselektierte Zeile leifert
	 * 
	 * @return
	 */
	public int getSelectedRow() {
		return commandRowSelected;
	}

////	Dustin sagt das kann / muss in Control Model .... Dustin hat das jetzt einfach so gemacht.
//	public void MenuLoadList() {
//		// TODO@Dustin Auto-generated method stub
//		
//	}
//
//	public void MenuSaveList() {
//		// TODO@Dustin Auto-generated method stub
//		
//	}

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
			// vCD.emptyList(); //Dustin sagt nööööööö :
			ControlModel.getInstance().getControlProcess().clear();
			UpdateTableView();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Methode um die TableView zu aktualisieren
	 */
	public void UpdateTableView() {
		vCD.UpdateTableView();

	}

}
