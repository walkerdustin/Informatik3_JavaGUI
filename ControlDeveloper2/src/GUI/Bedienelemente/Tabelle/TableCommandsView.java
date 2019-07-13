package GUI.Bedienelemente.Tabelle;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.ControlDevelepor;
import Model.ControlModel;

public class TableCommandsView extends JTable {
	/////////////////////////////////////////// Singleton
	private static TableCommandsView instance = new TableCommandsView();

	public static TableCommandsView getInstance() {
		return instance;
	}

	private TableCommandsView() {
		setModel(ControlModel.getInstance().myCommandsTableModel);
		getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(getSelectedRow());
				if (!e.getValueIsAdjusting()) {
					System.out.println("CommandChanged");
					if (getSelectedRow() >= 0) {
						ControlDevelepor.getInstance().CommandSelectionChanged(getSelectedRow());
					} else {
						System.out.println("Nothing selected");
					}
				}
			}
		});
	}
}
