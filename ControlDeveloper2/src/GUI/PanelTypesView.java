package GUI;


import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class PanelTypesView extends JPanel{
	private static final PanelTypesView pTV = new PanelTypesView();
	private static JList TypesList = null;
	
	private  PanelTypesView() {

		setLayout(new BorderLayout());
		add(new JLabel("Types", JLabel.CENTER), BorderLayout.NORTH);
		setSize(200, 400);

		
		
		System.out.println("PanelAngelegt");
		System.out.println("ConstruktorPanel");
		
	}
	

	
	static public PanelTypesView getTypesView () {

		
		System.out.println("Panel übergeben");
		return pTV;

	}

}
