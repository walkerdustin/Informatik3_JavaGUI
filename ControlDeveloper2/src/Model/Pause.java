package Model;

import hsrt.mec.controldeveloper.core.com.command.IPause;

public class Pause extends Command implements IPause {

	private double duration;

	/**
	 * Konstruktor der Command mit DefaultWerten initialisert
	 */
	public Pause() {
		setDuration(0);
		System.out.println("Pause wurde standartm��ig mit 0 initialisiert");
	}

	/**
	 * Konstruktor der Command mit �bergebenen Werten initialisert
	 * 
	 * @param duration - Dauer
	 */
	public Pause(double duration) {
		if (duration < 0) {
			System.err.println("DurationInput is out of Range");
			duration = 0.0;
		}
		this.duration = duration;
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
	 * Methode um aus einem Command ein String mit allen Ben�tigten Inhalten zu
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
