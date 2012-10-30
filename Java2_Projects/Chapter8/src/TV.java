
public class TV {

	int channel = 1; //Default channel is 1
	int volumeLevel = 1; //Default volume is 1
	private boolean isON = false; //Default the TV is OFF
	
	public TV(){
		
	}
	
	public void turnOn(){
		isON = true;
	}
	
	public void turnOff(){
		isON = false;
	}
	
	public void setChannel(int newChannel){
		if (isON && newChannel >= 1 && newChannel <= 120){
			channel = newChannel;
		}
	}
	
	public void setVolume(int newVolumeLevel){
		if (isON && newVolumeLevel >= 1 && newVolumeLevel <= 7){
			volumeLevel = newVolumeLevel;
		}
	}
	
	public void channelUp(){
		if (isON && channel < 120){
			channel++;
		}
	}
	
	public void channelDown(){
		if (isON && channel > 1){
			channel--;
		}
	}
	
	public void volumeUp(){
		if (isON && volumeLevel < 7){
			volumeLevel++;
		}
	}
	
	public void volumeDown(){
		if (isON && volumeLevel > 1){
			volumeLevel--;
		}
	}
}
