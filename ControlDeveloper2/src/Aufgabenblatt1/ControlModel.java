package Aufgabenblatt1;

import java.io.File;

import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.IOType;

public class ControlModel {
	private ControlModel instance = new ControlModel();
	private CommandType[] commandTypes = {new CommandType("Direction"), new CommandType("Gear"), new CommandType("Pause"), new CommandType("Command")};  //könnte auch in 
	private CommandList controlProzess;
	
	private ControlModel() {
		
	}
	
	public ControlModel getInstance() {
		return instance;
	}
	
	public void createCommandTypes() {
		System.out.println("Well..... this is stupid, isnt ist?");
	}
	public boolean load(File file) {
		return false;
		
	}
		
	public boolean save(File file) {
		return false;
		
	}

	public void commandPerformed(ICommand command) {
		
	}

	public CommandList getControlProcess() {
		return controlProzess;
	}
	
}
