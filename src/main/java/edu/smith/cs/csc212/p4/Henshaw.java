package edu.smith.cs.csc212.p4;
import java.util.HashMap;
import java.util.Map;

//followed the SpookyMansion code in order to create our own world

public class Henshaw implements GameWorld {
	private Map<String, Place> places = new HashMap<>();
	
	/**
	 * Where should the player start?
	 */
	@Override
	public String getStart() {
		return "frontdoor";
	}
	
	public Henshaw() {
		/**
		 * adds regular place and exit with no night descriptions
		 */
		Place FrontDoor = insert( Place.create("frontdoor", ("You've entered Henshaw's Halls.\n" + "This place looks a bit haunting. Where should I go to escape?")));
		FrontDoor.addExit(new Exit("topfloor", "There's something flickering up there."));
		FrontDoor.addExit(new Exit("basement", "It's pitch dark down there."));

		/**
		 * adds regular place and exit with no night descriptions
		 */
		Place TopFloor = insert( Place.create("topfloor", "We're on the top floor. \n" + "Looks like there's a noise coming from one of the rooms."));
		TopFloor.addExit(new Exit("frontdoor","I'm going back down."));
		TopFloor.addExit(new Exit("tvstudio", "Looks like there's a light coming from the tv studio?"));
		TopFloor.addExit(new Exit("techroom", "Wait.. there's a noise over there in the tech room."));
		TopFloor.addExit(new Exit("bathroom", "Actually, I need to use the bathroom."));
		/**
		 * adds regular place and exit with no night descriptions
		 */
		Place TVStudio = insert( Place.create("tvstudio", "Seems like someone left the TV on here in the studio."));
		TVStudio.addExit(new Exit("topfloor", "I found the control and turned it off so I'll just go back."));
		TVStudio.addExit(new Exit("techroom", "Wait.. there's a noise over there in the tech room."));
		
		/**
		 * adds regular place and secretexit with no night descriptions
		 */
		Place TechRoom = insert( Place.create("techroom", "I really hope I don't break anything in the tech room, it's really dark.\n" + 
												"Woah this laptop is blaring music... Who's here?"));
		TechRoom.addExit(new Exit("tvstudio", "Looks like the tv turned back on. I should check it out."));
		TechRoom.addExit(new SecretExit("bathroom", "Actually, I need to use the bathroom."));
		/**
		 * adds regular place and exit with night descriptions
		 */
		NightPlaces Bathroom = (NightPlaces) insert( NightPlaces.create1("bathroom", "Just your standard haunted nighttime bathroom with a random locked door isn't it?", 
				"This morning I woke up with such a big need to pee I might as well stay here."));
		Bathroom.addExit(new Exit("bathroom", "WHY IS THE DOOR LOCKED??!!? I CAN'T GET OUT!"));
		Bathroom.addExit(new Exit("henshawkiller", "Hello? I thought I was alone?"));
		/**
		 * adds regular place and exit with night descriptions
		 */
		NightPlaces Henshawkiller = (NightPlaces) insert(	NightPlaces.terminal1("henshawkiller", "You have found the Henshaw Killer and failed to escape.\n"
				+"Say your last goodnight loser","You have found the Henshaw Killer and failed to escape.\n" + "Say your last goodmornings loser"));
		/**
		 * adds regular place and exit with no night descriptions
		 */
		Place Basement = insert( Place.create("basement", "It's really dark in this basement I'm not too sure I'll find anything"));
		Basement.addExit(new Exit("frontdoor" , "I'm going back up."));
		Basement.addExit(new Exit("secretroom", "This room is creepy what is it?"));
		Basement.addExit(new Exit("soundproof", "Why can I hear something from a soundproof room?\n" +
									"Let's explore!"));
		Basement.addExit(new Exit("confrenceroom", "Is there coffee here?\n" + "I guess so since it is a confrence room."));
		/**
		 * adds regular place and exit with no night descriptions
		 */
		Place SecretRoom = insert(Place.create("secretroom", "I dont think this is in the floor plan."));
		SecretRoom.addExit(new Exit("basement", "I'm freaking scared I'm going back"));
		SecretRoom.addExit(new Exit("quad", "Wait.. this door can lead me somewhere."));
		SecretRoom.addExit(new Exit("bathroom", "A staircase? Whaaaaat?"));
		/**
		 * adds regular place and exit with no night descriptions
		 */
		Place SoundProof = insert( Place.create("soundproof", "If I get trapped in the soundproof room I think no one will hear me."));
		SoundProof.addExit(new Exit("soundproof", "The door locked behind me and this other door won't open.\n" + 
		"I think I'm trapped here."));
		/**
		 * adds regular place and secretexit with no night descriptions
		 */		
		Place ConfrenceRoom = insert( Place.create("confrenceroom", "WHY ARE ALL MY PROFESSORS HERE?"));
		ConfrenceRoom.addExit(new Exit("soundproof", "Wait.. this door is the closest to get out."));
		ConfrenceRoom.addExit(new SecretExit("quad", "The farthest door has a shiny doorknob I. MUST. TOUCH."));
		/**
		 * adds regular place and exit with night descriptions
		 */
		NightPlaces quad = (NightPlaces) insert(NightPlaces.create1("quad", "The moons reflection is shining.", "I think I smell pancakes from Cutter?"));
		quad.addExit(new Exit("outside", "\"WOOOOOOOOOOO I OPENED IT (after too many tries)."));
		/**
		 * adds regular place and exit with night descriptions
		 */
		NightPlaces outside = (NightPlaces) insert(NightPlaces.terminal1("outside", "You have found the exit at night.\n"
				+"You win!" , "Seems like it's morning but you found the exit.\n" + "You win"));
		
		
		
		checkAllExitsGoSomewhere();
	}
	
		/**
	 * This helper method saves us a lot of typing. We always want to map from p.id
	 * to p.
	 * 
	 * @param p - the place.
	 * @return the place you gave us, so that you can store it in a variable.
	 */
	private Place insert(Place p) {
		places.put(p.getId(), p);
		return p;
	}

	/**
	 * I like this method for checking to make sure that my graph makes sense!
	 */
	private void checkAllExitsGoSomewhere() {
		boolean missing = false;
		// For every place:
		for (Place p : places.values()) {
			// For every exit from that place:
			for (Exit x : p.getVisibleExits()) {
				// That exit goes to somewhere that exists!
				if (!places.containsKey(x.getTarget())) {
					// Don't leave immediately, but check everything all at once.
					missing = true;
					// Print every exit with a missing place:
					System.err.println("Found exit pointing at " + x.getTarget() + " which does not exist as a place.");
				}
			}
		}
		
		// Now that we've checked every exit for every place, crash if we printed any errors.
		if (missing) {
			throw new RuntimeException("You have some exits to nowhere!");
		}
	}

	/**
	 * Get a Place object by name.
	 */
	public Place getPlace(String id) {
		return this.places.get(id);		
	}
}


