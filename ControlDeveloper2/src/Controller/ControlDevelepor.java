package Controller;



import javax.swing.JFrame;

import GUI.ViewControlDevelepor;
import Model.CommandType;
import Model.ControlModel;
import Model.Direction;
import Model.Gear;

/**
 * Hauptcontroller - Koordiniert hoffentlich alle Models und Views
 * 
 * @author TheRealTripleM
 *
 */
public class ControlDevelepor {
	
	private static ControlDevelepor INSTANCE = new ControlDevelepor();
	// Models
	private ControlModel cM;
	

	// Views
	private ViewControlDevelepor vCD;

	private ControlDevelepor() {
		cM = ControlModel.getInstance();
	};
	
	public static ControlDevelepor getInstance() {
		return INSTANCE;
	}

	private void setControlDeveleporView(ViewControlDevelepor vCD) {
		this.vCD = vCD;
	}
	
	public static void main(String[] args) {
		ControlDevelepor cD = getInstance();

		String[] arrCommands;
		arrCommands = ControlModel.getInstance().getCommandTypes().toArray(new String[0]);
		ViewControlDevelepor vCD = new ViewControlDevelepor(cD, arrCommands);
		
		cD.setControlDeveleporView(vCD);
		

	}

	/**
	 * Add-Methode: Wird ausgel�st von AddButton im PanelTypesView Koordiniert das
	 * Hinzuf�gen eines neuen (leeren) Commands
	 */
	public void addType() {
		String strCommand = vCD.getSelectedType();
		System.out.println("Folgender Command wird angelegt: "+strCommand);
		vCD.addCommand(strCommand);
		Updater.updateAll();
	}
	
}
