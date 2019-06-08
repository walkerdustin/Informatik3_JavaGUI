package GUI.Panels;

import javax.swing.JPanel;

import GUI.iUpdater;

public class PanelAusgabefensterView extends JPanel implements iUpdater {

	/////////////////////////////////////////// Singleton
	private static PanelAusgabefensterView instance = new PanelAusgabefensterView();

	public static PanelAusgabefensterView getInstance() {
		return instance;
	}

	private PanelAusgabefensterView() {
	}
	// -----------------------------------------------

	@Override
	public void updateView() {
		// TODO Auto-generated method stub

	}

}
