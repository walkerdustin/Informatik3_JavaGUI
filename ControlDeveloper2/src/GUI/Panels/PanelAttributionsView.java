package GUI.Panels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.iUpdater;
import Model.ControlModel;
import Model.Direction;
import Model.Gear;
import Model.Pause;

/*
 * In dieser Klasse wirs das Attributes Panel erstellt und implementiert  -SINGLETON
 */
public class PanelAttributionsView extends JPanel implements iUpdater {
	/////////////////// Singleton
	private static PanelAttributionsView instance;

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
	Dimension textfieldSize = new Dimension(70, 20);
	// -------------------------------------------------

	///////////////////////////////////////// Labels
	JLabel labelAttributeDir = new JLabel("Degree");
	JLabel labelAttributeGear1 = new JLabel("Speed");
	JLabel labelAttributeGear2 = new JLabel("Duration");
	JLabel labelAttributePause = new JLabel("Duration");
	Dimension labelSize = new Dimension(70, 20);
	// ---------------------------------------
	/////////////////////////////////////////////// simple Container to respect
	// preferedsize of all the above
	JPanel ctextAttributeDir = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel ctextAttributeGear1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel ctextAttributeGear2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel ctextAttributePause = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel clabelAttributeDir = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel clabelAttributeGear1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel clabelAttributeGear2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel clabelAttributePause = new JPanel(new FlowLayout(FlowLayout.CENTER));

	///////////////////////////////////////////////

	//////////////////////////////////////// inner Class Button Controller
	/*
	 * Innere Classe als Button Controller
	 */
	private class SaveButtonControler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Save Button gedrückt");

			int selectedRow = ControlDevelepor.getInstance().getSelectedRow();
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
		}
	}

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
		//////////////////////////////////////////

		////////////////////////////////////////// prefered Size
		this.setMinimumSize(new Dimension(180, 500));
		textAttributeDir.setPreferredSize(textfieldSize);
		textAttributeGear1.setPreferredSize(textfieldSize);
		textAttributeGear2.setPreferredSize(textfieldSize);
		textAttributePause.setPreferredSize(textfieldSize);

		labelAttributeDir.setPreferredSize(labelSize);
		labelAttributeGear1.setPreferredSize(labelSize);
		labelAttributeGear2.setPreferredSize(labelSize);
		labelAttributePause.setPreferredSize(labelSize);
		//////////////////////////////////////////

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
		clabelAttributeDir.add(labelAttributeDir);
		ctextAttributeDir.add(textAttributeDir);
		JPanel DirectionCard = new JPanel(new GridLayout(1, 2));
		DirectionCard.add(clabelAttributeDir);
		DirectionCard.add(ctextAttributeDir);

		add(DirectionCard, BorderLayout.CENTER);
		////////////////////////////////////////
		//////////////////////////////////////// GearCard
		clabelAttributeGear1.add(labelAttributeGear1);
		ctextAttributeGear1.add(textAttributeGear1);
		clabelAttributeGear2.add(labelAttributeGear2);
		ctextAttributeGear2.add(textAttributeGear2);

		JPanel GearCard = new JPanel(new GridLayout(2, 2));
		GearCard.add(clabelAttributeGear1);
		GearCard.add(ctextAttributeGear1);
		GearCard.add(clabelAttributeGear2);
		GearCard.add(ctextAttributeGear2);

		////////////////////////////////////////
		//////////////////////////////////////// PauseCard
		clabelAttributePause.add(labelAttributePause);
		ctextAttributePause.add(textAttributePause);

		JPanel PauseCard = new JPanel(new GridLayout(1, 2));
		PauseCard.add(clabelAttributePause);
		PauseCard.add(ctextAttributePause);

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

	}

	/*
	 * gibt einen Warndialog aus eigentlich nur um den Benutzer noch mehr zu
	 * demütigen...
	 */
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
		int selectedRow = ControlDevelepor.getInstance().getSelectedRow();
		System.out.print("PAV.updateView() sagt: selectedRow == ");
		System.out.println(selectedRow);

		CardLayout cardLayout = (CardLayout) (cards.getLayout());
		if (selectedRow < 0) {
			cardLayout.show(cards, NOTHINGPANEL);
			System.out.println(NOTHINGPANEL + " is launched");
			currentPanelString = NOTHINGPANEL;
		} else {
			String commandName = ControlModel.getInstance().listManager.get(selectedRow).getName();
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
