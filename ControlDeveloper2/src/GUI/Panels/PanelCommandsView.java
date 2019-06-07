package GUI.Panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.iUpdater;
import GUI.Bedienelemente.Tabelle.TableCommandsModel;
import GUI.Bedienelemente.Tabelle.TableCommandsView;

public class PanelCommandsView extends JPanel implements iUpdater {
	private ControlDevelepor cD;
	private static PanelCommandsView instance = new PanelCommandsView();
	private static final String HEADLINE = "Commandliste";
	
	TableCommandsModel mTM = new TableCommandsModel(cD);
	TableCommandsView jT = new TableCommandsView(mTM);
	
	
	private PanelCommandsView() {
		Updater.add(this);
		cD = ControlDevelepor.getInstance();
		setLayout(new BorderLayout());
		
		JPanel panelButtonBar = new JPanel();
		panelButtonBar.setLayout(new GridLayout());
		
		
		
		
		
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static PanelCommandsView getInstance() {
		return instance;
	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub

	}
}
