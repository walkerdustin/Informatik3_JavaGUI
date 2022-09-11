package GUI.Bedienelemente.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ControlDevelepor;
import GUI.Panels.PanelCommandsView;
import Model.ControlModel;

/**
 * Klasse f�r das Erstellen des DownButtons im PanelTableView
 * 
 * Verkn�fung mit ControlDevelepor
 * 
 * @author TheRealTripleM
 *
 */
public class ButtonDown extends JButton {
	public ButtonDown() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("DownButton gedr�ckt");
				int currentRow = ControlDevelepor.getInstance().getSelectedRow();
				ControlModel.getInstance().listManager.DownCommand(currentRow);
				PanelCommandsView.getInstance().setSelection(currentRow + 1);
			}
		});
		setText("DOWN");
	}
}
