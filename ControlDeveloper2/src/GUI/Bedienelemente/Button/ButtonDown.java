package GUI.Bedienelemente.Button;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ControlDevelepor;

public class ButtonDown extends JButton {
	public ButtonDown() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("DownButton gedrückt");
				ControlDevelepor.getInstance().DownCommand();
			}
		});
		setText("DOWN");
	}
}
