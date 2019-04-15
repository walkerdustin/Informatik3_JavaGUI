package Aufgabenblatt1;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class ControlModel {

	private static ControlModel instance = null;
	private CommandType[] commandTypes;
	private CommandList controlProcess;

	private ControlModel() {
		createCommandTypes();
	}

	public static ControlModel getInstance() {
		if (instance == null) {
			instance = new ControlModel();
		}
		return instance:
	}
	
	public void createCommandTypes() {
		if (commandTypes == null) {
		commandTypes = new CommandType[3];
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Pause");
		}
		
	}
	
	public boolean load(File f) {
		
	}
	
	public boolean save(File f) {
		
	}
	
	public void commandPerformed(ICommand c) {
		
	}
	
	public CommandList getControlProcess() {
		return controlProcess;
	}
	
}
