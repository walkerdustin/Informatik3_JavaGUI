package Controller;

import java.awt.Color;

import javax.swing.JFrame;

import GUI.ViewControlDevelepor;
import Model.ControlModel;

/**
 * Hauptcontroller - Koordiniert hoffentlich alle Models und Views
 * 
 * @author TheRealTripleM
 *
 */
public class ControlDevelepor {

	// Models
	private ControlModel cM;

	// Views
	private ControlDeveleporView vCD;

	public ControlDevelepor() {
		cM = ControlModel.getInstance();
	};

	private void setControlDeveleporView(ControlDeveleporView vCD) {
		this.vCD = vCD;
	}

	public static void main(String[] args) {
		ControlDevelepor cD = new ControlDevelepor();
		String[] arrCommands;
		arrCommands = ControlModel.getInstance().getCommandTypes().toArray(new String[0]);

		cD.setControlDeveleporView(new ControlDeveleporView(cD, arrCommands));

	}

	/**
	 * Add-Methode: Wird ausgel�st von AddButton im PanelTypesView Koordiniert das
	 * Hinzuf�gen eines neuen (leeren) Commands
	 */
	public void addType() {
		System.out.println(vCD.getSelectedType());
	}
}
