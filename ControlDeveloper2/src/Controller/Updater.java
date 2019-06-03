package Controller;

import java.util.Vector;

import GUI.iUpdater;

/**
 * Diese Klasse ist der Observer des Observer pattern
 * 
 * statisch, so ist sie wie eine globale Variable. und man muss keine Objekt
 * refferenz überall hin mitgeben!
 * 
 * 
 * hier werden alle Gui Elemente (JPanel) dynamischem Inhalt angemeldet um alle
 * upzudaten
 * 
 * @author du-wa
 *
 */

public class Updater {
	private static Vector<iUpdater> updateList = new Vector<iUpdater>();
	// private static Updater instance = new Updater();

	private Updater() {
	}

//	public static Updater getInstance() {
//		return instance;
//	}

	public static void add(iUpdater element) {
		updateList.add(element);
	}

	public static void updateAll() {
		for (iUpdater iUpdater : updateList) { // for each erstellt mit Template. sieht cool aus
			iUpdater.updateView();
		}
	}

}
