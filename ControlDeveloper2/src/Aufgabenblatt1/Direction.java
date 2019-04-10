package Aufgabenblatt1;

import hsrt.mec.controldeveloper.core.com.command.IDirection;

public class Direction extends Command implements IDirection {
	private int degree;
	private final static int LIMMIN = -90;
	private final static int LIMMAX =  90;
	
	public Direction(int degree) {
		setDegree(degree);		
	}
	
	public void setDegree(int degree) {
		if (degree >= LIMMIN && degree <= LIMMAX) {
			this.degree = degree;
		}
		else {
			System.err.println("DegreeInput is out of Range: [" + LIMMIN + " to " + LIMMAX + "]");
			this.degree = 0;
		}
	}
	
	public int getDegree() {
		return degree;
	}
	public String toString() {
		return ("Direction 	[Degree:"+degree+"]");
	}
	
	public String getName(){
		return this.toString();
	}

}
