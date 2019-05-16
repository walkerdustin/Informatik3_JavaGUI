package datenInterface;

// for file.txt communication
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.io.IOException;

import java.io.File;
import java.util.Iterator;
import java.util.Vector;

import hsrt.mec.controldeveloper.io.IOType;

// This has bin implemented according to the Turtorial at https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
// chapter: Line-Oriented I/O

public class TextFile implements IOType {
	private BufferedReader inputStream = null;
	private PrintWriter outputStream = null;

	private File file;
	private boolean append;

	public TextFile(File file, boolean append) {
		this.file = file;
		this.append = append;
	}

	@Override
	public boolean close() { // closes the input streams. This is done automatticaly in read() and write()
		boolean succesfull = true;
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				succesfull = false;
			}
		}
		if (outputStream != null) {
			outputStream.close();
		}
		return succesfull;
	}

	@Override
	public boolean read(Vector<String> arg0) { // stores evry line in txt to arg0
		boolean succesfull = true;
		try {
			inputStream = new BufferedReader(new FileReader(file));

			String l; // buffer string
			while ((l = inputStream.readLine()) != null) {
				arg0.add(l); // append to the end of Vektor arg0
			}
		} catch (IOException e) {
			e.printStackTrace();
			succesfull = false;
		} finally { // der Programmcode im finally-Block immer ausgeführt wird, egal, ob es einen
					// Fehler gab oder ob es keinen Fehler gab und die Routine glatt durchlief.

			while (!close()) {
			} // versucht solange zu schließen bis er erfolgreich ist. #Hackerstyle ;)
		}
		return succesfull;
	}

	@Override
	public boolean write(Vector<String> arg0) { // writes every string in arg0 at the end of the specified txt file if
												// this file doesnt exist: a new one is generated. The file outlasts the
												// Runtime of the Programm. You can delet ist to reset its content.
		boolean succesfull = true;
		try {
			outputStream = new PrintWriter(new FileWriter(file, append)); // append - if true, then bytes will be
																			// written to the end of the file rather
																			// than the beginning
																			// https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html

			for (Iterator<String> iterator = arg0.iterator(); iterator.hasNext();) {
				outputStream.println((String) iterator.next());
			}

		} catch (IOException e) {
			e.getCause();
			succesfull = false;
		} finally { // der Programmcode im finally-Block immer ausgeführt wird, egal, ob es einen
					// Fehler gab oder ob es keinen Fehler gab und die Routine glatt durchlief.
			while (!close()) {
			} // versucht solange zu schließen bis er erfolgreich ist. #Hackerstyle ;)
		}
		return succesfull;
	}
}
