package GUI.Panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.iUpdater;
import GUI.Bedienelemente.Button.ButtonDown;
import GUI.Bedienelemente.Button.ButtonRemove;
import GUI.Bedienelemente.Button.ButtonStart;
import GUI.Bedienelemente.Button.ButtonStop;
import GUI.Bedienelemente.Button.ButtonUp;
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
		add(new JScrollPane(jT), BorderLayout.CENTER);

	}

	public static PanelCommandsView getInstance() {
		return instance;
	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub

	}

	public void addCommand(String strCommand) {
		mTM.addCommand(strCommand);

	}

	public String getCommandTypeAt(int row) {
		return mTM.getValueAt(row, 1).toString();
	}

	public int getSelectedCOmmandRow() {
		return jT.getSelectedRow();
	}

	public void removeCommand(int row) {
		mTM.removeCommand(row);

	}

	public void upCommand(int row) {
		mTM.upCommand(row);

	}

	public void downCommand(int row) {
		mTM.downCommand(row);

	}

	public void testList() {
		mTM.test();

	}

	public void emptyList() {
		mTM.emptyList();
		
	}
}
