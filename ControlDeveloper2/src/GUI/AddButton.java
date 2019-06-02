package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ControlDevelepor;

public class AddButton extends JButton { //implements ActionListener{
	private ControlDevelepor cD;
	
	private class AddButtonController implements ActionListener{
		private ControlDevelepor cD;
		
		public AddButtonController(ControlDevelepor cD) {
			this.cD = cD;
		}
			public void actionPerformed(ActionEvent e) {
				System.out.println("AddButton gedr�ckt");
				cD.addType();
			}
	}
	
	public AddButton (ControlDevelepor cD) {
		this.cD = cD;
		setText("ADD");
		
		addActionListener(new AddButtonController(cD));
		
	}
}