package edu.smith.cs.csc212.p4;

public class SecretExit extends Exit {
	/**
	 * Private boolean hidden starts off as true so we can see if it's true
	 */
	private boolean hidden = true; 
	
	/**
	 * creates constructor for SecretExit
	 * @param target
	 * @param description
	 */
	public SecretExit(String target, String description) {
		super(target, description);
	}
	/**
	 * (non-Javadoc) true/false if the exit is a secret
	 * @see edu.smith.cs.csc212.p4.Exit#isSecret()
	 */
	public boolean isSecret() {
		return hidden;
	}
	/**when the user enters search hidden is false so user can see exit
	 * (non-Javadoc)
	 * @see edu.smith.cs.csc212.p4.Exit#search()
	 */
	public void search() {
		hidden = false;
			
		}
	
	}
	
	

