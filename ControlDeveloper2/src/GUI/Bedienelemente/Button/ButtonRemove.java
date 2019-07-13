package GUI.Bedienelemente.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Controller.ControlDevelepor;
import Model.ControlModel;

/**
 * Klasse für das Erstellen des RemoveButtons im PanelTableView
 * 
 * Verknüfung mit ControlDevelepor
 * 
 * @author TheRealTripleM
 *
 */
public class ButtonRemove extends JButton {
	public ButtonRemove() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("RemoveButton gedrückt");
				ControlModel.getInstance().listManager.removeCommand(ControlDevelepor.getInstance().getSelectedRow());
			}
		});
		setText("REMOVE");

	}
}
