package Chronometer;

public class OptimusCrono {
	boolean isRunning = false;
	
	public void playPause() {
		if (isRunning) {
			isRunning = false;
			System.out.println("Stopped");
		} else {
			isRunning = true;
			System.out.println("Running");
		}
	}
}
