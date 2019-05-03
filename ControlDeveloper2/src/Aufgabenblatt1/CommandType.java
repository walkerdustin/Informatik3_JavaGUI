package Aufgabenblatt1;

public class CommandType {
	private String name;
	private int tempInt;
	private double duration;
	// -------------------Frage--------------------------------
	// Sollen wir hier evtl. folgendes Anlegen?
	// private String[] arrContent;

	public CommandType() {
	}

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

	public String getName() {
		return name;
	}

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
