package GUI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ControlDevelepor;
import Controller.Updater;

public class PanelCommandsView extends JPanel implements iUpdater {
	private ControlDevelepor cD;
	private static PanelTypesView pTV = null;

	private static final String HEADLINE = "Types";
	private String[] arrCommandTypes;
	

	public PanelCommandsView(ControlDevelepor cD, String[] arrList) {

		System.out.println("KonstruktorCommandsPanelView");

		Updater.add(this); // registrieren beim Observer

		this.cD = cD;
		arrCommandTypes = arrList;

	

	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub

	}
}
