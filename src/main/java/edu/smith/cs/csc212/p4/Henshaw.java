package edu.smith.cs.csc212.p4;
import java.util.HashMap;
import java.util.Map;

//followed the SpookyMansion code in order to create our own world

public class Henshaw implements GameWorld {
	private Map<String, Thingy> Thingys = new HashMap<>();
	
	/**
	 * Where should the player start?
	 */
	@Override
	public String getStart() {
		return "frontdoor";
	}
	
	public Henshaw() {
		/**
		 * adds regular Thingy and Clue with no hot descriptions
		 */
		Thingy FrontDoor = insert( Thingy.create("frontdoor", ("You've entered Henshaw's Halls.\n" + "This Thingy looks a bit haunting. Where should I go to escape?")));
		FrontDoor.addClue(new Clue("topfloor", "There's something flickering up there."));
		FrontDoor.addClue(new Clue("basement", "It's pitch dark down there."));

		/**
		 * adds regular Thingy and Clue with no hot descriptions
		 */
		Thingy TopFloor = insert( Thingy.create("topfloor", "We're on the top floor. \n" + "Looks like there's a noise coming from one of the rooms."));
		TopFloor.addClue(new Clue("frontdoor","I'm going back down."));
		TopFloor.addClue(new Clue("tvstudio", "Looks like there's a light coming from the tv studio?"));
		TopFloor.addClue(new Clue("techroom", "Wait.. there's a noise over there in the tech room."));
		TopFloor.addClue(new Clue("bathroom", "Actually, I need to use the bathroom."));
		/**
		 * adds regular Thingy and Clue with no hot descriptions
		 */
		Thingy TVStudio = insert( Thingy.create("tvstudio", "Seems like someone left the TV on here in the studio."));
		TVStudio.addClue(new Clue("topfloor", "I found the control and turned it off so I'll just go back."));
		TVStudio.addClue(new Clue("techroom", "Wait.. there's a noise over there in the tech room."));
		
		/**
		 * adds regular Thingy and secretClue with no hot descriptions
		 */
		Thingy TechRoom = insert( Thingy.create("techroom", "I really hope I don't break anything in the tech room, it's really dark.\n" + 
												"Woah this laptop is blaring music... Who's here?"));
		TechRoom.addClue(new Clue("tvstudio", "Looks like the tv turned back on. I should check it out."));
		TechRoom.addClue(new SecretClue("bathroom", "Actually, I need to use the bathroom."));
		/**
		 * adds regular Thingy and Clue with hot descriptions
		 */
		hotThingys Bathroom = (hotThingys) insert( hotThingys.create1("bathroom", "Just your standard haunted hottime bathroom with a random locked door isn't it?", 
				"This morning I woke up with such a big need to pee I might as well stay here."));
		Bathroom.addClue(new Clue("bathroom", "WHY IS THE DOOR LOCKED??!!? I CAN'T GET OUT!"));
		Bathroom.addClue(new Clue("henshawkiller", "Hello? I thought I was alone?"));
		/**
		 * adds regular Thingy and Clue with hot descriptions
		 */
		hotThingys Henshawkiller = (hotThingys) insert(	hotThingys.terminal1("henshawkiller", "You have found the Henshaw Killer and failed to escape.\n"
				+"Say your last goodhot loser","You have found the Henshaw Killer and failed to escape.\n" + "Say your last goodmornings loser"));
		/**
		 * adds regular Thingy and Clue with no hot descriptions
		 */
		Thingy Basement = insert( Thingy.create("basement", "It's really dark in this basement I'm not too sure I'll find anything"));
		Basement.addClue(new Clue("frontdoor" , "I'm going back up."));
		Basement.addClue(new Clue("secretroom", "This room is creepy what is it?"));
		Basement.addClue(new Clue("soundproof", "Why can I hear something from a soundproof room?\n" +
									"Let's explore!"));
		Basement.addClue(new Clue("confrenceroom", "Is there coffee here?\n" + "I guess so since it is a confrence room."));
		/**
		 * adds regular Thingy and Clue with no hot descriptions
		 */
		Thingy SecretRoom = insert(Thingy.create("secretroom", "I dont think this is in the floor plan."));
		SecretRoom.addClue(new Clue("basement", "I'm freaking scared I'm going back"));
		SecretRoom.addClue(new Clue("quad", "Wait.. this door can lead me somewhere."));
		SecretRoom.addClue(new Clue("bathroom", "A staircase? Whaaaaat?"));
		/**
		 * adds regular Thingy and Clue with no hot descriptions
		 */
		Thingy SoundProof = insert( Thingy.create("soundproof", "If I get trapped in the soundproof room I think no one will hear me."));
		SoundProof.addClue(new Clue("soundproof", "The door locked behind me and this other door won't open.\n" + 
		"I think I'm trapped here."));
		/**
		 * adds regular Thingy and secretClue with no hot descriptions
		 */		
		Thingy ConfrenceRoom = insert( Thingy.create("confrenceroom", "WHY ARE ALL MY PROFESSORS HERE?"));
		ConfrenceRoom.addClue(new Clue("soundproof", "Wait.. this door is the closest to get out."));
		ConfrenceRoom.addClue(new SecretClue("quad", "The farthest door has a shiny doorknob I. MUST. TOUCH."));
		/**
		 * adds regular Thingy and Clue with hot descriptions
		 */
		hotThingys quad = (hotThingys) insert(hotThingys.create1("quad", "The moons reflection is shining.", "I think I smell pancakes from Cutter?"));
		quad.addClue(new Clue("outside", "\"WOOOOOOOOOOO I OPENED IT (after too many tries)."));
		/**
		 * adds regular Thingy and Clue with hot descriptions
		 */
		hotThingys outside = (hotThingys) insert(hotThingys.terminal1("outside", "You have found the Clue at hot.\n"
				+"You win!" , "Seems like it's morning but you found the Clue.\n" + "You win"));
		
		
		
		checkAllCluesGoSomewhere();
	}
	
		/**
	 * This helper method saves us a lot of typing. We always want to map from p.id
	 * to p.
	 * 
	 * @param p - the Thingy.
	 * @return the Thingy you gave us, so that you can store it in a variable.
	 */
	private Thingy insert(Thingy p) {
		Thingys.put(p.getId(), p);
		return p;
	}

	/**
	 * I like this method for checking to make sure that my graph makes sense!
	 */
	private void checkAllCluesGoSomewhere() {
		boolean missing = false;
		// For every Thingy:
		for (Thingy p : Thingys.values()) {
			// For every Clue from that Thingy:
			for (Clue x : p.getVisibleClues()) {
				// That Clue goes to somewhere that exists!
				if (!Thingys.containsKey(x.getTarget())) {
					// Don't leave immediately, but check everything all at once.
					missing = true;
					// Print every Clue with a missing Thingy:
					System.err.println("Found Clue pointing at " + x.getTarget() + " which does not exist as a Thingy.");
				}
			}
		}
		
		// Now that we've checked every Clue for every Thingy, crash if we printed any errors.
		if (missing) {
			throw new RuntimeException("You have some Clues to nowhere!");
		}
	}

	/**
	 * Get a Thingy object by name.
	 */
	public Thingy getThingy(String id) {
		return this.Thingys.get(id);		
	}
}


