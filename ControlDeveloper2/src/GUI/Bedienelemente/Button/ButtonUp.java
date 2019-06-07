package GUI.Bedienelemente.Button;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ControlDevelepor;

public class ButtonUp extends JButton {
	public ButtonUp() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("UpButton gedrückt");
				ControlDevelepor.getInstance().UpCommand();
			}
		});
		setText("UP");
	}
}
