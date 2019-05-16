package Aufgabenblatt1;

import hsrt.mec.controldeveloper.core.com.command.IDirection;

/**
 * Klasse des Direction-Commands Enthält folgende Daten: Grad des Lenkwinkels
 *
 */
public class Direction extends Command implements IDirection {
	private int degree;
	private final static int LIMMIN = -90;
	private final static int LIMMAX = 90;

	/**
	 * Construktor der ein Direction-Command mit DefaultWerten initialisert
	 */
	public Direction() {
		setDegree(0);
		System.out.println("Direction wurde standartmäßig mit 0 initialisiert");
	}

	/**
	 * Construktor um ein Direction-Command mit den übergebenen WinkelWerten
	 * erstellt
	 * 
	 * @param degree - Lenkwinkel
	 */
	public Direction(int degree) {
		setDegree(degree);
	}

	/**
	 * Methode um den Degree-Wert des Direction-Commands zu ändern/zu setzen
	 * 
	 * @param degree
	 */
	public void setDegree(int degree) {
		if (degree >= LIMMIN && degree <= LIMMAX) {
			this.degree = degree;
		} else {
			System.err.println("DegreeInput is out of Range: [" + LIMMIN + " to " + LIMMAX + "]");
			this.degree = 0;
		}
	}

	/**
	 * MEthode liefert Degree-Wert des DirectionCommands
	 * 
	 * @return degree - Lenkwinkel
	 */
	public int getDegree() {
		return degree;
	}

	/**
	 * Methode um aus einem Command ein String mit allen Benötigten
	 * Inhalten zu erstellen
	 * 
	 * @return String - Name des Commands und Lenkwinkel
	 */
	public String toString() {
		return ("Direction#x#" + degree);
	}

	/**
	 * Methode die den String des Direction-Commands liefert
	 */
	public String getName() {
		return this.toString();
	}

}
