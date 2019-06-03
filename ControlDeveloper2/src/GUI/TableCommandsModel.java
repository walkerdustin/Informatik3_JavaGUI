package GUI;

import javax.swing.table.AbstractTableModel;

import Controller.ControlDevelepor;
import Model.Command;
import Model.CommandList;
import Model.CommandType;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class TableCommandsModel extends AbstractTableModel {
	private ControlDevelepor cD;
	private CommandList listCommands;
	private final String[] arrCOLUMNNAMES = {"Nr.", "Command", "Configuration"};
	
	
	
	public TableCommandsModel(ControlDevelepor cD) {
		this.cD = cD;
		listCommands = new CommandList();
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
