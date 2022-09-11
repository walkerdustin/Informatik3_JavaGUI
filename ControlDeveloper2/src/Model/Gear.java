package Model;

import hsrt.mec.controldeveloper.core.com.command.IGear;

/**
 * KLasse des Gear-Commands Enth�lt folgende Daten: - speed - Geschwindigkeit -
 * duration - Dauer
 *
 */
public class Gear extends Command implements IGear {

	private int speed;
	private double duration;
	private final static int LIMMIN = -100;
	private final static int LIMMAX = 1000;

	/**
	 * Konstruktor der Command mit DefaultWerten initialisert
	 */
	public Gear() {
		setDuration(0);
		setSpeed(0);
		System.out.println("Gear wurde standartm��ig mit 0 initialisiert");
	}

	/**
	 * Konstruktor der Command mit �bergebenen Werten initialisert
	 * 
	 * @param speed    - Geschwindikeit
	 * @param duration - Dauer
	 */
	public Gear(int speed, double duration) {
		setDuration(duration);
		setSpeed(speed);
	}

	/**
	 * Methode um die Geschwindikeit zu setzen
	 * 
	 * @param speed - Geschwindigkeit
	 */
	public void setSpeed(int speed) {
		if (speed >= LIMMIN && speed <= LIMMAX) {
			this.speed = speed;
		} else {
			System.err.println("SpeedInput is out of Range: [" + LIMMIN + " to " + LIMMAX + "]");
			this.speed = 0;
			this.duration = 0;
		}
	}

	/**
	 * Methode die den speed-Wert liefert
	 * 
	 * @return speed - Geschwindigkeitswert
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Methode um den duration-Wert zu setzen
	 * 
	 * @param duration - Dauer
	 */
	public void setDuration(double duration) {
		if (duration < 0) {
			System.err.println("DurationInput is out of Range");
			duration = 0.0;
		}
		this.duration = duration;
	}

	/**
	 * Methode leifert den duration-Wert
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
	 * @return String - Name des Commands, des speed-Wertes und des duration-Wertes
	 */
	public String toString() {
		return ("Gear#x#" + speed + "#x#" + duration);
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
