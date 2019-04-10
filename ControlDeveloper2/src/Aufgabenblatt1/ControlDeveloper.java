package Aufgabenblatt1;

import java.util.Random;
import java.util.Vector;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class ControlDeveloper {
	private static String name = "Control-Developer";
	private Vector<ICommand> commands = new Vector<ICommand>();
	
	public static void setName(String newName) {
		name = newName;
	}
	public static String getName() {
		return name;
	}

	public void testCommands() {
		Random rand = new Random();
		ICommand temp = new Direction(rand.nextInt(180)-90);
		System.out.println(temp);
		commands.add(temp);
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
	
	
	public static void main(String[] args) {
		System.out.println(ControlDeveloper.name);
		System.out.println("TestString");
		System.out.println(ControlDeveloper.getName());
		
		ControlDeveloper cP = new ControlDeveloper();
		cP.testCommands();
		cP.printCommands();
		
	}

}
