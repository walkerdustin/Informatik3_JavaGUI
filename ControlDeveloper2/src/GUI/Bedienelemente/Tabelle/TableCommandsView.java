package GUI.Bedienelemente.Tabelle;

import javax.swing.JTable;

import Controller.Updater;
import GUI.iUpdater;

public class TableCommandsView extends JTable implements iUpdater {

	public TableCommandsView(TableCommandsModel mTM) {
		Updater.add(this);
		setModel(mTM);
	}

	@Override
	public void updateView() {

	}
}
