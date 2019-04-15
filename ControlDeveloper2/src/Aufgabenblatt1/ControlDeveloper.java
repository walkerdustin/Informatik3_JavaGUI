package Aufgabenblatt1;

import java.util.Random;
import java.util.Vector;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class ControlDeveloper {
	private static String name = "Control-Developer";
	private Vector<ICommand> commands = new Vector<ICommand>();
	//private CommandList cL;
	
	public static void setName(String newName) {
		name = newName;
	}
	public static String getName() {
		return name;
	}

	public void testCommands() {
		Random rand = new Random();
		commands.add(new Direction(rand.nextInt(180)-90));
		commands.add(new Gear(rand.nextInt(200)-100, (double) rand.nextInt(60)));
		commands.add(new Pause((double)rand.nextInt(60)));
		
		int tempInt = rand.nextInt(23);
		for (int i = 0; i <= tempInt; ++i) {
			switch (rand.nextInt(2)) {
			case 0:
				commands.add(new Direction(rand.nextInt(180)-90));
				break;

			case 1:
				commands.add(new Gear(rand.nextInt(200)-100, (double) rand.nextInt(60)));
				break;
				
			case 2:
				commands.add(new Pause((double)rand.nextInt(60)));
				break;
			default:
				break;
			}
			
		
		}
	}
	
	
	public void printCommands() {
		for(int i = 0; i < commands.size();++i) {
			System.out.println(commands.get(i).getName());
		}
	}

	public void testList(ControlDeveloper cD, CommandList cL) {
		for (int i = 0; i < 10; i++) {
			cD.commands.add(new Direction(i));
		}
		for(int i = 0; i < cD.commands.size();++i) {
			cL.add(cD.commands.get(i));
		}
		
		System.out.println("printList:");
		
		for(int i = 0; i < cL.getSize();++i) {
			System.out.println(cL.get(i));
		}
		
		
		
		System.out.println("Get 5:"+cL.get(5));
		System.out.println("Remove 2:  " + cL.remove(2));
		for(int i = 0; i < cL.getSize();++i) {
			System.out.println(cL.get(i));
		}
		System.out.println("Add 10 at 2:   " + cL.add(new Direction(10), 2) );
		
		for(int i = 0; i < cL.getSize();++i) {
			System.out.println(cL.get(i));
		}

		System.out.println("MoveUp 5:    "+cL.get(5)+"   "+cL.moveUp(5));
		
		for(int i = 0; i < cL.getSize();++i) {
			System.out.println(cL.get(i));
		}
		
		System.out.println("MoveDown 4:    "+cL.get(4)+"   "+cL.moveDown(4));
		
		for(int i = 0; i < cL.getSize();++i) {
			System.out.println(cL.get(i));
		}
		
		
		
	}
	
	public static void main(String[] args) {
//		CommandList cL = new CommandList();
//		ControlDeveloper cD = new ControlDeveloper();
		
//		System.out.println(ControlDeveloper.name);
//		System.out.println(ControlDeveloper.getName());
		
//		cD.testCommands();
//		cD.printCommands();
//		cD.testList(cD,cL);
		
//		CommandType cTPause = new CommandType("Pause");
//		System.out.println(cTPause.createInstance());
//		CommandType cTDirection = new CommandType("Direction");
//		System.out.println(cTDirection.createInstance());
		
		
	}

}
