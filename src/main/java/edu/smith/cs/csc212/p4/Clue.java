package edu.smith.cs.csc212.p4;

import java.util.Objects;

/**
 * This class represents an Clue from a Place to another Place.
 * @author jfoley
 *
 */
public class Clue {
	/**
	 * How do we describe this Clue to a user, e.g., "A door with a spiderweb."
	 */
	private String description;
	/**
	 * How do we identify the Place that this is going.
	 */
	private String target;
	
	
	/**
	 * Clues that are secret are displayed if they are searched for
	 */
	
	public boolean isSecret() {

		return false;
		}
	
	/**
	 * You can make a method getSecret() within the Clue class and have it return 
	 * the hidden variable, and then use the method to check from other classes?
	 */
	

	/**
	 * Create a new Clue.
	 * @param target - where it goes.
	 * @param description - how it looks.
	 */
	public Clue(String target, String description) {
		this.description = description;
		this.target = target;
	}
	
	/**
	 * A getter for the description of this Clue.
	 * @return how it looks.
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * A getter for the target place of this Clue.
	 * @return where it goes.
	 */
	public String getTarget() {
		return this.target;
	}
	
	/**
	 * Make this debuggable when we print it for ourselves.
	 */
	public String toString() {
		return "Clue("+this.description+", "+this.target+")";
	}
	
	/**
	 * Make it so we can put this in a HashMap or HashSet.
	 */
	public int hashCode() {
		return Objects.hash(this.description, this.target);
	}
	
	/**
	 * This is a useful definition of being the same.
	 * @param other - another Clue.
	 * @return if they go to the same place.
	 */
	public boolean goesToSamePlace(Clue other) {
		return this.target.equals(other.target);
	}
	
	/**
	 * The other half of hashCode that lets us put it in a HashMap or HashSet.
	 */
	public boolean equals(Object other) {
		if (other instanceof Clue) {
			Clue rhs = (Clue) other;
			return this.target.equals(rhs.target) && this.description.equals(rhs.description); 
		}
		return false;
	}
	public void search() {
		
	}
}
