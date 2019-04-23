package edu.smith.cs.csc212.p4;

public class SecretClue extends Clue {
	/**
	 * Private boolean hidden starts off as true so we can see if it's true
	 */
	private boolean hidden = true; 
	
	/**
	 * creates constructor for SecretClue
	 * @param target
	 * @param description
	 */
	public SecretClue(String target, String description) {
		super(target, description);
	}
	/**
	 * (non-Javadoc) true/false if the Clue is a secret
	 * @see edu.smith.cs.csc212.p4.Clue#isSecret()
	 */
	public boolean isSecret() {
		return hidden;
	}
	/**when the user enters search hidden is false so user can see Clue
	 * (non-Javadoc)
	 * @see edu.smith.cs.csc212.p4.Clue#search()
	 */
	public void search() {
		hidden = false;
			
		}
	
	}
	
	

