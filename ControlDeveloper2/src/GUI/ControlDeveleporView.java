package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

public class ControlDeveleporView extends JFrame {
	
	public ControlDeveleporView() {
		
		//Haupteinstellungen
		setLayout(new BorderLayout());
		setVisible(true);
		this.setSize(800,400);
		this.getContentPane().setBackground(new Color(33, 33, 33));
		setTitle("Control-Develepor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Fensteraufteilung

		JSplitPane mainPlain1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JSplitPane mainPlain2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		mainPlain2.setLeftComponent(new JLabel("Mitte"));
		mainPlain2.setRightComponent(new JLabel("Rechts"));
		
		mainPlain1.setLeftComponent(new JLabel("Links"));
		mainPlain1.setRightComponent(mainPlain2);
		
		
		JSplitPane rootPlane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		rootPlane.setBottomComponent(new JLabel("Ausgabefenster"));
		rootPlane.setTopComponent(mainPlain1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(new JButton("List"));
		toolBar.add(new JButton("Aktion"));
		
		
		//ERgänzen der Einzelnen Planes
		add(toolBar, BorderLayout.NORTH);
		add(rootPlane, BorderLayout.CENTER);
		pack();
	}
	
}
