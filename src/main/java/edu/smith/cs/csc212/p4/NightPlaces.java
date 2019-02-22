package edu.smith.cs.csc212.p4;

public class NightPlaces extends Place {
	/**
	 * This initializes what night and morning descriptions are
	 */
String nightDescription;
String morningDescription;

/**
 * creates the constructors for night places 
 */
	public NightPlaces(String id, String nightDescription, boolean terminal, String morningDescription) {
		super(id, nightDescription,terminal);
		this.nightDescription = nightDescription;
		this.morningDescription = morningDescription;
	}
	
	/**
	 * This overrides the method print description into night or morning time
	 */
	@Override
	public String printDescription(GameTime time){
		
		if(time.isNightTime() == false) {
		return morningDescription;
	}
		else {
			return nightDescription;
		}
}
	/**
	 * This description is to change night to morning if the exit isn't terminal
	 */	
	public static NightPlaces create1(String id, String nightDescription, String morningDescription) {
		return new NightPlaces(id, nightDescription, false, morningDescription);
	}

	/**
	 * This description is to change night to morning if the exit is terminal
	 */
	public static NightPlaces terminal1(String id, String nightDescription, String morningDescription) {
		return new NightPlaces(id, nightDescription, true, morningDescription);
	}
}