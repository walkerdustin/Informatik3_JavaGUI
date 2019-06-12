package GUI.Bedienelemente.Tabelle;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.iUpdater;
/**
 * ViewKlasse der Tabelle
 * @author TheRealTripleM
 *
 */
public class TableCommandsView extends JTable{

	public TableCommandsView(TableCommandsModel mTM) {

		setModel(mTM);
		getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) { // TODO getSelectedRow() nur einmal abfragen?!
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
