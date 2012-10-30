import java.util.Date;


public class StopWatch {

	private Date startTime = new Date();
	private Date stopTime = new Date();

	public long getStartTime() {
		long startSeconds = startTime.getTime();
		return startSeconds;
	}

	public long getStopTime() {
		long stopSeconds = stopTime.getTime();
		return stopSeconds;
	}
	
	public StopWatch() {
		startTime = new Date();
	}
	
	public void start() {
		startTime = new Date();
	}
	
	public void stop() {
		stopTime = new Date();
	}
	
	public long getElapsedTime() {
		long elapsedTime = 0;
		elapsedTime = this.getStopTime() - this.getStartTime();
		return elapsedTime;
	}
	
	public double getElapsedTimeInSeconds() {
		double secondValue = 0.0;
		secondValue += Math.ceil(getElapsedTime() / 1000);
		return secondValue;
	}

	@Override
	public String toString() {
		return "StopWatch:\n\tStarted: \t" + startTime.toString() + 
				"\n\tStopped: \t" + stopTime.toString() + 
				"\n\tElasped time: \t" + getElapsedTime() + " milliseconds" +
				"\n\tIn seconds: \t" + getElapsedTimeInSeconds() + " milliseconds";
	}
}
