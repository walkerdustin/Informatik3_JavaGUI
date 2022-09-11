package GUI.Bedienelemente.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.ViewControlDevelepor;
import GUI.Panels.PanelCommandsView;
import Model.CommandType;
import Model.ControlModel;

/**
 * Klasse für das Erstellen des AddButtons im PanelTypesView
 * 
 * Verknüfung mit ControlDevelepor
 * 
 * @author TheRealTripleM
 *
 */
public class ButtonAdd extends JButton { // implements ActionListener{

	private class AddButtonController implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println("AddButton gedrückt");
			String strCommand = ViewControlDevelepor.getInstance().getSelectedType();
			System.out.println("Folgender Command wird angelegt: " + strCommand);
			ControlModel.getInstance().listManager.addCommand(new CommandType(strCommand).createInstance());
			Updater.updateAll();
			PanelCommandsView.getInstance().setSelection(ControlModel.getInstance().listManager.getSize() - 1);

		}
	}

	public ButtonAdd(ControlDevelepor cD) {
		setText("ADD");

		addActionListener(new AddButtonController());
	}
}
