package Aufgabenblatt1;

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
	
	public Element getNext() {
		return next;
	}
	public Element getPrev() {
		return prev;
	}
	public void setNext(Element next) {
		this.next = next;		
	}
	public void setPrev(Element prev) {
		this.prev = prev;
	}
}
