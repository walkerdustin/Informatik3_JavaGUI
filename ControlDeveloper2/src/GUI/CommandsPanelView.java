package GUI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ControlDevelepor;
import Controller.Updater;

public class CommandsPanelView extends JPanel implements iUpdater {
	private ControlDevelepor cD;
	private static PanelTypesView pTV = null;
	private static GUIList TypesList = null;

	private static final String HEADLINE = "Types";
	private String[] arrCommandTypes;
	private AddButton bAdd;

	public CommandsPanelView(ControlDevelepor cD, String[] arrList) {

		System.out.println("KonstruktorCommandsPanelView");

		Updater.add(this); // registrieren beim Observer

		this.cD = cD;
		arrCommandTypes = arrList;

		setLayout(new BorderLayout());
		add(new JLabel(HEADLINE, JLabel.CENTER), BorderLayout.NORTH);
		setSize(200, 400);

		System.out.println("PanelAngelegt");

		bAdd = new AddButton(cD);
		add(bAdd, BorderLayout.SOUTH);

	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub

	}
}
