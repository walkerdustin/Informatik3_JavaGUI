package GUI.Panels;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * In dieser Klasse wird das AusgabeFenster erstellt und implementiert -SINGLETON
 */
public class PanelAusgabefensterView extends JPanel {
	private JLabel aktuellerBefehl;
	private static final String HEADLINE = "Ausgabe";

	private static PanelAusgabefensterView instance;

	public static PanelAusgabefensterView getInstance() {
		if (instance == null) {
			instance = new PanelAusgabefensterView();
		}
		return instance;
	}

	/*
	 * Konstruktor
	 */
	private PanelAusgabefensterView() {
		setLayout(new BorderLayout());
		add(new JLabel(HEADLINE, JLabel.CENTER), BorderLayout.NORTH);
		aktuellerBefehl = new JLabel();
		this.add(aktuellerBefehl, BorderLayout.CENTER);
		aktuellerBefehl.setText("Test...");
	}

	/*
	 * um einen String im ausgebeFenster anzuzeigen der String davor angezeigte
	 * String wird überschrieben
	 * 
	 * @param dieser String wird im Ausgebefenster angezeigt
	 */
	public void showStringInPanel(String string) {
		aktuellerBefehl.setText(string);
	}
}
