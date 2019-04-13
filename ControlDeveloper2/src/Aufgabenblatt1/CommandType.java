package Aufgabenblatt1;

public class CommandType {
	private String name;
	
	public CommandType(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public Command createInstance() {
		switch (name) {
		case "Direction":
			return (new Direction());
		case "Gear":
			return (new Gear());
		case "Pause":
			return (new Pause());

		default:
			System.err.println("Stored NameString is invalid");
			return null;
		
		}
	}
}
