
package Aufgabenblatt1;

import java.util.Vector;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * Klasse für die Verkettung von Commands (Doppeltverkettete Liste)
 *
 */
public class CommandList {

	private Element root; // erstes Element in der Liste Position [0]
	private Element treeTop; // letztes Element in der Liste Position [size-1]
	private int size = 0; // Anzahl der Elemente in der Liste

	/**
	 * Methode um die Wurzel (erste Element) der Liste (neu) zu setzten
	 * 
	 * @param e
	 */
	private void setRoot(Element e) {
		root = e;
	}

	/**
	 * Methode um das letzte Element der Liste zu setzten
	 * 
	 * @param e
	 */
	private void setTreeTop(Element e) {
		treeTop = e;
	}

	/**
	 * Methode liefert Wurzel (erstes Element) der Liste
	 * 
	 * @return erstes Element
	 */
	public Element getRoot() {
		return root;
	}

	/**
	 * Methode liefert letztes Element der Liste
	 * 
	 * @return letztes Element
	 */
	public Element getTreeTop() {
		return treeTop;
	}

	/**
	 * Methode um übergebenen Command an Liste hinten anzuhängen
	 * 
	 * @param c
	 * @return
	 */
	public boolean add(ICommand c) {
		Element newElement = new Element(c);
//		System.out.println("blubb");
		++size;
		if (getRoot() == null) {
			// Listeneröffnung
			setRoot(newElement);
			setTreeTop(newElement);
			return true;
		} else {
			// Einfügen des Commands am Ende der Liste
			treeTop.setNext(newElement);
			newElement.setPrev(treeTop);
			treeTop = newElement;
			return true;
		}
	}

	/**
	 * Methode um übergebenen Command an einer bestimmten Stelle der Liste
	 * einzufügen
	 * 
	 * @param c
	 * @param pos
	 * @return
	 */
	public boolean add(ICommand c, int pos) {
		if (pos <= size && pos >= 0) {

			if (pos == size) {
				return add(c);
			} else {
				Element newElement = new Element(c);
				++size;
				if (pos == 0) {
					newElement.setNext(getRoot());
					getRoot().setPrev(newElement);
					setRoot(newElement);
					return true;
				} else {
					Element runner = getRoot().getNext();
					for (int i = 1; i < size; ++i) {
						if (pos == i) {
							newElement.setNext(runner);
							newElement.setPrev(runner.getPrev());
							runner.getPrev().setNext(newElement);
							runner.setPrev(newElement);
							return true;
						}
						runner = runner.getNext();
					}
					System.err.println("ERROR: No Element added [Position was in Listrange]");
					return false;
				}
			}
		} else {
			System.err.println("Desired position is out of Listrange");
			return false;
		}
	}

	/**
	 * Methode um Element an der gewünschten Stelle zu entfernen
	 * 
	 * @param pos
	 * @return
	 */
	public boolean remove(int pos) {
		if (pos < size && pos >= 0) {
			Element runner = getRoot();

			for (int i = 0; i < size; ++i) {
				if (i == pos) {
					if (runner == getRoot()) {
						if (runner == getTreeTop()) {
							// Liste enthält nur ein Element und dieses soll gelöscht werden
							setRoot(null);
							setTreeTop(null);
							size = 0;
							return true;
						} else {
							// Liste enthält mehr Elemente, nur Root wird gelöscht
							setRoot(runner.getNext());
							getRoot().setPrev(null);
							--size;
							return true;
						}
					} else if (runner == getTreeTop()) {
						//
						runner.getPrev().setNext(null);
						--size;
						return true;
					} else {
						runner.getPrev().setNext(runner.getNext());
						runner.getNext().setPrev(runner.getPrev());
						--size;
						return true;
					}
				} else {
					runner = runner.getNext();
				}
			}
			System.err.println("ERROR: No Element removed [Position was in Listrange]");
			return false;
		} else {
			System.err.println("Desired Position is out of Listrange");
			return false;
		}
	}

	/**
	 * Methode um komplette Liste zu löschen
	 * 
	 * @return true
	 */
	public boolean clear() { // deleting all refrernces to the objects inside // garbage collector will
								// handle the rest
		root = null;
		treeTop = null;
		size = 0;
		return true;
	}

	/**
	 * Methode liefert Element an der gewünschten Position
	 * 
	 * @param pos
	 * @return
	 */
	public ICommand get(int pos) {
		if (getRoot() == null) {
			System.err.println("ERROR: List is empty");
			return null;
		}
		if (pos < size && pos >= 0) {
			Element runner = getRoot();
			for (int i = 0; i < size; ++i) {
				if (i == pos) {
					return runner.getElement();
				}
				runner = runner.getNext();
			}
		} else {
			System.err.println("Desired position is out of ListRange");
			return null;
		}
		System.err.println("ERROR: No Element could be deliverd [Position was in ListRange]");
		return null;
	}

	/**
	 * Methode um ELement an der gewünschten Stelle um eine Position nach oben zu
	 * verschieben
	 * 
	 * @param pos
	 * @return
	 */
	public boolean moveUp(int pos) {
		if (pos < size && pos > 0) {
			Element runner = getRoot().getNext();
			for (int i = 1; i < size; ++i) {
				if (i == pos) {
					runner.getPrev().setNext(runner.getNext());
					if (i != size - 1) {
						runner.getNext().setPrev(runner.getPrev());
					}
					--size;
					add(runner.getElement(), pos - 1);
					return true;
				}
				runner = runner.getNext();
			}
		} else if (pos == 0) {
			System.err.println("ERROR: First Element can not be moved up");
			return false;
		} else {
			System.err.println("Desired position is out of ListRange ");
			return false;
		}
		System.err.println("ERROR: No Element could be moved [Position was in ListRange]}");
		return false;
	}

	/**
	 * Methode um ELement an der gewünschten Stelle um eine Position nach unten zu
	 * verschieben
	 * 
	 * @param pos
	 * @return
	 */
	public boolean moveDown(int pos) {
		if (pos < (size - 1) && pos >= 0) {
			Element runner = getRoot();
			for (int i = 0; i < size - 1; ++i) {
				if (i == pos) {
					if (i == 0) {
						setRoot(runner.getNext());
					} else {
						runner.getPrev().setNext(runner.getNext());
						runner.getNext().setPrev(runner.getPrev());
					}

					--size;
					add(runner.getElement(), pos + 1);
					return true;
				}
				runner = runner.getNext();
			}
		} else if (pos == (size - 1)) {
			System.err.println("ERROR: Last Element can not be moved down");
			return false;
		} else {
			System.err.println("Desired position is out of ListRange");
			return false;
		}
		System.err.println("ERROR: No Element could be moved [Position was in ListRange]}");
		return false;
	}

	/**
	 * Methode liefert die aktuelle Länge der Liste zurück
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Methode um die Liste anhand der Länge auf mögliche Fehler zu untersuchen
	 * 
	 * @return
	 */
	public boolean checkSize() {
		return calculateSize() == size;
	}

	/**
	 * Methode um die Listenlänge neu zu ermitteln
	 * 
	 * @return
	 */
	public int calculateSize() {
		int actualSize = 0;
		if (getRoot() == null) { // falls die Liste wirklich leer ist ( Root == null )
			return 0;
		}

		Element runner = getRoot();

		while (runner != null) {
			++actualSize;
			runner = runner.getNext();
		}
		return actualSize;
	}

	/**
	 * Methode die aus der bestehenden Liste einen String-Vektor erstellt
	 * 
	 * @return String Vektor der in der Liste enthaltenen Objekte
	 */
	public Vector<String> ListToVector() {
		// für Save/Load IOtype
		Vector<String> tempVector = new Vector<String>();
		for (int i = 0; i < size; ++i) {
			tempVector.add(get(i).toString());
		}
		return tempVector;
	}

	/**
	 * Methode die aus einem bestehenden String-Vektor eine Liste erstellt
	 * überschreibt alle Werte / löscht die Liste 
	 * 
	 * @param vecString
	 * @return Liste basierend auf String-Vektor
	 */
	public boolean VectorToList(Vector<String> vecString) {
		this.clear();
		for (int i = 0; i < vecString.size(); ++i) {
			String[] tempString = vecString.get(i).split("#x#");
			add(new CommandType().createInstance(tempString));
		}
		return true;

	}

	/**
	 * Methode um Liste in der Console ausgeben zu lassen
	 */
	public void printList() {
		System.out.println("");
		for (int i = 0; i < getSize(); ++i) {
			// System.out.println(i);
			System.out.println(get(i));
		}
	}

}
