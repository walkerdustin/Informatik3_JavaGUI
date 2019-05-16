package Aufgabenblatt1;

import hsrt.mec.controldeveloper.core.com.command.IPause;

public class Pause extends Command implements IPause {

	private double duration;

	/**
	 * Konstruktor der Command mit DefaultWerten initialisert
	 */
	public Pause() {
		setDuration(0);
		System.out.println("Pause wurde standartmäßig mit 0 initialisiert");
	}

	/**
	 * Konstruktor der Command mit übergebenen Werten initialisert
	 * 
	 * @param duration - Dauer
	 */
	public Pause(double duration) {
		setDuration(duration);
	}

	/**
	 * Methode um den duration-Wert des Commands zu setzen
	 * 
	 * @param duration - Dauer
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * Methode die den duration-Wert des Commands liefert
	 * 
	 * @return duration - Dauer
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * Methode um aus einem Command ein String mit allen Benötigten Inhalten zu
	 * erstellen
	 * 
	 * @return String - Name des Commands und des duartion-Werts
	 */
	public String toString() {
		return ("Pause#x#" + duration);
	}

	/**
	 * Methode die den String des Commands liefert
	 * 
	 * @return string - Art und Daten des Commands
	 */
	public String getName() {
		return this.toString();
	}

}
