package GUI;


import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PanelTypesView extends JPanel implements iGui{
	private static final PanelTypesView pTV = new PanelTypesView();
	private static GUIList TypesList = null;
	
	private  PanelTypesView() {

		setLayout(new BorderLayout());
		add(new JLabel("Types", JLabel.CENTER), BorderLayout.NORTH);
		setSize(200, 400);

		
		
		System.out.println("PanelAngelegt");
		System.out.println("ConstruktorPanel");
		
		
		testList();
		
	}
	

	
	static public PanelTypesView getTypesView () {

		
		System.out.println("Panel übergeben");
		return pTV;

	}
	
	void testList()  {
		
		TypesList = new GUIList(new String[] {"Affe","Minischwein", "Faultier"});
		add(new JScrollPane(TypesList,  ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		TypesList.addElement("Ameisenbär");
		
	}


	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		
	}

}
