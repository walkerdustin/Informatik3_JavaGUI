package GUI.Bedienelemente.Tabelle;

import javax.swing.table.AbstractTableModel;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.iUpdater;
import Model.CommandList;
import Model.CommandType;
import Model.ControlModel;
import Model.Direction;
import Model.Gear;

/**
 * Model der Tabelle aus PanelTableView
 * 
 * @author TheRealTripleM
 *
 */
public class TableCommandsModel extends AbstractTableModel {
	private ControlDevelepor cD;
	private CommandList listCommands;
	private final String[] arrCOLUMNNAMES = { "Nr.", "Command", "Configuration" };

	public TableCommandsModel(ControlDevelepor cD) {
		this.cD = cD;
		listCommands = ControlModel.getInstance().getControlProcess();
		listCommands.add(new Direction(30));
		listCommands.add(new Gear(5, 5.0));
		listCommands.add(new Direction(30));
		listCommands.add(new Gear(5, 5.0));
		listCommands.add(new Direction(30));
		listCommands.add(new Gear(5, 5.0));

	}

	/**
	 * Methode um einen Command zu erstellen und diesen der Tabelle hinzufügen
	 * 
	 * @param strCommand
	 */
	public void addCommand(String strCommand) {
		listCommands.add(new CommandType(strCommand).createInstance());

		listCommands.printList();

		System.out.println(strCommand + " - Command wurde angelegt!");

		// fireTableRowsInserted(listCommands.getSize(), listCommands.getSize());
		fireTableDataChanged();
	}

	/**
	 * Methode um einen Command aus der Tabelle zu löschen
	 * 
	 * @param row
	 */
	public void removeCommand(int row) {
		listCommands.printList();
		System.out.println("DesiredPosition" + row);
		System.out.println("List:" + listCommands.getSize());
		System.out.println("DesiredPosition" + row);
//		if (listCommands.getSize() == 1) {
//			if(ControlDevelepor.getInstance().EmptyList()) {
//				listCommands.remove(row);
//			}
//			else {}
//		}
//		listCommands.remove(row);
		fireTableDataChanged();

	}

	/**
	 * Methode um einen ausgewählten Command um eine Zeile nach oben zu verschieben
	 * 
	 * @param row
	 */
	public void upCommand(int row) {
		listCommands.printList();
		System.out.println("DesiredPosition" + row);
		System.out.println("List:" + listCommands.getSize());
		listCommands.moveUp(row);
		listCommands.printList();
		fireTableDataChanged();

	}

	/**
	 * Methode um einen Ausgewählten Command um eine Zeile nach unten zu verschieben
	 * 
	 * @param row
	 */
	public void downCommand(int row) {
		System.out.println("DesiredPosition" + row);
		listCommands.moveDown(row);
		fireTableDataChanged();

	}

	/**
	 * Methode die die Anzahl der Spalten festlegt
	 */
	@Override
	public int getColumnCount() {
		return 3;
	}

	/**
	 * Methode die die ANzhahl der Zeilen festlegt
	 * 
	 */
	@Override
	public int getRowCount() {
		return listCommands.getSize();
	}

	/**
	 * Methode die dei Spaltenüberschirften festlegt
	 */
	@Override
	public String getColumnName(int column) {
		return arrCOLUMNNAMES[column];
	}

	/**
	 * Methode die den Wert an einer bestimmten Stelle liefert
	 */
	@Override
	public Object getValueAt(int row, int col) {
		Object o = "";

		String[] comContent = CommandType.showInstance(listCommands.get(row));
		switch (col) {
		case 0:
			o = "" + (row + 1);
			break;
		case 1:
			o = comContent[0];
			break;
		case 2:
			o = comContent[1];
			break;
		default:
			System.err.println("ERROR - INVALID ICOMMAND");
			break;
		}
		return o;
	}

	/**
	 * Methode um die Tabelle zu löschen
	 */
	public void emptyList() {
		listCommands.clear();
		fireTableDataChanged();
		Updater.updateAll();

	}

}
