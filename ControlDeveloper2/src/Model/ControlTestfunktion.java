package Model;

import java.io.File;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.Console;
import zzzDatenInterface.TextFile;

/**
 * Klasse zum Entwickeln der Umgebung. Klasse enthaelt Main und verschiedene
 * Testmethoden
 * 
 *
 */
public class ControlTestfunktion {
	private static String name = "Control-Developer";
	private Vector<ICommand> commands = new Vector<ICommand>();
	// private CommandList cL;

	/**
	 * Methode zum befuellen einer Liste mit zufaelligen Commands
	 */
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

	/**
	 * Methode um CommandListe in der Konsole auszugeben
	 */
	public void printCommands() {
		for (int i = 0; i < commands.size(); ++i) {
			System.out.println(commands.get(i).getName());
		}
	}

	/**
	 * (veraltete) Metode um Verkettete Liste und ihre Funktionalitaet zu testen
	 * EInzelne Befehle und deren Auswirkungen werden in der Console ausgegeben
	 * 
	 * @param cD - ControlDevelepor
	 * @param cL - CommandList
	 */
	public void testList(ControlTestfunktion cD, CommandList cL) {
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

	/**
	 * Methode um das Lesen und Schreiben in ein Textfile zu testen
	 */
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
		anderedatenStrings.add("Test am Ende anhaengen");

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
		zzzDatenInterface.TextFile textFile = new zzzDatenInterface.TextFile(file, false);
		Vector<String> geleseneStrings = new Vector<String>();
		Vector<String> datenStrings = new Vector<String>();
		datenStrings.add("test 1");
		datenStrings.add("test 2");
		datenStrings.add("test 3");
		datenStrings.add("test 4");

		System.out.println("zu schreibende Strings: ");
		System.out.println(datenStrings);

		Vector<String> anderedatenStrings = new Vector<String>();
		anderedatenStrings.add("ueberschrieben? ");

		textFile.write(datenStrings);
		textFile.read(geleseneStrings);
		System.out.println();
		System.out.println("gelesene Strings: ");
		System.out.println(geleseneStrings);

		System.out.println();
		System.out.println("String: ");
		System.out.println(datenStrings.toString());

		System.out.println();
		System.out.println("Hash: ");

		geleseneStrings.clear();

		System.out.println();
		System.out.println("// ueberschreiben: ");
		textFile.write(anderedatenStrings);

		textFile.read(geleseneStrings);
		System.out.println();
		System.out.println("gelesene Strings: ");
		System.out.println(geleseneStrings);

	}

	/**
	 * Methode um Daten Ueber die Console einzulesen und auszugeben
	 */
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

	/**
	 * Methode um Wifi Umgebung zu testen Einlesen einer Liste in ein File und
	 * Umwandlen in Vektor Auslesen eines Files und Umwandeln von einem Vektor in
	 * eine Liste
	 */
	public void testWifiIO() {
		CommandList cL = new CommandList();
		CommandList cLfromfile = new CommandList();
		System.out.println(ControlTestfunktion.name);

		cL.add(new Direction(0));
		cL.add(new Gear(1, 20));
		cL.add(new Pause(2));
		cL.add(new Direction(3));
		cL.add(new Direction(4));
		cL.add(new Gear(5, 5));
		cL.add(new Direction(6));
		cL.add(new Direction(7));
		cL.printList();

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

	/**
	 * Methode zum testen des ControlModel
	 * 
	 */
	public void testControlModel() {
		CommandList cL = new CommandList();
		System.out.println(ControlTestfunktion.name);

		ControlModel cM = ControlModel.getInstance();

		cL.add(new Direction(0));
		cL.add(new Gear(1, 20));
		cL.add(new Pause(2));
		cL.add(new Direction(3));
		cL.add(new Direction(4));
		cL.add(new Gear(5, 5));
		cL.add(new Direction(6));
		cL.add(new Direction(7));
		cL.add(new Direction(66));
		cL.add(new Direction(66));
		cL.add(new Direction(99));
		;
		cL.printList();

		File loadFile = new File("loadCommandList.txt");
		System.out.println(loadFile.getAbsolutePath());
		TextFile textFile = new TextFile(loadFile, false);

		File saveFile = new File("savedCommandList.txt");
		System.out.println(saveFile.getAbsolutePath());

		textFile.write(cL.ListToVector());
		textFile.close();

		System.out.println();
		System.out.println("CommandList controlProcess vor load():");
		System.out.println(cM.getControlProcess().ListToVector());

		cM.load(loadFile);

		cM.save(saveFile);

	}
//
//	/**
//	 * Main-Methode Dient zum Aufruf der einzelnen TestMethoden
//	 * 
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		ControlTestfunktion cD = new ControlTestfunktion();
//////////////////////////Test FileIO/////////////////////////////////
////		cD.testFileIO();
//////////////////////////////////////////////////////////////////////
//
//////////////////////////Test FileIO/////////////////////////////////
//		// cD.testDustinsTextFile();
//////////////////////////////////////////////////////////////////////		
//
//////////////////////////Test ConsoleIO//////////////////////////////
////		cD.testConsoleIO();
//////////////////////////////////////////////////////////////////////
//
//////////////////////////Test WifiIO/////////////////////////////////
////		cD.testWifiIO();
//////////////////////////////////////////////////////////////////////
//
//////////////////////////Test ControlModel///////////////////////////
//		cD.testControlModel();
//////////////////////////////////////////////////////////////////////
//
////		CommandList cL = new CommandList();
////		
////		System.out.println(ControlDeveloper.name);
////		
//////		cD.testCommands();
//////		cD.printCommands();
////		cD.testList(cD,cL);
////		
//////		CommandType cTPause = new CommandType("Pause");
//////		System.out.println(cTPause.createInstance());
//////		CommandType cTDirection = new CommandType("Direction");
//////		System.out.println(cTDirection.createInstance());
////		System.out.println("");
////		System.out.println(cL.getSize());
////		//cL.moveUp(5);
////		//cL.moveDown(5);
////		//cL.remove(4);
////		cL.add(new Direction(66));
////		
////		cL.printList();
//
//	}

}
