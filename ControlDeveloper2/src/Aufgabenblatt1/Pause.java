package Aufgabenblatt1;

import hsrt.mec.controldeveloper.core.com.command.IPause;

public class Pause extends Command implements IPause {
	
	private double duration;
	public Pause(double duration) {
		setDuration(duration);
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public String toString() {
		return ("Pause		[Duration: "+ duration+ "]");
	}
	public String getName(){
		return this.toString();
	}

}
