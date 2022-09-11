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

	private Updater() {
	}

	/*
	 * @param das iUpdater Objekt, das registriert werden soll
	 * 
	 * mit Updater.updateAll wird updateView aller registrierten Objekte aufgerufen
	 */
	public static void add(iUpdater element) {
		updateList.add(element);
	}

	/*
	 * mit Updater.updateAll wird updateView aller registriernen Objekte aufgerufen
	 */
	public static void updateAll() {
		for (iUpdater iUpdater : updateList) { // for each erstellt mit Template. sieht cool aus
			iUpdater.updateView();
		}
	}
}
