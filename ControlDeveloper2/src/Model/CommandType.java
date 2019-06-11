package Model;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * 
 * Klasse der CommandTypes
 *
 */
public class CommandType {
	private String name;
	private int tempInt = 0;
	private double duration = 0;
	// -------------------Frage--------------------------------
	// Sollen wir hier evtl. folgendes Anlegen?
	// private String[] arrContent;

	/**
	 * Erstellen eines neuen leeren CommandTypes
	 */
	public CommandType() {
	}

	/**
	 * Erstellen eines neuen bestimmten CommandTypes
	 * 
	 * @param Name/Art des Commands
	 */
	public CommandType(String name) {
		this.name = name;
	}

//	public CommandType(String name, double duration) {
//		this.name = name;
//		this.duration = duration;
//	}
//	public CommandType(String name, int tempInt) {
//		this.name = name;
//		this.tempInt = tempInt;
//	}
//	public CommandType(String name, int tempInt, double duration) {
//		this.name = name;
//		this.tempInt = tempInt;
//		this.duration = duration;
//	}

	/**
	 * Methode die den Namen des CommandTypes, somit die Art des CommandTypes
	 * liefert
	 * 
	 * @return Name des Commandtypes
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metode zum Erzeugene eines Leeren Commands einer Bestimmten Art. Es werden
	 * die jeweiligen DefaultWerte initialisiert
	 * 
	 * @return Erstellter Command
	 */
	public Command createInstance() {
		System.out.println("CommandType.createInstance() sagt: name == " + name);
		switch (name) {
		case "Direction":
			return (new Direction(tempInt));
		case "Gear":
			return (new Gear(tempInt, duration));
		case "Pause":
			return (new Pause(duration));

		default:
			System.err.println("Stored NameString is invalid");
			return null;
		}
	}

	/**
	 * Methode zum Erzeugen eines neuen Commands basierend auf den Werten au einem
	 * StringArray
	 * 
	 * @param arrStrings zur Initialisierung benötigte Daten (z.B.: Duration)
	 * @return Erstellter Command
	 */
	public Command createInstance(String[] arrStrings) {
		switch (arrStrings[0]) {
		case "Direction":
			return (new Direction(Integer.valueOf(arrStrings[1])));
		case "Gear":
			return (new Gear(Integer.valueOf(arrStrings[1]), Double.valueOf(arrStrings[2])));
		case "Pause":
			return (new Pause(Double.valueOf(arrStrings[1])));

		default:
			System.err.println("Stored NameString is invalid");
			return null;
		}
	}

	/**
	 * Statisch Methode die den ICommand in einen StringArray auflöst mit folgenden
	 * Werten return[0] - CommandType return[1] - Configfuration in PrintFOrmat
	 * 
	 * @param com
	 * @return comArray
	 */
	public static String[] showInstance(ICommand com) {
		String[] tempArray = com.toString().split("#x#");
		String[] comArray = new String[2];
		comArray[0] = tempArray[0];
		StringBuilder sB = new StringBuilder();

		switch (tempArray[0]) {
		case "Direction":
			sB.append(tempArray[1]);
			sB.append(" Degree");
			break;
		case "Gear":
			sB.append(tempArray[1]);
			sB.append(" cm/sec     -     ");
			sB.append(tempArray[2]);
			sB.append(" sec");
			break;
		case "Pause":
			sB.append(tempArray[1]);
			sB.append(" sec");
			break;

		default:
			System.err.println("Stored NameString is invalid");
			sB.append("ERROR");
			break;
		}

		comArray[1] = sB.toString();

		return comArray;
	}

}
