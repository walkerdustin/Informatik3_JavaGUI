package GUI.Bedienelemente.Tabelle;

import javax.swing.table.AbstractTableModel;

import Controller.ControlDevelepor;
import Model.CommandList;
import Model.CommandType;
import Model.Direction;
import Model.Gear;

public class TableCommandsModel extends AbstractTableModel {
	private ControlDevelepor cD;
	private CommandList listCommands;
	private final String[] arrCOLUMNNAMES = {"Nr.", "Command", "Configuration"};
	
	
	
	public TableCommandsModel(ControlDevelepor cD) {
		this.cD = cD;
		listCommands = new CommandList();
		listCommands.add(new Direction(30));
		listCommands.add(new Gear(5, 5.0));
		listCommands.add(new Direction(30));
		listCommands.add(new Gear(5, 5.0));
		listCommands.add(new Direction(30));
		listCommands.add(new Gear(5, 5.0));
	}
	
	public void addCommand(String strCommand) {
		listCommands.add(new CommandType(strCommand).createInstance());
		
		listCommands.printList();
		
		
		System.out.println(strCommand+" - Command wurde angelegt!");
	
		//fireTableRowsInserted(listCommands.getSize(), listCommands.getSize());
		fireTableDataChanged();
	}
	
	
	
	
	
	
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listCommands.getSize();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object o = "";
	
		String[] comContent = CommandType.showInstance(listCommands.get(row));
		switch (col) {
		case 0: o = ""+(row+1); break;
		case 1: o = comContent[0]; break;
		case 2: o = comContent[1]; break;
		default:
			System.err.println("ERROR - INVALID ICOMMAND");
			break;
		}
		return o;
	}

}
