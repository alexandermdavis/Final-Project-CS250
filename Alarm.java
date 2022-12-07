import java.util.Timer;
import java.util.TimerTask;

public class Alarm {
	int secondsPassed = 0;
	static int seconds = 0;
	
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask() {
		
	public void run() {
		secondsPassed++;
//		System.out.println("Seconds passed: " + secondsPassed);
		
			if(secondsPassed == seconds) {
				myTimer.cancel();
				System.out.println("");
				System.out.println("Your timer is up.");
			}
		}
	};

	public void start(int minutes) {
		seconds = minutes*60;
		myTimer.scheduleAtFixedRate(task, 1000, 1000);
	}
}
