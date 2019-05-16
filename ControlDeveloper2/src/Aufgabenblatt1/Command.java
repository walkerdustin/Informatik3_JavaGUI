package Aufgabenblatt1;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * 
 * @author TheRealTripleM
 *
 */
public abstract class Command implements ICommand {
	private String name;

	/**
	 * @return String Name des Kommands
	 */
	public String getName() {
		return name;
	}
}
