package edu.smith.cs.csc212.p4;

public class GameTime {
	/**
	 * This initializes the hours
	 */
int hours ;

int finalHours;

/**
 * This is creating a constructor that allows 
 * for two parameters to be passed to GameTime
 */
	public GameTime (int hours, int finalHours) {

		this.hours = hours;
		this.finalHours = finalHours;
	
}
/**
 * This returns the hours that will be printed in a clock format
 * @return
 */
	public int getHour() {
		return hours;
}


/**
 * This returns the hours that will be display how long user was stuck
 * @return
 */
	public int getfinalHour() {
		return finalHours;
	
}

/**
 * This increases the hours and if the hours pass 
 * 23 then it restarts into another day
 * after the loop is done it'll display the time
 */
public void increaseHour() {
	hours +=1;
	if (hours > 23) {
		hours = 0;
		
	}
	System.out.print("It's currently " + (hours%24) + ":00\n");
	
}

/**
 * This increases final hour without any conditions stopping it
 */
public void increasefinalHour() {
	finalHours += 1;
}
/**
 * This increases hours by 2 if conditional is true to make it faster to night
 */
public void rest() {
	if(hours%5==0) {
	hours +=2;
	}
	
}

/**
 * This boolean checks if it's night or morning
 */

public boolean isNightTime() {
	
	if(hours%24 < 12) {
	return false;
	}
	else {
		
		return true;
	}
	
}

}



