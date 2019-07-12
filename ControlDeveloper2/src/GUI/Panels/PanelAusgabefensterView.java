package GUI.Panels;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.IComListener;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

/*
 * In dieser Klasse wird das AusgabeFenster erstellt und implementiert -SINGLETON
 */
public class PanelAusgabefensterView extends JPanel implements IComListener {
	private JLabel aktuellerBefehl;
	private static final String HEADLINE = "Ausgabe";
	private ComHandler comHandler = ComHandler.getInstance();

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

		comHandler.register(this);
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

	/**
	 * wird durch ComHandler aufgerufen, wenn ein neuer command Performed wird
	 * 
	 * @param command
	 */
	public void commandPerformed(ICommand command) {
		System.out.print("Command performed: ");
		System.out.println(command.getName());
		PanelAusgabefensterView.getInstance().showStringInPanel(command.getName());
	}

}
