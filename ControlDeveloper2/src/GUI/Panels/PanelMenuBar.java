package GUI.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Controller.ControlDevelepor;
import GUI.ViewControlDevelepor;
import Model.ControlModel;
import hsrt.mec.controldeveloper.core.com.WiFiCard;
import hsrt.mec.controldeveloper.core.com.WiFiCardHandler;

/**
 * Klasse des Panels MenuBar
 * 
 * @author TheRealTripleM
 *
 */
public class PanelMenuBar extends JMenuBar {
	private static PanelMenuBar instance = null;
	private final JFileChooser fChooser = new JFileChooser();

	public PanelMenuBar() {
		// ******************** Erstellen der Menüeinträge ********************
		JMenu mFile = new JMenu("File");
		JMenu mInfo = new JMenu("Info");
		JMenu mWifi = new JMenu("Wifi");

		add(mFile);
		add(mInfo);
		add(mWifi);

		// ******************** Erstellen der Untermenüs ********************
		JMenu umManage = new JMenu("FileManagement");
		mFile.add(umManage);

		// ******************** Erstellen der Einträge ********************
		// * * * * * File-Einträge * * * * *
		JMenuItem iLoad = new JMenuItem("Load List");
		JMenuItem iSave = new JMenuItem("Save List");
		JMenuItem iEmpty = new JMenuItem("Empty actuale List");

		umManage.add(iLoad);
		umManage.add(iSave);

		mFile.add(iEmpty);

		// * * * * * Info-Einträge * * * * *
		JMenuItem iAbout = new JMenuItem("About");

		mInfo.add(iAbout);

		// * * * * * WIFI-Einträge * * * * *
		JMenuItem iSelWifi = new JMenuItem("Select Wifi Card");

		mWifi.add(iSelWifi);

		// ******************** Erstellen der AktionLisenter ********************
		iLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Menueintrag 'Load' ausgewählt");

				int returnVal = fChooser.showOpenDialog(ViewControlDevelepor.getInstance());

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fChooser.getSelectedFile();
					ControlModel.getInstance().load(file);
				} else {
					System.out.println("Panel Menu Bar: Load File abgebrochen");
				}
				PanelCommandsView.getInstance().UpdateTableView();
			}
		});

		iSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Menueintrag 'Save' ausgewählt");

				int returnVal = fChooser.showSaveDialog(ViewControlDevelepor.getInstance());

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fChooser.getSelectedFile();
					ControlModel.getInstance().save(file);
				} else {
					System.out.println("Panel Menu Bar: Save File abgebrochen");
				}
			}
		});

		iEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Menueintrag 'Empty' ausgewählt");
				ControlDevelepor.getInstance().EmptyList();

			}
		});

		iAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		iSelWifi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
				WiFiCardHandler wiFiCardHandler = new WiFiCardHandler();
				WiFiCard wiFiCards[] = wiFiCardHandler.getWiFiCards();
				Vector<String> wifiNames = new Vector<String>();
				if (wiFiCards.length >= 0) {
					for (WiFiCard wiFiCard : wiFiCards) {
						wifiNames.add(wiFiCard.getDisplayName());
					}
					Object wifiNamesArray[] = wifiNames.toArray();

					String s = (String) JOptionPane.showInputDialog(

							ViewControlDevelepor.getInstance(), "Wähle eine der Wifi Karten aus:", "Choose WiFi",
							JOptionPane.QUESTION_MESSAGE, null, wifiNamesArray, wifiNamesArray[0]);

					// If a string was returned
					if ((s != null) && (s.length() > 0)) {
						System.out.print("Wifi selektiert: ");
						System.out.println(s);
						// Raussuchen des ausgewählten WiFiCardObjektes
						for (WiFiCard wiFiCard : wiFiCards) {
							if (wiFiCard.getDisplayName() == s) {
								ControlModel.getInstance().setWiFiCard(wiFiCard);
								break; // ab hier muss nicht mehr weiter gesucht werden...abbrechen der for schleife
							}
						}
					} else {
						System.out.println("Fehler beim auswählen der Wifi Karte: Kein String wurde zurückgegeben");
					}
				} else {
					Object[] options = { "sorry", "Tut mir Leid", "War keine Absicht" };
					JOptionPane.showOptionDialog(null,
							"Leider haben sie keine WiFi Karte in ihrem System! \n Das tut mir sehr leid für sie! \n Diese hier kann ich empfehlen: https://www.amazon.de/CSL-Netzwerkkarte-empfangsstarke-Hochleistungs-Doppelantenne-Schnittstelle/dp/B01NBR7MQ9/ref=sr_1_13?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&keywords=wifi+karte&pldnSite=1&qid=1560699777&s=gateway&sr=8-13 ",
							"Kein WiFi Fehler!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);
				}
			}
		});

	}

	/*
	 * @return returns The Singleton Instance of PMB
	 */
	public static PanelMenuBar getInstance() {
		if (instance == null) {
			instance = new PanelMenuBar();
		}
		return instance;
	}
}
