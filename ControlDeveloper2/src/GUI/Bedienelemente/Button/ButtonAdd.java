package GUI.Bedienelemente.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ControlDevelepor;

/**
 * Klasse für das Erstellen des AddButtons im PanelTypesView
 * 
 * Verknüfung mit ControlDevelepor
 * 
 * @author TheRealTripleM
 *
 */
public class ButtonAdd extends JButton { // implements ActionListener{
	private ControlDevelepor cD;

	private class AddButtonController implements ActionListener {
		private ControlDevelepor cD;

		public AddButtonController(ControlDevelepor cD) {
			this.cD = cD;
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("AddButton gedrückt");
			cD.addType();
		}
	}

	public ButtonAdd(ControlDevelepor cD) {
		this.cD = cD;
		setText("ADD");

		addActionListener(new AddButtonController(cD));

	}
}
