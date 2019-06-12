package Model;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JOptionPane;

import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.IComListener;
import hsrt.mec.controldeveloper.core.com.WiFiCard;
//import hsrt.mec.controldeveloper.io.TextFile;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.WiFi;
import zzzDatenInterface.TextFile;

/**
 * Klasse des ControlModels Enthaelt Moegliche Commands und eine Liste des
 * bestehenden Prozesses
 * 
 * Hier werden alle Funktionen und Daten des eigentlichen Programms gespeichert
 */
public class ControlModel implements IComListener {
	private static ControlModel instance;
	private CommandType[] commandTypes = new CommandType[3];
	private CommandList controlProzess;

	private WiFiCard wiFiCard = null;
	private ComHandler comHandler = ComHandler.getInstance();

	/**
	 * Konstruktor der CommandType Array mit den Moeglichen CommandTypes befuellt
	 */
	private ControlModel() {
		controlProzess = new CommandList();
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Pause");

		comHandler.register(this);
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
	 * wird durch ComHandler aufgerufen, wenn ein neuer command Performed wird
	 * 
	 * @param command
	 */
	public void commandPerformed(ICommand command) {
		System.out.print("Command performed: ");
		System.out.println(command.toString());
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
}
