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

public class TextFile implements IOType {
	private BufferedReader inputStream = null;
	private PrintWriter outputStream = null;
    
    private File file;
	private boolean variable;
    
	public TextFile(File file, boolean variable) {
		this.file = file;
		this.variable = variable;
				
	}
	
	@Override
	public boolean close() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean read(Vector<String> arg0) {
		try {
            
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

           for (Iterator<String> iterator = arg0.iterator(); iterator.hasNext();) {
			outputStream.println((String) iterator.next());
           }
            
                
            
        } finally {
            
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
			return false;
		}
		
	}

	@Override
	public boolean write(Vector<String> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
