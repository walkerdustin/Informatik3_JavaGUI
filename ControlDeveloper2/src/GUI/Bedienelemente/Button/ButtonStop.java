package GUI.Bedienelemente.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.ControlModel;

/**
 * Klasse f�r das Erstellen des StopButtons im PanelTableView
 * 
 * Verkn�fung mit ControlDevelepor
 * 
 * @author TheRealTripleM
 *
 */
public class ButtonStop extends JButton {
	public ButtonStop() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("StopButton gedr�ckt");
				ControlModel.getInstance().stop();
			}
		});
		setText("STOP");
	}
}
