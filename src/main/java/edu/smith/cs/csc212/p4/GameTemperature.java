package edu.smith.cs.csc212.p4;

public class GameTemperature {
	/**
	 * This initializes the Degrees
	 */
int Degrees ;

int finalDegrees;

/**
 * This is creating a constructor that allows 
 * for two parameters to be passed to GameTemperature
 */
	public GameTemperature (int Degrees, int finalDegrees) {

		this.Degrees = Degrees;
		this.finalDegrees = finalDegrees;
	
}
/**
 * This returns the Degrees that will be printed in a clock format
 * @return
 */
	public int getDegree() {
		return Degrees;
}


/**
 * This returns the Degrees that will be display how long user was stuck
 * @return
 */
	public int getfinalDegree() {
		return finalDegrees;
	
}

/**
 * This increases the Degrees and if the Degrees pass 
 * 23 then it restarts into another day
 * after the loop is done it'll display the Temperature
 */
public void increaseDegree(GameTime time) {
	Degrees +=1;
	System.out.println("It's currently " + Degrees +" degree fahrenheit");
	if (time.getHour() % 2 == 0 ) {
		Degrees += 2;
	}
	
}

/**
 * This increases final Degree without any conditions stopping it
 */
public void increasefinalDegree() {
	finalDegrees += 1;
}
/**
 * This increases Degrees by 2 if conditional is true to make it faster to night
 */
public void rest() {
	if(Degrees % 5 == 0) {
	Degrees +=30;
	}
	
}

/**
 * This boolean checks if it's night or morning
 */

public boolean isHot() {
	
	if(Degrees < 100) {
	return false;
	}
	else {
		
		return true;
	}
	}
public void deathTemp() {
	while(Degrees >= 250) {
		if(Degrees == 250) {
			break;	
		}
}
	
	
}

}



