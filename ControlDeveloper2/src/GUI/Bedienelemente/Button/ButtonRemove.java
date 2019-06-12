package GUI.Bedienelemente.Button;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import Controller.ControlDevelepor;

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
				ControlDevelepor.getInstance().removeCommand();
			}
		});
		setText("REMOVE");

	}
}
