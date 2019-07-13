package GUI;

/*
 * Interface um Updater.updateAll zu nutzen
 */
public interface iUpdater {
//	final Color DARK = new Color(33,33,33);
//	default void setDarkMode() {
//		this.getContentPane().setBackground(new Color(33, 33, 33));
//	}
	/*
	 * Hier soll der sichtbare part der Gui aktualisiert werden.
	 * 
	 * Es muss sichergestellt werden, das der Content der Gui die Daten des Models
	 * repräsentiert
	 */
	void updateView();

}
