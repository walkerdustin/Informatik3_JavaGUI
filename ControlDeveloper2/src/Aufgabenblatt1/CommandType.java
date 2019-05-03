package Aufgabenblatt1;

public class CommandType {
	private String name;
	private int tempInt;
	private double duration;
	
	public CommandType(String name) {
		this.name = name;
	}
	public CommandType(String name, double duration) {
		this.name = name;
		this.duration = duration;
	}
	public CommandType(String name, int tempInt, double duration) {
		this.name = name;
		this.tempInt = tempInt;
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	
	public Command createInstance() {
		switch (name) {
		case "Direction":
			return (new Direction(tempInt));
		case "Gear":
			return (new Gear(tempInt,duration));
		case "Pause":
			return (new Pause(duration));

		default:
			System.err.println("Stored NameString is invalid");
			return null;
		}
	}
	
}
