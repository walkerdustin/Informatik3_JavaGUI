
//Sicherheitskopie für Verkettete Liste mit bestehenden Klassen

/*
package Aktenschrank;
 

import java.util.LinkedList;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class CommandList  {
	
	private LinkedList<ICommand> commandList  = new LinkedList<ICommand>();
	
	public boolean add(ICommand c) {
		
		commandList.add(c);
		return true;
	}
	
	public boolean remove (int pos) {
		
		ICommand o = commandList.remove(pos);
		
		return o != null;
	}

	public ICommand get (int pos) {
		//Icommand c = commandList.get(pos);
		return commandList.get(pos);
		
	}
	
	public boolean moveUp(int pos) {
		if(pos >= commandList.size()) {return false;}
		
		ICommand c =commandList.remove(pos);
		commandList.add(pos - 1, c);
		
		return true;
	}

	public boolean moveDown(int pos) {
		if(pos >= commandList.size()) {return false;}
		
		ICommand c =commandList.remove(pos);
		commandList.add(pos + 1, c);
		
		return true;
	}
	
	public int getSize() {
		return commandList.size();
	}
	

	
}
*/
