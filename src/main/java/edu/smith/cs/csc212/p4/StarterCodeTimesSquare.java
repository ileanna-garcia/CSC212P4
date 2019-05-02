package edu.smith.cs.csc212.p4;

import java.util.HashMap;
import java.util.Map;

/**
 * Escape, the game.
 * @author jfoley
 * Remodeled by Kayahma Brown, Kiara Correa Acosta, Ileanna Garcia
 */


public class StarterCodeTimesSquare implements GameWorld {
	private Map<String, Thingy> Thingys = new HashMap<>();
	
/**
 * Where should the player start?
 */
	
	@Override
	public String getStart() {
		return "turnstile";
	}
	
	/**
	 * This constructor builds our Escape game.
	 */

	public StarterCodeTimesSquare() {
		
		Thingy turnstile = insert(
				Thingy.create("turnstile", "You have just entered Times Square train station.\n" 
						+ "You have to catch the fastest train out of the city. Where do you want to go?"));
		turnstile.addClue(new Clue("Kinkyboots", "You follow the poster of Kinky Boots."));
		turnstile.addClue(new Clue("The Umbrella Academy", "You follow the billboard of The Umbrella Academy."));
		
		
		Thingy Kinkyboots = insert(
				Thingy.create("Kinkyboots", "You're heading towards the N,Q,R train" +
		                           "It looks kind of packed, but what train station isn't.\n" +
						"You get the sense a secret is nearby, but you only see the stairs you came from."
						));
		Kinkyboots.addClue(new Clue("Rats", "You head further down to the end of the platform to wait because it's the shortest route home, but then you are faced with a swarm of rats.\n"));
		Kinkyboots.addClue(new Clue("turnstile","Go back to where you started!"));
		
		Thingy Rats= insert(Thingy.terminal("Rats","The rats eat you!"));
		
		Thingy TheUmbrellaAcademy = insert(Thingy.create("The Umbrella Academy",
				"You continue to walk down the long vibrant tunnel."));
		TheUmbrellaAcademy.addClue(new Clue("turnstile", "You head back to the the turnstile."));
		TheUmbrellaAcademy.addClue(new Clue("TheMusic", "You head towards the sound of music a couple feet forward. "));
		
		Thingy TheMusic = insert(Thingy.create("TheMusic", "You watch the struggling musician play their spin on Old MacDonald."));
		TheMusic.addClue(new Clue("Tunnel", "Continue down the tunnel to the sound of opera."));
		
		Thingy Tunnel = insert(Thingy.create("Tunnel", " At the end of the tunnel you see an escalator and head down."));
		Tunnel.addClue(new Clue("Head_Left", "Make a Left"));
		Tunnel.addClue(new Clue("Head_Right", "Make a Right"));
		
		Thingy Head_Left= insert(Thingy.terminal("Head_Left","You are faced with a beautiful mural that cosequently collapses and suffocates you.:(."));

		Thingy Head_Right= insert(Thingy.create("Head_Right","You make a right and are faced with two hallways."));
		Head_Right.addClue(new Clue("hallway0", "There is a long hallway."));
		Head_Right.addClue(new Clue("hallway1", "There is an equally long hallway."));
		
		Thingy hallway0= insert(Thingy.terminal("hallway0", "You decide it's too long and turn back around:)\n"));
		Thingy hallway1=insert(Thingy.create("hallway1","You hear another train approaching the platform"));
		hallway1.addClue(new Clue("Train","You see the lights of an incoming train."));
		
		Thingy Train = insert(Thingy.terminal("Train", "You see the A,C,& E train and the small crowd and no delays! You head home :) \n "));
				
		
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


