package Aufgabenblatt1;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public abstract class Command implements ICommand {
	private String name;
	public String getName(){
		return name;
		}
}
