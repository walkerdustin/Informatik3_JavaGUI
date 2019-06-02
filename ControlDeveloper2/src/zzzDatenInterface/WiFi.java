package zzzDatenInterface;

import java.util.Vector;

import hsrt.mec.controldeveloper.core.com.WiFiCard;
import hsrt.mec.controldeveloper.io.IOType;

public class WiFi implements IOType {
	private WiFiCard card;

	public WiFi(WiFiCard card) {
		this.card = card;
	}

	@Override
	public boolean close() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean read(Vector<String> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean write(Vector<String> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
