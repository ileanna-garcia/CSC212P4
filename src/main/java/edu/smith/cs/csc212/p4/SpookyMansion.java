package edu.smith.cs.csc212.p4;

import java.util.HashMap;
import java.util.Map;

/**
 * SpookyMansion, the game.
 * @author jfoley
 *
 */
public class SpookyMansion implements GameWorld {
	private Map<String, Thingy> Thingys = new HashMap<>();
	
	/**
	 * Where should the player start?
	 */
	@Override
	public String getStart() {
		return "entranceHall";
	}

	/**
	 * This constructor builds our SpookyMansion game.
	 */
	public SpookyMansion() {
		Thingy entranceHall = insert(
				Thingy.create("entranceHall", "You are in the grand entrance hall of a large building.\n"
						+ "The front door is locked. How did you get here?"));
		entranceHall.addClue(new Clue("basement", "There are stairs leading down."));
		entranceHall.addClue(new Clue("attic", "There are stairs leading up."));
		entranceHall.addClue(new Clue("kitchen", "There is a red door."));
		
		Thingy basement = insert(
				Thingy.create("basement", "You have found the basement of the mansion.\n" + 
		                           "It is darker down here.\n" +
						"You get the sense a secret is nearby, but you only see the stairs you came from."
						));
		basement.addClue(new Clue("entranceHall", "Let's go back up."));
		basement.addClue(new Clue("dungeon", "Let's look at our secret"));

		
		Thingy dungeon = insert( Thingy.create ("dungeon", "Why are there chains here? Oh no..This is a dungeon!" ));
		dungeon.addClue(new Clue("basement", "Let's go back to the basement this is creepy."));
		
		Thingy attic = insert(Thingy.create("attic",
				"Something rustles in the rafters as you enter the attic. Creepy.\n" + "It's big up here."));
		attic.addClue(new Clue("entranceHall", "There are stairs leading down."));
		attic.addClue(new Clue("attic2", "There is more through an archway"));
		attic.addClue(new Clue("attic3", "Looks like there's something here too"));

		Thingy attic2 = insert(Thingy.create("attic2", "There's definitely a bat in here somewhere.\n"
				+ "This part of the attic is brighter, so maybe you're safe here."));
		attic2.addClue(new Clue("attic", "There is more back through the archway"));
			
		
		Thingy attic3 = insert(Thingy.create("attic3", "There's some light here.\n" +"Looks like it's just a broken light."));
		attic3.addClue(new Clue("attic", "Let's go back through the archway."));
		
		Thingy kitchen = insert(Thingy.create("kitchen", "You've found the kitchen. You smell old food and some kind of animal."));
		kitchen.addClue(new Clue("entranceHall", "There is a red door."));
		kitchen.addClue(new Clue("dumbwaiter", "There is a dumbwaiter."));
		
		Thingy dumbwaiter = insert(Thingy.create("dumbwaiter", "You crawl into the dumbwaiter. What are you doing?"));
		dumbwaiter.addClue(new Clue("secretRoom", "Take it to the bottom."));
		dumbwaiter.addClue(new Clue("kitchen", "Take it to the middle-level."));
		dumbwaiter.addClue(new Clue("attic2", "Take it up to the top."));
		
		Thingy secretRoom = insert(Thingy.create("secretRoom", "You have found the secret room."));
		secretRoom.addClue(new Clue("hallway0", "There is a long hallway."));
		secretRoom.addClue(new Clue("basement", "What's this room on the left?"));
		
		
		
		int hallwayDepth = 6;
		int lastHallwayPart = hallwayDepth - 1;
		for (int i=0; i<hallwayDepth; i++) {
			Thingy hallwayPart = insert(Thingy.create("hallway"+i, "This is a very long hallway.\n" + "You turn to look at the wall and you see " + (i + 1)));
			if (i == 0) {
				hallwayPart.addClue(new Clue("secretRoom", "Go back."));
			} else {
				hallwayPart.addClue(new Clue("hallway"+(i-1), "Go back."));
			}
			if (i != lastHallwayPart) {
				hallwayPart.addClue(new Clue("hallway"+(i+1), "Go forward."));
			} else {
				hallwayPart.addClue(new Clue("crypt", "There is darkness ahead."));
			}
		}
		
		Thingy crypt = insert(Thingy.terminal("crypt", "You have found the crypt.\n"
				+"It is scary here, but there is an Clue to outside.\n"+
				"Maybe you'll be safe out there."));
		
		// Make sure your graph makes sense!
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
