package baitap_04;

public class CTivi {
	private String[] channelList;   // contains a list of all channels
	private boolean isOn;             // status of tivi is on
	private String currentChannel;    // the current channel is on
	
	public CTivi() {
		channelList = new String[] {"VTV1", "VTV2","VTV3"};
		isOn = false;
		currentChannel = "VTV1";
	}

	public CTivi(String[] channelList) {
		this.channelList = channelList;
		isOn = false;
		currentChannel = channelList[0];      //currentChannel is the first channel in  channelList 
	}
	
	private String searchNextChannel(boolean isForward) {  // if the parameter isForward = true, then return next channel of the current channel. By contrast, return the forward channel of the current channel
		int currentIndex = -1;               // this variable shows the index position of current channel in the list
		for (int i = 0; i<channelList.length; i++) {                 // finding the position of current channel in the list
			if(channelList[i].equalsIgnoreCase(currentChannel)) {
				currentIndex = i;
				break;
			}
		}
		if(isForward) {           // isForward = true -> return the next channel
			currentIndex++;
			if(currentIndex>=channelList.length) {      // current channel is at the end of the list -> return the first channel in the list
				currentIndex = 0;
			}
		}
		else {
			currentIndex--;      // isForward = false -> return the forward channel
			if(currentIndex<0) {
				currentIndex = channelList.length-1;    // move the currentChannel to the channel at the end of the list
			}
		}
		currentChannel = channelList[currentIndex];   // move currentChannel to the next/forward channel and then return it
	    return currentChannel;
	}
	
	public void On() {
		isOn = true;
		System.out.println("-------------- Tivi ON ----------------");
	}
	
	public void Off() {
		isOn = false;
		System.out.println("-------------- Tivi OFF ---------------");
	}
	
	public void Switch() {   // switch status of Tivi on->off and off->on
		if(isOn) {
			Off();
		}else {
			On();
		}
	}
	
	public void Switch(String channel) {
		Switch();   // switch the status of tivi
		if(isOn) {
			boolean isFind = false;
			for(int i=0; i<channelList.length; i++) {
				if(channelList[i].equalsIgnoreCase(channel)) {
					isFind = true;
					break;
				}
			}
			if(isFind) {
				currentChannel = channel;
				System.out.println("imported channel is found: " + channel);
			}
			else {
				System.out.println("imported channel isn't found: " + channel);
			}
		}
	}
	
	public void nextChannel() {   // move to the next channel
		if(isOn) {            // Tivi is on
			searchNextChannel(true);
			System.out.println("Current channel: " + currentChannel);
		}
	}
	public void previousChannel() {    // move back to the previous channel
		if(isOn) {                     // Tivi is on
			searchNextChannel(false);
			System.out.println("Current channel: " + currentChannel);
		}
	}
	
	public void show() {
		if(isOn) {
			System.out.printf("------------ Tivi is ON at Channel: %s ---------------", currentChannel);
			System.out.println("");
		}else {
			System.out.println("---------------- Tivi now OFF ---------------------");
		}
	}

}
