package GUI.Bedienelemente.Tabelle;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.iUpdater;

public class TableCommandsView extends JTable implements iUpdater {

	public TableCommandsView(TableCommandsModel mTM) {
		Updater.add(this);
		setModel(mTM);
		getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(getSelectedRow());
				if(!e.getValueIsAdjusting()) {
					System.out.println("CommandChanged");
					ControlDevelepor.getInstance().CommandSelectionChanged(getSelectedRow());
				}
				
			}
		});
		
		
	}

	@Override
	public void updateView() {

	}
}
