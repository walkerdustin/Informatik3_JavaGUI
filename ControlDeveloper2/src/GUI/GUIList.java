package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class GUIList extends JList implements iGui{
	private DefaultListModel lM;
	
	public GUIList() {
		lM = new DefaultListModel();
		setModel(lM);
	}
	public GUIList(String[] arrContent) {
		lM = new DefaultListModel();
		for (int i = 0; i< arrContent.length; i++) {
			lM.addElement(arrContent[i]);
		}
		setModel(lM);
		
	}
	
	
	public void addElement (String str) {
		lM.addElement(str);
	}
	
	
	
	
	
	
	
	public void updateView() {
		// TODO Auto-generated method stub
		
	}

}
