package GUI.Bedienelemente.Button;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ControlDevelepor;

public class ButtonStop extends JButton {
	public ButtonStop() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("StopButton gedrückt");
				ControlDevelepor.getInstance().stop();
			}
		});
		setText("STOP");
	}
}
