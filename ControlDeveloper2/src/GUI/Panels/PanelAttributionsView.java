package GUI.Panels;

import java.awt.BorderLayout;
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

import GUI.iUpdater;

public class PanelAttributionsView extends JPanel implements iUpdater {

	private static final String HEADLINE = "Attributes";

	private JButton bSave = new JButton("Save");

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

	/////////////////// Singleton
	private static PanelAttributionsView instanceAttributionsView = new PanelAttributionsView();

	public static PanelAttributionsView getInstance() {
		return instanceAttributionsView;
	}
	// ---------------------------

	private class SaveButtonControler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Save Button gedrückt");
		}
	}

	private PanelAttributionsView() {
		System.out.println("ConstruktorPanelAttributionsView");

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

		JPanel AttributesGrid = new JPanel(new GridLayout(2, 2));
		AttributesGrid.add(labelAttribute1);
		AttributesGrid.add(textAttribute1);
		AttributesGrid.add(labelAttribute2);
		AttributesGrid.add(textAttribute2);
		// AttributesGrid.setPreferredSize(new Dimension(200, 250));
		JPanel AttributesGridPanel = new JPanel(new BoxLayout(AttributesGrid, BoxLayout.LINE_AXIS));

		add(AttributesGrid, BorderLayout.CENTER);
		// -------------------------------------------
	}

	@Override
	public void updateView() {
		System.out.println("PanelAttributesView updated");
		labelAttribute1.setText(""); // TODO
		labelAttribute1.setText(""); // TODO
	}

}
