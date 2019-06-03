package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * KLasse um eine Liste mit DefaultListenModel zu erzeugen implements iGUI
 * 
 * @author TheRealTripleM
 *
 */
public class ListGui extends JList implements iGui {
	private DefaultListModel lM;

	/**
	 * Konstrukter um leere Liste zuerstellen
	 */
	public ListGui() {
		lM = new DefaultListModel();
		setModel(lM);
	}

	/**
	 * Konstruktor um Liste auf Basis eines Stringelements zu erstellen
	 * 
	 * @param arrContent
	 */
	public ListGui(String[] arrContent) {
		lM = new DefaultListModel();
		for (int i = 0; i < arrContent.length; i++) {
			lM.addElement(arrContent[i]);
		}
		setModel(lM);

	}

	/**
	 * addElement - Testzwecke
	 * 
	 * @param str
	 */
	public void addElement(String str) {
		lM.addElement(str);
	}

	// public String

	public void updateView() {
		// TODO Auto-generated method stub

	}

}
