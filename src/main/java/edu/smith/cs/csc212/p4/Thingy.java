package edu.smith.cs.csc212.p4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This represents a Thingy in our text adventure.
 * @author jfoley
 *
 */
public class Thingy {
	/**
	 * This is a list of Clues we can get to from this Thingy.
	 */
	private List<Clue> Clues;
	
	/**
	 * This is the identifier of the Thingy.
	 */
	private String id;
	/**
	 * What to tell the user about this Thingy.
	 */
	private String description;
	/**
	 * Whether reaching this Thingy ends the game.
	 */
	private boolean terminal;
	
	/**
	 * Empty array used to store clues
	 */
	
	
	/**
	 * Internal only constructor for Thingy. Use {@link #create(String, String)} or {@link #terminal(String, String)} instead.
	 * @param id - the internal id of this Thingy.
	 * @param description - the user-facing description of the Thingy.
	 * @param terminal - whether this Thingy ends the game.
	 */
	public Thingy(String id, String description, boolean terminal) {
		this.id = id;
		this.description = description;
		this.Clues = new ArrayList<>();
		this.terminal = terminal;
	}
	
	/**
	 * Create an Clue for the user to navigate to another Thingy.
	 * @param Clue - the description and target of the other Thingy.
	 */
	public void addClue(Clue Clue) {
		this.Clues.add(Clue);
	}
	
	/**
	 * For gameplay, whether this Thingy ends the game.
	 * @return true if this is the end.
	 */
	public boolean isTerminalState() {
		return this.terminal;
	}
	
	/**
	 * The internal id of this Thingy, for referring to it in {@link Clue} objects.
	 * @return the id.
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * The narrative description of this Thingy.
	 * Implementing GameTime in order to know whether it is day or night to print a certain description
	 * @return what we show to a player about this Thingy.
	 */
	public String printDescription(GameTemperature temp) {
		return this.description;
		
	}

	/**
	 * Get a view of the Clues from this Thingy, for navigation. 
	 * This code was gotten from JJ on Piazza
	 * @return all the Clues from this Thingy.
	 */
	public List<Clue> getVisibleClues() {
		  List<Clue> output = new ArrayList<>();
		  for (Clue e : this.Clues) {
		    if (e.isSecret() != true) {
		    output.add(e);
		    }
		}
		return output;
	}
	/**
	 * This is a terminal location (good or bad).
	 * @param id - this is the id of the Thingy (for creating {@link Clue} objects that go here).
	 * @param description - this is the description of the Thingy.
	 * @return the Thingy object.
	 */
	public static Thingy terminal(String id, String description) {
		return new Thingy(id, description, true);
	}
	
	/**
	 * Create a Thingy with an id and description.
	 * @param id - this is the id of the Thingy (for creating {@link Clue} objects that go here).
	 * @param description - this is what we show to the user.
	 * @return the new Thingy object (add Clues to it).
	 */
	public static Thingy create(String id, String description) {
		return new Thingy(id, description, false);
	}
	
	/**
	 * Implements what we need to put Thingy in a HashSet or HashMap.
	 */
	public int hashCode() {
		return this.id.hashCode();
	}
	
	/**
	 * Give a string for debugging what Thingy is what.
	 */
	public String toString() {
		return "Thingy("+this.id+" with "+this.Clues.size()+" Clues.)";
	}
	
	/**
	 * Whether this is the same Thingy as another.
	 */
	public boolean equals(Object other) {
		if (other instanceof Thingy) {
			return this.id.equals(((Thingy) other).id);
		}
		return false;
	}
	
	/**
	 * JJ's code from Piazza
	 */
	public void search() {
		  for (Clue e : this.Clues) {
		    // search makes it not secret any more if it's a SecretClue!
		    e.search();
		  }
		}
	
}
