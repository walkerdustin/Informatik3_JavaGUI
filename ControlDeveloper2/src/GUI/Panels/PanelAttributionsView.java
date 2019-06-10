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

import javax.swing.Box;
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
	private static final String NOTHINGPANEL = "NOTHINGPANEL";
	/////////////////////////////////

	/////////////////////////////////////////// Visual stuff
	private JButton bSave = new JButton("Save");
	private JPanel cards;
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
	private static PanelAttributionsView instance;

	public static PanelAttributionsView getInstance() {
		if (PanelAttributionsView.instance == null) {
			PanelAttributionsView.instance = new PanelAttributionsView();
		}
		return PanelAttributionsView.instance;
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
		cards = new JPanel();
		CardLayout layout = new CardLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		cards.setLayout(layout);

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
		//////////////////////////////////////// NothingCard
		JPanel NothingCard = new JPanel();

		////////////////////////////////////////
		///////////////////////////////////////////////////////////

		// adding all Cards
		cards.add(DIRECTINONPANEL, DirectionCard);
		cards.add(GEARPANEL, GearCard);
		cards.add(PauseCard, PAUSEPANEL);
		cards.add(NothingCard, NOTHINGPANEL);
		///////////////

		this.add(cards, BorderLayout.CENTER);

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
		int selectedRow = cD.getSelectedRow();
		int i = 3;
		System.out.println("PAV.updateView() sagt: selectedRow == ");
		System.out.print(selectedRow);
		System.out.println();

		CardLayout cardLayout = (CardLayout) (cards.getLayout());
		if (selectedRow <= 0) {
			cardLayout.show(cards, NOTHINGPANEL);
		} else {
			String selection = ControlModel.getInstance().controlProzessManager.get(selectedRow).getName(); // get
																											// Command

			// Type of
			// Selected Row

			switch (selection) {
			case "Direction":

				cardLayout.show(this, DIRECTINONPANEL);
				break;
			case "Gear":
				cardLayout.show(this, GEARPANEL);
				break;
			case "Pause":
				cardLayout.show(this, PAUSEPANEL);
				break;

			default:
				System.err.println("Stored NameString is invalid");
				cardLayout.show(this, NOTHINGPANEL);
				break;
			}
		}
	}

}
