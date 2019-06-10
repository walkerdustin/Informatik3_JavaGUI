package Controller;

import javax.swing.JFrame;

import GUI.ViewControlDevelepor;
import Model.CommandType;
import Model.ControlModel;
import Model.Direction;
import Model.Gear;

/**
 * Hauptcontroller - Koordiniert hoffentlich alle Models und Views
 * 
 * @author TheRealTripleM
 *
 */
public class ControlDevelepor {

	private static ControlDevelepor INSTANCE = new ControlDevelepor();
	// Models
	private ControlModel cM;

	// Views
	private ViewControlDevelepor vCD;

	// State Variables
	private int commandRowSelected = -1;

	private ControlDevelepor() {
		cM = ControlModel.getInstance();
	};

	public static ControlDevelepor getInstance() {
		return INSTANCE;
	}

	private void setControlDeveleporView(ViewControlDevelepor vCD) {
		this.vCD = vCD;
	}

	public static void main(String[] args) {

		System.out.println("Programm gestartet");

		ControlDevelepor cD = getInstance();
		ViewControlDevelepor vCD = ViewControlDevelepor.getInstance();
		cD.setControlDeveleporView(vCD);

	}

	/**
	 * Add-Methode: Wird ausgel�st von AddButton im PanelTypesView Koordiniert das
	 * Hinzuf�gen eines neuen (leeren) Commands
	 */
	public void addType() {
		String strCommand = vCD.getSelectedType();
		System.out.println("Folgender Command wird angelegt: " + strCommand);
		vCD.addCommand(strCommand);
		Updater.updateAll();
	}

	public void removeCommand() {
		vCD.removeCommand(vCD.getSelectedCommandRow());

	}

	public void UpCommand() {
		vCD.upCommand(vCD.getSelectedCommandRow());

	}

	public void DownCommand() {
		vCD.downCommand(vCD.getSelectedCommandRow());

	}

	public void stop() {
		// TODO CommandsPanel StopButton FUnktion implementieren
		System.out.println("Stop");

	}

	public void start() {
		// TODO CommandsPanel StartButton FUnktion implementiren
		System.out.println("Start");
		vCD.testList();

	}

	public void CommandSelectionChanged(int selectedRow) {
		String selection = vCD.getCommandTypeAt(selectedRow);
		System.out.println("CommandSelection changed to : \"" + selection + "\"");

		this.commandRowSelected = selectedRow;
		Updater.updateAll();

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

	public int getSelectedRow() {
		return commandRowSelected;
	}

}
