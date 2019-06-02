package Model;

/**
 * 
 * Klasse der CommandTypes
 *
 */
public class CommandType {
	private String name;
	private int tempInt;
	private double duration;
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

}
