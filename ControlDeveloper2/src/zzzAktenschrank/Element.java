package zzzAktenschrank;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class Element {
	private Element next;
	private Element prev;
	private ICommand element;
	
	public Element(ICommand element){
		this.element = element;
		
	}
	public ICommand getElement() {
		return this.element;
	}
	
}
