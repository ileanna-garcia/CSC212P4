package edu.smith.cs.csc212.p4;

public class hotThingys extends Thingy {
	/**
	 * This initializes what hot and colddescriptions are
	 */
String hotDescription;
String coldDescription;

/**
 * creates the constructors for hot Thingys 
 */
	public hotThingys(String id, String hotDescription, boolean terminal, String coldDescription) {
		super(id, hotDescription,terminal);
		this.hotDescription = hotDescription;
		this.coldDescription = coldDescription;
	}
	
	/**
	 * This overrides the method print description into hot or coldtime
	 */
	@Override
	public String printDescription(GameTemperature temp){
		
		if(temp.isHot() == false) {
		return coldDescription;
	}
		else {
			return hotDescription;
		}
}
	/**
	 * This description is to change hot to coldif the exit isn't terminal
	 */	
	public static hotThingys create1(String id, String hotDescription, String coldDescription) {
		return new hotThingys(id, hotDescription, false, coldDescription);
	}

	/**
	 * This description is to change hot to coldif the exit is terminal
	 */
	public static hotThingys terminal1(String id, String hotDescription, String coldDescription) {
		return new hotThingys(id, hotDescription, true, coldDescription);
	}
}