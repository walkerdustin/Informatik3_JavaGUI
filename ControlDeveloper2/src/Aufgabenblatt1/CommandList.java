
package Aufgabenblatt1;

import java.util.LinkedList;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class CommandList  {
	
	private Element root;				//erstes Element in der Liste 		Position [0]
	private Element treeTop; 			//letztes Element in der Liste		Position [size-1]
	private static int size = 0; 		//Anzahl der Elemente in der Liste

	private void setRoot(Element e) {
		root = e;
	}
	private void setTreeTop(Element e) {
		treeTop = e;
	}
	public Element getRoot() {
		return root;
	}
	public Element getTreeTop() {
		return treeTop;
	}
	
	
	public boolean add(ICommand c) {

		Element newElement = new Element(c);
		++size;
		if (getRoot() == null) {
			//Listeneröffnung
			setRoot(newElement);
			setTreeTop(newElement);
			return true;
		}
		else {
			//Einfügen des Commands am Ende der Liste
			treeTop.setNext(newElement);
			newElement.setPrev(treeTop);
			treeTop = newElement;
			return true;
		}
	}
	public boolean add(ICommand c, int pos) {
		if (pos <= size && pos >= 0) {
			
			if (pos == size) {
				return add(c);
			}
			else {
				Element newElement = new Element(c);
				++size;
				if (pos == 0) {	
					newElement.setNext(getRoot());
					getRoot().setPrev(newElement);
					setRoot(newElement);
					return true;
				}
				else {
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
		}
		else {
			System.err.println("Desired Position is out of Listrange");
			return false;
		}
		
		
	}

	public boolean remove (int pos) {
		if(pos < size && pos >= 0) {
			Element runner = getRoot();
			
			
			for (int i = 0; i < size; ++i) {
				if (i == pos) {
					if (runner == getRoot()) {
						if (runner == getTreeTop()) {
							//Liste enthält nur ein Element und dieses soll gelöscht werden 
							setRoot(null);
							setTreeTop(null);
							size = 0;
							return true;
						}
						else {
							//Liste enthält mehr Elemente, nur Root wird gelöscht
							setRoot(runner.getNext());
							getRoot().setPrev(null);
							--size;
							return true;
						}
					}
					else if (runner == getTreeTop()) {
						//
						runner.getPrev().setNext(null);
						--size;
						return true;
					}
					else {
						runner.getPrev().setNext(runner.getNext());
						runner.getNext().setPrev(runner.getPrev());
						--size;
						return true;
					}
				}
				else {
					runner = runner.getNext();
				}
			}
			System.err.println("ERROR: No Element removed [Position was in Listrange]");
			return false;
		}
		else {
			System.err.println("Desired Position is out of Listrange");
			return false;
		}
	}

	public ICommand get (int pos) {
		if(pos < size && pos >= 0) {
			Element runner = getRoot();
			for(int i = 0; i < size; ++i) {
				if (i == pos) {
					return runner.getElement();
				}
				runner = runner.getNext();
			}
		}
		else {
			System.err.println("Desired Position is out of ListRange");
			return null;
		}
		System.err.println("ERROR: No Element could be deliverd [Position was in ListRange]}");
		return null;
		
	}
	
	public boolean moveUp(int pos) {
		if (pos < size && pos > 0) {
			Element runner = getRoot().getNext();
			for (int i = 1; i < size; ++i) {
				if (i == pos) {
					runner.getPrev().setNext(runner.getNext());
					runner.getNext().setPrev(runner.getPrev());
					--size;
					add(runner.getElement(), pos-1);
					return true;
				}
				runner = runner.getNext();
			}
		}
		else if (pos == 0) {
			System.err.println("ERROR: First Element can not be moved up");
			return false;
		}
		else {
			System.err.println("Desired Position is out of ListRange");
			return false;
		}
		System.err.println("ERROR: No Element could be moved [Position was in ListRange]}");
		return false;
		
	}

	public boolean moveDown(int pos) {
		if (pos < (size-1) && pos >= 0) {
			Element runner = getRoot();
			for (int i = 0; i < size-1; ++i) {
				if (i == pos) {
					runner.getPrev().setNext(runner.getNext());
					runner.getNext().setPrev(runner.getPrev());
					--size;
					add(runner.getElement(), pos+1);
					return true;
				}
				runner = runner.getNext();
			}
		}
		else if (pos == (size - 1)) {
			System.err.println("ERROR: last Element can not be moved down");
			return false;
			
		}
		else {
			System.err.println("Desired Position is out of ListRange");
			return false;
		}
		System.err.println("ERROR: No Element could be moved [Position was in ListRange]}");
		return false;
	}

	public int getSize() {
		return size;
	}
	
	public boolean checkSize() {
		int temp = 0;
		Element runner = getRoot();
		
		while(runner != null) {
			++temp;
			runner = runner.getNext();
		}
		
		if (temp == size) {
			return true;
		}
		else {
			return false;
		}
		
	
		
	}
}
