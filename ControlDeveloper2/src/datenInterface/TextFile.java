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

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import hsrt.mec.controldeveloper.io.IOType;

// This has bin implemented according to the Turtorial at https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
// chapter: Line-Oriented I/O

public class TextFile implements IOType {
	private File file;
	private boolean append;

	private BufferedReader inputStream = null;
	private PrintWriter outputStream = null;

	private Mac sha512_HMAC = null;
	private String key = "password123";
	private final String HMAC_SHA512 = "HmacSHA512";

	public TextFile(File file, boolean append) {
		this.file = file;
		this.append = append;

		try {
			byte[] byteKey = key.getBytes("UTF-8");
			sha512_HMAC = Mac.getInstance(HMAC_SHA512);
			SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA512);
			sha512_HMAC.init(keySpec);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	@SuppressWarnings("unchecked")
	@Override
	public boolean read(Vector<String> arg0) { // stores evry line in txt to arg0
		System.out.println();
		System.out.println("reading....");

		boolean succesfull = true;
		Vector<String> geleseneStrings = new Vector<String>();
		Vector<String> pureStrings = new Vector<String>();
		try {
			inputStream = new BufferedReader(new FileReader(file));

			String l; // buffer string
			while ((l = inputStream.readLine()) != null) {
				geleseneStrings.add(l); // append to the end of Vektor arg0
			}
		} catch (IOException e) {
			e.printStackTrace();
			succesfull = false;
		} finally { // der Programmcode im finally-Block immer ausgeführt wird, egal, ob es einen
					// Fehler gab oder ob es keinen Fehler gab und die Routine glatt durchlief.

			while (!close()) {
			} // versucht solange zu schließen bis er erfolgreich ist. #Hackerstyle ;)
		}
		System.out.println("gelesene Strings: " + geleseneStrings);
		String gelesenerHash = geleseneStrings.lastElement();

		pureStrings = (Vector<String>) geleseneStrings.clone();
		pureStrings.remove(geleseneStrings.size() - 1);
		System.out.println("pure Strings: " + pureStrings);
		System.out.println("gelesener Hash: " + gelesenerHash);
		String generirterHash = createHash(pureStrings.toString());
		System.out.println("generierter Hash: " + generirterHash);

		if (gelesenerHash.contentEquals(generirterHash)) {
			System.out.println("Hashes sind gleich!");
			arg0.addAll(pureStrings);
		} else {
			succesfull = false;
			System.out.println("Hashes sind nicht gleich!");
		}
		System.out.println("reading was " + succesfull);
		return succesfull;
	}

	@Override
	public boolean write(Vector<String> arg0) { // writes every string in arg0 at the end of the specified txt file if
												// this file doesnt exist: a new one is generated. The file outlasts the
												// Runtime of the Programm. You can delet ist to reset its content.

		String hash = createHash(arg0.toString());

		Vector<String> toWrite = (Vector<String>) arg0.clone();
		toWrite.add(hash); // Appends the specified element to the end of this Vector.

		boolean succesfull = true;
		try {
			outputStream = new PrintWriter(new FileWriter(file, append)); // append - if true, then bytes will be
																			// written to the end of the file rather
																			// than the beginning
																			// https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html

			for (Iterator<String> iterator = toWrite.iterator(); iterator.hasNext();) {
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

	// should be private for safety reasons
	private String createHash(String datastring) {
		String result = null;

		//////// https://stackoverflow.com/questions/39355241/compute-hmac-sha512-with-secret-key-in-java
		try {
			byte[] byteKey = key.getBytes("UTF-8");
			sha512_HMAC = Mac.getInstance(HMAC_SHA512);
			SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA512);
			sha512_HMAC.init(keySpec);

			byte[] mac_data = sha512_HMAC.doFinal(datastring.getBytes("UTF-8"));
			// result = Base64.encode(mac_data);
			result = bytesToHex(mac_data);
			System.out.println("Hash: " + result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Done with hashing");
		}
		return result;
	}

	public static String bytesToHex(byte[] bytes) {
		final char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	public void TestHash() {
		System.out.println(createHash("1234"));
		System.out.println(createHash("1235"));
	}

}