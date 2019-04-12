package Aufgabenblatt1;

import hsrt.mec.controldeveloper.core.com.command.IGear;

public class Gear extends Command implements IGear {
	
	private int speed;
	private double duration;
	private final static int LIMMIN = -100;
	private final static int LIMMAX = 1000;
	
	public Gear(int speed, double duration) {
		setDuration(duration);
		setSpeed(speed);
	}
	
	
	public void setSpeed(int speed) {
		if (speed >= LIMMIN && speed <= LIMMAX) {
			this.speed = speed;
		}
		else {
			System.err.println("SpeedInput is out of Range: [" + LIMMIN + " to " + LIMMAX + "]");
			this.speed = 0;
			this.duration = 0;
		}
	}
	public int getSpeed() {
		return speed;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getDuration() {
		return duration;
	}
	
	
	public String toString() {
		return ("Gear 		[Speed:"+speed+ "/ Duration:"+duration+"]");
	}
	public String getName(){
		return this.toString();
	}
}
