package Aufgabenblatt1;

import hsrt.mec.controldeveloper.core.com.command.IPause;

public class Pause extends Command implements IPause {
	
	private double duration;
	public Pause() {
		setDuration(0);
		System.out.println("Pause wurde standartm‰ﬂig mit 0 initialisiert");
	}
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
		return ("Pause * "+duration);
	}
	public String getName(){
		return this.toString();
	}

}
