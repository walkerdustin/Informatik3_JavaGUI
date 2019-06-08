package GUI.Panels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.iUpdater;
import Model.ControlModel;

public class PanelAttributionsView extends JPanel implements iUpdater {
	ControlDevelepor cD;

	/////////// Constants
	private static final String HEADLINE = "Attributes";

	private static final String DIRECTINONPANEL = "DIRECTINONPANEL";
	private static final String GEARPANEL = "GEARPANEL";
	private static final String PAUSEPANEL = "PAUSEPANEL";
	/////////////////////////////////

	/////////////////////////////////////////// Visual stuff
	private JButton bSave = new JButton("Save");
	private JPanel cards = new JPanel(new CardLayout(40, 30));
	////////////////////////////////////////////

	///////////////////////////////////////// Textfields
	JTextField textAttribute1 = new JTextField();
	JTextField textAttribute2 = new JTextField();
	Dimension textfieldSize = new Dimension(200, 8);
	// -------------------------------------------------

	///////////////////////////////////////// Labels
	JLabel labelAttribute1 = new JLabel("Attribut 1");
	JLabel labelAttribute2 = new JLabel("Attribut 2");
	Dimension labelSize = new Dimension(150, 8);
	// ---------------------------------------

	//////////////////////////////////////// inner Class Button Controller
	private class SaveButtonControler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Save Button gedrückt");
		}
	}
	////////////////////////////////////////////////

	/////////////////// Singleton
	private static PanelAttributionsView instanceAttributionsView = new PanelAttributionsView();

	public static PanelAttributionsView getInstance() {
		return instanceAttributionsView;
	}
	// ---------------------------

	private PanelAttributionsView() {

		System.out.println("ConstruktorPanelAttributionsView");
		Updater.add(this);
		this.cD = ControlDevelepor.getInstance();

		///////////////////////////////////////// Button
		bSave.setPreferredSize(new Dimension(120, 30));
		bSave.addActionListener(new SaveButtonControler());
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(bSave);
		// -----------------------------------------------

//		textAttribute1.setPreferredSize(textfieldSize);
//		textAttribute2.setPreferredSize(textfieldSize);
//		labelAttribute1.setPreferredSize(labelSize);
//		labelAttribute2.setPreferredSize(labelSize);

		///////////////////////////////////////// Layout
		setLayout(new BorderLayout());
		add(new JLabel(HEADLINE, JLabel.CENTER), BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);

		////////////////////////////////////////////////////////// CARDS for CardLayout
		//////////////////////////////////////// DirectionCard
		JPanel DirectionCard = new JPanel(new GridLayout(1, 2));
		DirectionCard.add(labelAttribute1);
		DirectionCard.add(textAttribute1);

		add(DirectionCard, BorderLayout.CENTER);
		////////////////////////////////////////
		//////////////////////////////////////// GearCard
		JPanel GearCard = new JPanel(new GridLayout(2, 2));
		GearCard.add(labelAttribute1);
		GearCard.add(textAttribute1);
		GearCard.add(labelAttribute2);
		GearCard.add(textAttribute2);

		////////////////////////////////////////
		//////////////////////////////////////// PauseCard
		JPanel PauseCard = new JPanel(new GridLayout(1, 2));
		PauseCard.add(labelAttribute1);
		PauseCard.add(textAttribute1);

		////////////////////////////////////////
		///////////////////////////////////////////////////////////

		// adding all Cards
		cards.add(DirectionCard, DIRECTINONPANEL);
		cards.add(GearCard, GEARPANEL);
		cards.add(PauseCard, PAUSEPANEL);
		///////////////

//		JPanel AttributesGrid = new JPanel(new GridLayout(2, 2));
//		AttributesGrid.add(labelAttribute1);
//		AttributesGrid.add(textAttribute1);
//		AttributesGrid.add(labelAttribute2);
//		AttributesGrid.add(textAttribute2);
//		// AttributesGrid.setPreferredSize(new Dimension(200, 250));
//		JPanel AttributesGridPanel = new JPanel(new BoxLayout(AttributesGrid, BoxLayout.LINE_AXIS));
//
//		add(AttributesGrid, BorderLayout.CENTER);
		// -------------------------------------------
	}

	@Override
	public void updateView() {
//		int selectedRow = cD.getSelectedRow();
//		String selection = ControlModel.getInstance().controlProzessManager.get(selectedRow).getName(); // get Command
//																										// Type of
//																										// Selected Row
//
//		switch (selection) {
//		case "Direction":
//
//			break;
//		case "Gear":
//
//			break;
//		case "Pause":
//
//			break;
//
//		default:
//			System.err.println("Stored NameString is invalid");
//			break;
//		}
	}

}
