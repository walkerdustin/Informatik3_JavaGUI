package GUI.Panels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.iUpdater;
import Model.CommandType;
import Model.ControlModel;
import Model.Direction;
import Model.Gear;
import Model.Pause;
import sun.security.action.GetBooleanAction;

public class PanelAttributionsView extends JPanel implements iUpdater {
	ControlDevelepor cD;

	/////////// Constants
	private static final String HEADLINE = "Attributes";

	private static final String DIRECTINONPANEL = "DIRECTINONPANEL";
	private static final String GEARPANEL = "GEARPANEL";
	private static final String PAUSEPANEL = "PAUSEPANEL";
	private static final String NOTHINGPANEL = "NOTHINGPANEL";
	private static String currentPanelString = NOTHINGPANEL; // entspricht dem defaultwert des CardLayout
	/////////////////////////////////

	/////////////////////////////////////////// Visual stuff
	private JButton bSave = new JButton("Save");
	private JPanel cards;
	////////////////////////////////////////////

	///////////////////////////////////////// Textfields
	JTextField textAttributeDir = new JTextField();
	JTextField textAttributeGear1 = new JTextField();
	JTextField textAttributeGear2 = new JTextField();
	JTextField textAttributePause = new JTextField();
	Dimension textfieldSize = new Dimension(200, 8);
	// -------------------------------------------------

	///////////////////////////////////////// Labels
	JLabel labelAttributeDir = new JLabel("Degree");
	JLabel labelAttributeGear1 = new JLabel("Speed");
	JLabel labelAttributeGear2 = new JLabel("Duration");
	JLabel labelAttributePause = new JLabel("Duration");
	Dimension labelSize = new Dimension(150, 8);
	// ---------------------------------------

	//////////////////////////////////////// inner Class Button Controller
	/*
	 * Innere Classe als Button Controller
	 */
	private class SaveButtonControler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Save Button gedrückt");

			int selectedRow = cD.getSelectedRow();
			// ControlModel.getInstance().getControlProcess().remove(selectedRow);

			int attribut1 = -1000;
			double attribut2 = -1.0;
			boolean succesfulTypeConversion = true;

			switch (currentPanelString) {
			case DIRECTINONPANEL:
				try {
					attribut1 = Integer.parseInt(textAttributeDir.getText());
				} catch (NumberFormatException e) {
					succesfulTypeConversion = false;
					e.printStackTrace();
					ungueltigeArgumenteWarnung();

				}
				if (succesfulTypeConversion) {

					ControlModel.getInstance().getControlProcess().remove(selectedRow);
					ControlModel.getInstance().getControlProcess().add(new Direction(attribut1), selectedRow);
				}
				break;
			case GEARPANEL:
				try {
					attribut1 = Integer.parseInt(textAttributeGear1.getText());
					attribut2 = Double.parseDouble(textAttributeGear2.getText());
				} catch (NumberFormatException e) {
					succesfulTypeConversion = false;
					e.printStackTrace();
					ungueltigeArgumenteWarnung();

				}

				if (succesfulTypeConversion) {

					ControlModel.getInstance().getControlProcess().remove(selectedRow);
					ControlModel.getInstance().getControlProcess().add(new Gear(attribut1, attribut2), selectedRow);
				}
				break;
			case PAUSEPANEL:
				try {
					attribut2 = Double.parseDouble(textAttributePause.getText());
				} catch (NumberFormatException e) {
					succesfulTypeConversion = false;
					e.printStackTrace();
					ungueltigeArgumenteWarnung();

				}

				if (succesfulTypeConversion) {

					ControlModel.getInstance().getControlProcess().remove(selectedRow);
					ControlModel.getInstance().getControlProcess().add(new Pause(attribut2), selectedRow);
				}
				break;
			case NOTHINGPANEL:
				System.out.println("Save Button sagt : Nothing to save here!!");
				break;

			default:
				System.out.println(
						"SaveButton sagt: something went really bad you should check the code!! in SaveButtonController.actionPerformed() !!!!!!");
				break;
			}
			Updater.updateAll();
			ControlDevelepor.getInstance().UpdateTableView();
		}
	}
	////////////////////////////////////////////////

	/////////////////// Singleton
	private static PanelAttributionsView instance;

	/*
	 * @return returns the Singleton instance of PAV
	 */
	public static PanelAttributionsView getInstance() {
		if (PanelAttributionsView.instance == null) {
			PanelAttributionsView.instance = new PanelAttributionsView();
		}
		return PanelAttributionsView.instance;
	}
	// ---------------------------

	/*
	 * Konstrutor für PanelAttributesView
	 * 
	 * hier werden alle Gui Elemente instanziiert und mit content befüllt das Layout
	 * wird festgelegt
	 * 
	 */
	private PanelAttributionsView() {

		System.out.println("ConstruktorPanelAttributionsView");
		Updater.add(this);
		this.cD = ControlDevelepor.getInstance();

		//////////////////////////////////////////////////////////////////// Test
		textAttributeDir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println(textAttributeDir.getText());

			}
		});
		////////////////////////////////////////////////////////////////////////

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
		DirectionCard.add(labelAttributeDir);
		DirectionCard.add(textAttributeDir);

		add(DirectionCard, BorderLayout.CENTER);
		////////////////////////////////////////
		//////////////////////////////////////// GearCard
		JPanel GearCard = new JPanel(new GridLayout(2, 2));
		GearCard.add(labelAttributeGear1);
		GearCard.add(textAttributeGear1);
		GearCard.add(labelAttributeGear2);
		GearCard.add(textAttributeGear2);

		////////////////////////////////////////
		//////////////////////////////////////// PauseCard
		JPanel PauseCard = new JPanel(new GridLayout(1, 2));
		PauseCard.add(labelAttributePause);
		PauseCard.add(textAttributePause);

		////////////////////////////////////////
		//////////////////////////////////////// NothingCard
		JPanel NothingCard = new JPanel();

		////////////////////////////////////////
		///////////////////////////////////////////////////////////

		// adding all Cards
		cards.add(NothingCard, NOTHINGPANEL); // Als erstes geaddet, dadurch ist es der default wert
		cards.add(DirectionCard, DIRECTINONPANEL);
		cards.add(GearCard, GEARPANEL);
		cards.add(PauseCard, PAUSEPANEL);

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

	private void ungueltigeArgumenteWarnung() {
		System.out.println("Es wurden ungueltige Argumente ausgewaehlt");
		Object[] options = { "sorry", "Tut mir Leid", "War keine Absicht" };
		JOptionPane.showOptionDialog(null,
				"Sie haben ungueltige Werte eingegeben! \n Es sind nur Zahlen erlaubt \n Float  ist z.B: 13.3 ",
				"Attribut Fehler!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
	}

	/**
	 * returns the card that is visible
	 * 
	 * @return the panel that is visible in the CardLayout Panel
	 */
	public JPanel getvisiblePanel() {
		JPanel card = null;

		for (Component comp : cards.getComponents()) {
			if (comp.isVisible() == true) {
				card = (JPanel) comp;
				System.out.println(card.getName());
			}
		}
		System.out.println();
		return card;
	}

	@Override
	/*
	 * Entscheidet Welche Card des CardLayout gezeigt werden sollte anhand der
	 * momentan ausgewählten Zeile im TableCommandsView
	 */
	public void updateView() {
		int selectedRow = cD.getSelectedRow();
		int i = 3;
		System.out.print("PAV.updateView() sagt: selectedRow == ");
		System.out.println(selectedRow);

		CardLayout cardLayout = (CardLayout) (cards.getLayout());
		if (selectedRow < 0) {
			cardLayout.show(cards, NOTHINGPANEL);
			System.out.println(NOTHINGPANEL + " is launched");
			currentPanelString = NOTHINGPANEL;
		} else {
			String commandName = ControlModel.getInstance().getControlProcess().get(selectedRow).getName(); // get
			// Command
			String[] tempStringArray = commandName.split("#x#");
			// Type of Selected Row
			String selection = tempStringArray[0];

			System.out.println("  , String Selection == " + selection);

			switch (selection) {
			case "Direction":
				cardLayout.show(cards, DIRECTINONPANEL);
				System.out.println(DIRECTINONPANEL + " is launched");
				currentPanelString = DIRECTINONPANEL;

				textAttributeDir.setText(tempStringArray[1]);

				break;
			case "Gear":
				cardLayout.show(cards, GEARPANEL);
				System.out.println(GEARPANEL + " is launched");
				currentPanelString = GEARPANEL;

				textAttributeGear1.setText(tempStringArray[1]);
				textAttributeGear2.setText(tempStringArray[2]);

				break;
			case "Pause":
				cardLayout.show(cards, PAUSEPANEL);
				System.out.println(PAUSEPANEL + " is launched");
				currentPanelString = PAUSEPANEL;

				textAttributePause.setText(tempStringArray[1]);

				break;

			default:
				System.err.println("Stored NameString is invalid");
				cardLayout.show(cards, NOTHINGPANEL);
				System.out.println(NOTHINGPANEL + " is launched");
				currentPanelString = NOTHINGPANEL;
				break;
			}
		}
	}

}
