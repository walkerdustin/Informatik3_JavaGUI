package GUI.Bedienelemente.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.ControlModel;

/**
 * Klasse für das Erstellen des StopButtons im PanelTableView
 * 
 * Verknüfung mit ControlDevelepor
 * 
 * @author TheRealTripleM
 *
 */
public class ButtonStop extends JButton {
	public ButtonStop() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("StopButton gedrückt");
				ControlModel.getInstance().stop();
			}
		});
		setText("STOP");
	}
}
