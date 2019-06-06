package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.PanelTypesView;

public class ViewControlDevelepor extends JFrame implements iUpdater {
	private static Vector<iUpdater> internUpdateList = new Vector<iUpdater>();
	private PanelTypesView pTV;
	private ControlDevelepor cD;
	
	TableCommandsModel mTM = new TableCommandsModel(cD);
	TableCommandsView jT = new TableCommandsView(mTM);
	
	

	public ViewControlDevelepor(ControlDevelepor cD, String[] arrList) {
		Updater.add(this); // registrieren beim Observer

		this.cD = cD;
		pTV = PanelTypesView.getTypesView(cD, arrList);


		// Haupteinstellungen
		setLayout(new BorderLayout());
		setVisible(true);
		this.setSize(800, 400);
		// this.getContentPane().setBackground(new Color(33, 33, 33));
		setTitle("Control-Develepor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Fensteraufteilung

		JSplitPane mainPlain1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JSplitPane mainPlain2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		mainPlain2.setRightComponent(new JLabel("Rechts"));
		mainPlain2.setLeftComponent(new JScrollPane(jT));

		mainPlain1.setLeftComponent(pTV);
		mainPlain1.setRightComponent(mainPlain2);
		
		internUpdateList.add(jT);
		
		
		
		
		
		
		
		
		
		

		JSplitPane rootPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		rootPanel.setBottomComponent(new JLabel("Ausgabefenster"));
		rootPanel.setTopComponent(mainPlain1);

		JToolBar toolBar = new JToolBar();
		toolBar.add(new JButton("List"));
		toolBar.add(new JButton("Aktion"));

		// ERgänzen der Einzelnen Planes
		add(toolBar, BorderLayout.NORTH);
		add(rootPanel, BorderLayout.CENTER);
		// pack();
		
		
		
		
		
		
		
		
		

	};

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		jT.repaint();

	}

	public String getSelectedType() {
		return pTV.getSelectedType();

	}

}
