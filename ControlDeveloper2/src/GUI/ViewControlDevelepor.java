package GUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.Panels.PanelAttributionsView;
import GUI.Panels.PanelCommandsView;
import GUI.Panels.PanelTypesView;
import Model.ControlModel;

public class ViewControlDevelepor extends JFrame implements iUpdater {
	private ControlDevelepor cD;
	private static ViewControlDevelepor instance;
	String[] arrCommands;

	///////////////////////////////// Panels: \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	private PanelTypesView pTV;
	private PanelAttributionsView pAV;
	private PanelCommandsView pCV;

	// ----------------------------------------------------------

	public static ViewControlDevelepor getInstance() {
		if (ViewControlDevelepor.instance == null) {
			ViewControlDevelepor.instance = new ViewControlDevelepor();
		}
		return ViewControlDevelepor.instance;
	}

	private ViewControlDevelepor() {
		Updater.add(this); // registrieren beim Observer
		pAV = PanelAttributionsView.getInstance();
		pCV = PanelCommandsView.getInstance();
		arrCommands = ControlModel.getInstance().getCommandTypes().toArray(new String[0]);
		
		this.cD = ControlDevelepor.getInstance();
		pTV = PanelTypesView.getTypesView(cD, arrCommands);

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
		mainPlain2.setRightComponent(pAV);
		mainPlain2.setLeftComponent(pCV);

		mainPlain1.setLeftComponent(pTV);
		mainPlain1.setRightComponent(mainPlain2);

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
		// TODO Funktion auskommentieren
	}

	// ********************************* Types Befehle ***************************
	public String getSelectedType() {
		return pTV.getSelectedType();

	}

	// ********************************** Table Befehle ****************************

	public void addCommand(String strCommand) {
		pCV.addCommand(strCommand);
	}

	public String getCommandTypeAt(int selectedRow) {
		return pCV.getCommandTypeAt(selectedRow);

	}

	public int getSelectedCommandRow() {
		return pCV.getSelectedCOmmandRow();
	}

	public void removeCommand(int row) {
		pCV.removeCommand(row);

	}

	public void upCommand(int row) {
		pCV.upCommand(row);

	}

	public void downCommand(int row) {
		pCV.downCommand(row);

	}

	// *********************************** Attributes Befehle *******************
//	public void openDirectionPanel() {
//		System.out.println("Direction wird geöffnet");
//	}
//
//	public void openGearPanel() {
//		System.out.println("Gear wird geöffnet");
//
//	}
//
//	public void openPausePanel() {
//		System.out.println("Pause wird geöffnet");
//
//	}
	// ***************************************************************************

	public void testList() {
		pCV.testList();

	}

}
