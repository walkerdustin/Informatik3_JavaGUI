package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.Panels.PanelAttributionsView;
import GUI.Panels.PanelAusgabefensterView;
import GUI.Panels.PanelCommandsView;
import GUI.Panels.PanelMenuBar;
import GUI.Panels.PanelTypesView;
import Model.ControlModel;

/**
 * Klasse für die Hauptview. Erstellt JFrame und fügt alle Panels zusammen
 * 
 * @author TheRealTripleM
 *
 */
public class ViewControlDevelepor extends JFrame implements iUpdater {
	private ControlDevelepor cD;
	private static ViewControlDevelepor instance;
	String[] arrCommands;

	///////////////////////////////// Panels: \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	private PanelTypesView pTV;
	private PanelAttributionsView pAV;
	private PanelCommandsView pCV;
	private PanelAusgabefensterView pAFV;
	private PanelMenuBar pMB;

	// ----------------------------------------------------------
	/**
	 * Methode liefert Instance
	 * 
	 * @return
	 */
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
		pMB = PanelMenuBar.getInstance();
		pAFV = PanelAusgabefensterView.getInstance();

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
		rootPanel.setBottomComponent(pAFV);
		rootPanel.setTopComponent(mainPlain1);

		// ERgänzen der Einzelnen Planes
		add(pMB, BorderLayout.NORTH);
		add(rootPanel, BorderLayout.CENTER);
		this.pack();

	};

	@Override
	public void updateView() {
		// TODO Funktion auskommentieren
	}

	// ********************************* Types Befehle ***************************
	/**
	 * Methode um Befehl an PanelTypesView weiterzuleiten
	 * 
	 * @return
	 */
	public String getSelectedType() {
		return pTV.getSelectedType();

	}
}
