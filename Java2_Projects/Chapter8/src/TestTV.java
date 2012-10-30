
public class TestTV {

	public static void main(String[] args) {
		// Create a new TV 1
		TV tv1 = new TV();
		tv1.turnOn();
		tv1.setChannel(30);
		tv1.setVolume(3);
		
		// Create a new TV 2
		TV tv2 = new TV();
		tv2.turnOn();
		tv2.channelUp();
		tv2.channelUp();
		tv2.volumeUp();
		
		//Display TV1 & TV2 settings
		System.out.println("tv1's channel is " + tv1.channel 
				+ " and volume level is " + tv1.volumeLevel);
		System.out.println("tv2's channel is " + tv2.channel 
				+ " and volume level is " + tv2.volumeLevel);
	}
}
