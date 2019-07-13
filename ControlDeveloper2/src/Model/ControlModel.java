package Model;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Controller.Updater;
import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.WiFiCard;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

import java.io.File;
import hsrt.mec.controldeveloper.io.WiFi;
import zzzDatenInterface.TextFile;

/**
 * Klasse des ControlModels Enthaelt Moegliche Commands und eine Liste des
 * bestehenden Prozesses
 * 
 * Hier werden alle Funktionen und Daten des eigentlichen Programms gespeichert
 */
public class ControlModel {
	private static ControlModel instance;
	private CommandType[] commandTypes = new CommandType[3];
	private CommandList controlProzess;

	private WiFiCard wiFiCard = null;
	private ComHandler comHandler = ComHandler.getInstance();

	public CommandsTableModel myCommandsTableModel;
	public ListManager listManager;

	/**
	 * Konstruktor der CommandType Array mit den Moeglichen CommandTypes befuellt
	 */
	private ControlModel() {
		controlProzess = new CommandList();
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Pause");

		myCommandsTableModel = new CommandsTableModel();
		listManager = new ListManager();

		// Befüllen der Liste mit Test Commands
		controlProzess.add(new Direction(30));
		controlProzess.add(new Gear(5, 5.0));
		controlProzess.add(new Direction(30));
		controlProzess.add(new Gear(5, 5.0));
		controlProzess.add(new Direction(30));
		controlProzess.add(new Gear(5, 5.0));
	}

	/**
	 * Methode die die Instance des ControlModels liefert singleton
	 * 
	 * @return Instanz des ControlModels
	 */
	public static ControlModel getInstance() {
		if (ControlModel.instance == null) {
			ControlModel.instance = new ControlModel();
		}
		return ControlModel.instance;

	}

	/**
	 * Funktion, die commandTypes mit den Command Types befuellen sollte. Dies ist
	 * aber doof da es schon in dem Constructor gemacht wurde koennte / wird zu
	 * fehlern fuehren wenn es dem Programmierer ueberlassen wird sich um die
	 * befuellung des Arrays zu kuemmern!
	 */
	public void createCommandTypes() {
		// desshalb:
		System.out.println("Well..... this is stupid, isnt it?");
	}

	/**
	 * laedt commands Zeilenweise aus file commands werden ueberschrieben
	 * 
	 * @param file Das file aus dem controlProzess erstellt werden soll
	 * @return Ob das laden der Liste erfolgreich war
	 */
	public boolean load(File file) {
		boolean erfolgreich = false;
		TextFile commandsFile = new TextFile(file, true);
		Vector<String> geleseneCommandStrings = new Vector<String>();
		erfolgreich = commandsFile.read(geleseneCommandStrings);
		controlProzess.VectorToList(geleseneCommandStrings);

		return erfolgreich;
	}

	/**
	 * Speichert die CommandList controlProzess als file ab. file wird
	 * ueberschrieben
	 * 
	 * @param file
	 * @return Ob das speichern der Liste erfolgreich war.
	 */
	public boolean save(File file) {
		TextFile textFile = new TextFile(file, false);

		Vector<String> geleseneCommandStrings = new Vector<String>(); // for Testing

		System.out.println();// for Testing
		System.out.println("CommandList controlProcess: "); // for Testing
		System.out.println(controlProzess.ListToVector());// for Testing

		boolean erfolgreich = textFile.write(controlProzess.ListToVector());
		textFile.close();

		System.out.println();// for Testing
		System.out.println("In file steht jetzt:"); // for Testing

		geleseneCommandStrings.clear(); // for Testing
		textFile.read(geleseneCommandStrings); // for Testing

		textFile.close();

		System.out.println(geleseneCommandStrings);// for Testing

		return erfolgreich;
	}

	/**
	 * Getter fuer die CommandList controlProzess
	 * 
	 * @return
	 */
	public CommandList getControlProcess() {
		return controlProzess;
	}

	/**
	 * Methode die Alle CommandTypes als Vector liefert
	 * 
	 * @return
	 */
	public Vector<String> getCommandTypes() {
		Vector<String> temp = new Vector<String>();
		for (int i = 0; i < commandTypes.length; i++) {
			temp.add(commandTypes[i].getName());
		}
		return temp;
	}

	/*
	 * Setter für die aktuell selectierte WiFiCard
	 */
	public void setWiFiCard(WiFiCard wiFiCard) {
		this.wiFiCard = wiFiCard;
	}

	/*
	 * ruft die comHandler.start() auf mit der intern gespeicherten CommandList und
	 * der intern gespeicherten WiFiCard
	 * 
	 * @return ob das starten erfolgreich war
	 */
	public boolean start() {
		if (wiFiCard == null) {
			System.out.println("Keine WifiKarte ist selektiert");
			Object[] options = { "sorry", "Tut mir Leid", "War keine Absicht" };
			JOptionPane.showOptionDialog(null, "Sie haben keine WifiKarte ausgewählt ", "Kein WiFi ausgewählt",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			return false;
		}
		return comHandler.start(controlProzess.listToICommandsVector(), new WiFi(wiFiCard));
	}

	/*
	 * ruft comHandler.stop() auf
	 * 
	 * @return ob das stoppen erfolgreich war
	 */
	public boolean stop() {
		return comHandler.stop();
	}

	public class CommandsTableModel extends AbstractTableModel {
		private final String[] arrCOLUMNNAMES = { "Nr.", "Command", "Configuration" };

		private CommandsTableModel() {
		}

		@Override
		public int getColumnCount() {

			return 3;
		}

		@Override
		public int getRowCount() {
			return controlProzess.getSize();
		}

		@Override
		public Object getValueAt(int row, int col) {
			Object o = "";

			String[] comContent = CommandType.showInstance(controlProzess.get(row));
			switch (col) {
			case 0:
				o = "" + (row + 1);
				break;
			case 1:
				o = comContent[0];
				break;
			case 2:
				o = comContent[1];
				break;
			default:
				System.err.println("ERROR - INVALID ICOMMAND");
				break;
			}
			return o;
		}

		/**
		 * Methode die dei Spaltenueberschirften festlegt
		 */
		@Override
		public String getColumnName(int column) {
			return arrCOLUMNNAMES[column];
		}
	}

	public class ListManager {
		private ListManager() {

		}

		public void removeCommand(int row) {
			controlProzess.printList();
			System.out.println("DesiredPosition" + row);
			System.out.println("List:" + controlProzess.getSize());
			System.out.println("DesiredPosition" + row);

			controlProzess.remove(row);
			Updater.updateAll();

		}

		/**
		 * Methode um einen Command in der Tabelle um eins nach oben zu verschieben
		 */
		public void UpCommand(int row) {
			controlProzess.moveUp(row);
			Updater.updateAll();
		}

		/**
		 * Methode um einen Command in der Tabelle um eins anch unten zu verschieben
		 */
		public void DownCommand(int row) {
			controlProzess.moveDown(row);
			Updater.updateAll();
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
				controlProzess.clear();
//				this.commandRowSelected = -1;
//				UpdateTableView();
				Updater.updateAll();
				return true;
			} else {
				return false;
			}
		}

		/**
		 * Hinzufï¿½gen eines neuen (leeren) Commands
		 */
		public void addCommand(ICommand command, int row) {
			controlProzess.add(command, row);
			Updater.updateAll();
		}

		/**
		 * Hinzufï¿½gen eines neuen (leeren) Commands
		 */
		public void addCommand(ICommand command) {
			controlProzess.add(command);
			Updater.updateAll();
		}

		public ICommand get(int row) {
			return controlProzess.get(row);
		}

		public int getSize() {
			return controlProzess.getSize();
		}

		public String getCommandTypeAt(int row) {
			String commandName = controlProzess.get(row).getName();
			String[] tempStringArray = commandName.split("#x#");
			return tempStringArray[0];
		}
	}
}
