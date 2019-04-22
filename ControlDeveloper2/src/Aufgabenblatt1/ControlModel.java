package Aufgabenblatt1;

import java.io.File;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class ControlModel {
	private ControlModel instance = new ControlModel();
	private CommandType[] commandTypes = new CommandType[3];
	private CommandList controlProzess;
	
	private ControlModel() {
		
	}
	
	public ControlModel getInstance() {
		return instance;
	}
	
	public void createCommandTypes() {
		
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
