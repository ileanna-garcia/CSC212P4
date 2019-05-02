package edu.smith.cs.csc212.p4;


//This is the solution for Game Temperature. To implement it check the comments in InteractiveFiction.

public class GameTemperature {
	/**
	 * This initializes the Degrees
	 */
int Degrees ;


/**
 * This is creating a constructor that allows 
 * for one parameter to be passed to GameTemperature
 */
	public GameTemperature (int Degrees) {

		this.Degrees = Degrees;
	
}
/**
 * This returns the Degrees 
 * @return
 */
	public int getDegree() {
		return Degrees;
}


/**
 * This increases the Degrees but remember this temperature system is unique to this world
 */
public void increaseDegree(GameTime time) {
	Degrees +=1;
	System.out.println("It's currently " + Degrees +" degree newyorken.");
	if (time.getHour() % 2 == 0 ) {
		Degrees += 2;
	}
	
}

/**
 * This increases Degrees by 2 if conditional is true to make it faster to 250 degrees
 */
public void accelerate() {
	if(Degrees % 5 == 0) {
		Degrees += 30;
	}
	
}

/**
 * This boolean checks if it's too hot
 */

public boolean isHot() {
	
	if(Degrees < 80) {
		return false;
	}
	else {
		
		return true;
	}
}

/**
 * this breaks the game of degrees = 250
 */

public void deathTemp() {
	while(Degrees >= 250) {
		if(Degrees == 250) {
			break;	
		}
    }	
}

}



