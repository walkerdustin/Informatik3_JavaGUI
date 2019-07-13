package GUI.Bedienelemente.Button;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ControlDevelepor;
import Model.ControlModel;

/**
 * Klasse für das Erstellen des DownButtons im PanelTableView
 * 
 * Verknüfung mit ControlDevelepor
 * 
 * @author TheRealTripleM
 *
 */
public class ButtonDown extends JButton {
	public ButtonDown() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("DownButton gedrückt");
				ControlModel.getInstance().listManager.DownCommand(ControlDevelepor.getInstance().getSelectedRow());
			}
		});
		setText("DOWN");
	}
}
