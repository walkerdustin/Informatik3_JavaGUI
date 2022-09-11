package GUI.Panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Controller.Updater;
import GUI.iUpdater;
import GUI.Bedienelemente.Button.ButtonDown;
import GUI.Bedienelemente.Button.ButtonRemove;
import GUI.Bedienelemente.Button.ButtonStart;
import GUI.Bedienelemente.Button.ButtonStop;
import GUI.Bedienelemente.Button.ButtonUp;
import GUI.Bedienelemente.Tabelle.TableCommandsView;
import Model.ControlModel;

/**
 * Klasse des Panels CommandsView
 * 
 * @author TheRealTripleM
 *
 */
public class PanelCommandsView extends JPanel implements iUpdater {
	private static PanelCommandsView instance = new PanelCommandsView();
	// private static final String HEADLINE = "Commandliste";

//	TableCommandsModel mTM = new TableCommandsModel(cD);
//	TableCommandsView jT = new TableCommandsView(mTM);

	private PanelCommandsView() {
		Updater.add(this);

		setLayout(new BorderLayout());

		JPanel panelButtonBar = new JPanel(new GridLayout());
		JPanel panelRemoveButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelRemoveButton.add(new ButtonRemove());

		panelButtonBar.add(panelRemoveButton);
		JPanel panelInternButtonBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelInternButtonBar.add(new ButtonUp());
		panelInternButtonBar.add(new ButtonDown());
		panelInternButtonBar.add(new ButtonStop());
		panelInternButtonBar.add(new ButtonStart());
		panelButtonBar.add(panelInternButtonBar);

//		jT.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		jT.getColumnModel().getColumn(0).setPreferredWidth(10);
//		jT.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		add(panelButtonBar, BorderLayout.SOUTH);
		add(new JScrollPane(TableCommandsView.getInstance()), BorderLayout.CENTER);

	}

	/**
	 * Methode die die Instanz des Panels liefert
	 * 
	 * @return
	 */
	public static PanelCommandsView getInstance() {
		return instance;
	}

	@Override
	public void updateView() {
		ControlModel.getInstance().myCommandsTableModel.fireTableDataChanged();
	}

	public void setSelection(int row) {
		System.out.println("PCV: set Selection to " + Integer.toString(row));
		TableCommandsView.getInstance().setRowSelectionInterval(row, row);
	}

}
