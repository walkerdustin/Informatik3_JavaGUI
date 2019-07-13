package GUI.Bedienelemente.Button;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ControlDevelepor;
import Model.ControlModel;

/**
 * Klasse für das Erstellen des UPButtons im PanelTableView
 * 
 * Verknüfung mit ControlDevelepor
 * 
 * @author TheRealTripleM
 *
 */
public class ButtonUp extends JButton {
	public ButtonUp() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("UpButton gedrückt");
				ControlModel.getInstance().listManager.UpCommand(ControlDevelepor.getInstance().getSelectedRow());
			}
		});
		setText("UP");
	}
}
