package Aufgabenblatt1;

import java.io.File;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import datenInterface.Console;
import hsrt.mec.controldeveloper.io.TextFile; // Chefs Implementation
//import datenInterface.TextFile;  				//Dustins Implementation

import hsrt.mec.controldeveloper.core.com.WiFiCard;
import hsrt.mec.controldeveloper.core.com.WiFiCardHandler;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.WiFi;

public class ControlDeveloper {
	private static String name = "Control-Developer";
	private Vector<ICommand> commands = new Vector<ICommand>();
	// private CommandList cL;

	public void testCommands() {
		Random rand = new Random();
		commands.add(new Direction(rand.nextInt(180) - 90));
		commands.add(new Gear(rand.nextInt(200) - 100, (double) rand.nextInt(60)));
		commands.add(new Pause((double) rand.nextInt(60)));

		// int tempInt = rand.nextInt(2);
		for (int i = 0; i <= 2; ++i) {
			switch (rand.nextInt(2)) {
			case 0:
				commands.add(new Direction(rand.nextInt(180) - 90));
				break;

			case 1:
				commands.add(new Gear(rand.nextInt(200) - 100, (double) rand.nextInt(60)));
				break;

			case 2:
				commands.add(new Pause((double) rand.nextInt(60)));
				break;
			default:
				break;
			}
		}
	}

	public void printCommands() {
		for (int i = 0; i < commands.size(); ++i) {
			System.out.println(commands.get(i).getName());
		}
	}

	public void testList(ControlDeveloper cD, CommandList cL) {
		for (int i = 0; i < 5; i++) {
			cD.commands.add(new Direction(i));
		}
		for (int i = 0; i < cD.commands.size(); ++i) {
			cL.add(cD.commands.get(i));
		}

		System.out.println("printList:");

		for (int i = 0; i < cL.getSize(); ++i) {
			System.out.println(cL.get(i));
		}

//		System.out.println("Get 5:"+cL.get(5));
//		System.out.println("Remove 2:  " + cL.remove(2));
//		for(int i = 0; i < cL.getSize();++i) {
//			System.out.println(cL.get(i));
//		}
//		System.out.println("Add 10 at 2:   " + cL.add(new Direction(10), 2) );
//		
//		for(int i = 0; i < cL.getSize();++i) {
//			System.out.println(cL.get(i));
//		}
//
//		System.out.println("MoveUp 5:    "+cL.get(5)+"   "+cL.moveUp(5));
//		
//		for(int i = 0; i < cL.getSize();++i) {
//			System.out.println(cL.get(i));
//		}
//		
//		System.out.println("MoveDown 4:    "+cL.get(4)+"   "+cL.moveDown(4));
//		
//		for(int i = 0; i < cL.getSize();++i) {
//			System.out.println(cL.get(i));
//		}
	}

	public void testFileIO() {
		File file = new File("Test.txt");
		TextFile textFile = new TextFile(file, true);
		Vector<String> geleseneStrings = new Vector<String>();
		Vector<String> datenStrings = new Vector<String>();
		datenStrings.add("test 1");
		datenStrings.add("test 2");
		datenStrings.add("test 3");
		datenStrings.add("test 4");

		Vector<String> anderedatenStrings = new Vector<String>();
		anderedatenStrings.add("Test am Ende anhängen");

		textFile.write(datenStrings);
		textFile.close();
		textFile.read(geleseneStrings);
		textFile.close();
		for (Iterator<String> iterator = geleseneStrings.iterator(); iterator.hasNext();) {
			System.out.println((String) iterator.next());
		}
		geleseneStrings.clear();

		textFile.write(anderedatenStrings);
		textFile.close();
		textFile.read(geleseneStrings);
		textFile.close();
		for (Iterator<String> iterator = geleseneStrings.iterator(); iterator.hasNext();) {
			System.out.println((String) iterator.next());
		}
	}

	public void testDustinsTextFile() {
		File file = new File("Test.txt");
		datenInterface.TextFile textFile = new datenInterface.TextFile(file, false);
		Vector<String> geleseneStrings = new Vector<String>();
		Vector<String> datenStrings = new Vector<String>();
		datenStrings.add("test 1");
		datenStrings.add("test 2");
		datenStrings.add("test 3");
		datenStrings.add("test 4");

		System.out.println("zu schreibende Strings: ");
		System.out.println(datenStrings);

		Vector<String> anderedatenStrings = new Vector<String>();
		anderedatenStrings.add("Überschrieben? ");

		textFile.write(datenStrings);
		textFile.read(geleseneStrings);
		System.out.println();
		System.out.println("gelesene Strings: ");
		System.out.println(geleseneStrings);

		geleseneStrings.clear();

		System.out.println();
		System.out.println("// überschreiben: ");
		textFile.write(anderedatenStrings);

		textFile.read(geleseneStrings);
		System.out.println();
		System.out.println("gelesene Strings: ");
		System.out.println(geleseneStrings);

	}

	public void testConsoleIO() {
		Console console = new Console();

		Vector<String> geleseneStrings = new Vector<String>();

		Vector<String> datenStrings = new Vector<String>();
		datenStrings.add("test 1");
		datenStrings.add("test 2");
		datenStrings.add("test 3");

		console.write(datenStrings);

		System.out.println("Geben Sie einen String ein");
		console.read(geleseneStrings);

		System.out.println("Geben Sie einen weiteren String ein: ");

		console.read(geleseneStrings);

		System.out.println("Folgende Strings wurden eingelesen");
		System.out.println(geleseneStrings);
		for (Iterator<String> iterator = geleseneStrings.iterator(); iterator.hasNext();) {
			System.out.println((String) iterator.next());
		}
	}

	public void testWifiIO() {
		CommandList cL = new CommandList();
		CommandList cLfromfile = new CommandList();
		System.out.println(ControlDeveloper.name);

		cL.add(new Direction(0));
		cL.add(new Gear(1, 20));
		cL.add(new Pause(2));
		cL.add(new Direction(3));
		cL.add(new Direction(4));
		cL.add(new Gear(5, 5));
		cL.add(new Direction(6));
		cL.add(new Direction(7));
		cL.printList();

		// mit Dustins Implementierung von TextFile
		File file = new File("TestCommandList2.txt");
		System.out.println(file.getAbsolutePath());
		TextFile textFile = new TextFile(file, false);

		textFile.write(cL.ListToVector());
		textFile.close();

		Vector<String> vecTempStrings = new Vector<String>();
		textFile.read(vecTempStrings);
		textFile.close();

		System.out.println(vecTempStrings);
//		System.out.println("Size Vektor: " + vecTempStrings.size());

		cLfromfile.VectorToList(vecTempStrings);

//		System.out.println("size of new cL: " + cLfromfile.getSize());
//		System.out.println("check Size : " + cLfromfile.checkSize());
//		System.out.println("anfang print");
		cLfromfile.printList();
//		System.out.println("ende print");

//		WiFiCardHandler wifis = new WiFiCardHandler();
//		WiFiCard[] cards = wifis.getWiFiCards();
//		WiFi wifiCard = new WiFi(cards[0]);
//		
//		wifiCard.write(cL.ListToVector());	
	}

	public static void main(String[] args) {
		ControlDeveloper cD = new ControlDeveloper();
////////////////////////Test FileIO/////////////////////////////////
//		cD.testFileIO();
////////////////////////////////////////////////////////////////////

////////////////////////Test FileIO/////////////////////////////////
		cD.testDustinsTextFile();
////////////////////////////////////////////////////////////////////		

////////////////////////Test ConsoleIO//////////////////////////////
//		cD.testConsoleIO();
////////////////////////////////////////////////////////////////////

////////////////////////Test WifiIO/////////////////////////////////
//		cD.testWifiIO();
////////////////////////////////////////////////////////////////////

//		CommandList cL = new CommandList();
//		
//		System.out.println(ControlDeveloper.name);
//		
////		cD.testCommands();
////		cD.printCommands();
//		cD.testList(cD,cL);
//		
////		CommandType cTPause = new CommandType("Pause");
////		System.out.println(cTPause.createInstance());
////		CommandType cTDirection = new CommandType("Direction");
////		System.out.println(cTDirection.createInstance());
//		System.out.println("");
//		System.out.println(cL.getSize());
//		//cL.moveUp(5);
//		//cL.moveDown(5);
//		//cL.remove(4);
//		cL.add(new Direction(66));
//		
//		cL.printList();

	}

}
