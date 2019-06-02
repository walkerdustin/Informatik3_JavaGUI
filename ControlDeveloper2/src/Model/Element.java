package Model;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * Klasse für die Elemente der Verketten Liste Enthält folgende Daten: -
 * Reference Vorheriges Element - Reference Nachfolgendes Element - ICommand des
 * Elements
 *
 */
public class Element {
	private Element next;
	private Element prev;
	private ICommand element;

	/**
	 * Konstruktor initialisiert den ICommand des Elements
	 * 
	 * @param element - ICommand des zuerstellenden Elements
	 */
	public Element(ICommand element) {
		this.element = element;

	}

	/**
	 * Methode die den ICommand des Elements leifert
	 * 
	 * @return ICommand des Elements
	 */
	public ICommand getElement() {
		return this.element;
	}

	/**
	 * Methode die die Reference des nachfolgendes Elements liefert
	 * 
	 * @return Reference nachfolgenden Elements
	 */
	public Element getNext() {
		return next;
	}

	/**
	 * Methode die die Reference des vorherigen Elements liefert
	 * 
	 * @return Refernce des vorherigen Elements
	 */
	public Element getPrev() {
		return prev;
	}

	/**
	 * Methode die das nachfolgendes Element setzt
	 * 
	 * @param next - Reference des nachfolgenden Elements
	 */
	public void setNext(Element next) {
		this.next = next;
	}

	/**
	 * Methode die das verherige Element setzt
	 * 
	 * @param prev - Reference des vorherigen Elements
	 */
	public void setPrev(Element prev) {
		this.prev = prev;
	}
}
