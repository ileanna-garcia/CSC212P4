package edu.smith.cs.csc212.p4;

import java.util.List;

/**
 * I went to TA hours, talked to Kiara and Anabel for questions, and got code from Piazza.
 */

/**
 * This is our main class for P4. It interacts with a GameWorld and handles user-input.
 * @author jfoley
 *
 */
public class InteractiveFiction {

	/**
	 * This is where we play the game.
	 * @param args
	 */
	public static void main(String[] args) {
		// This is a text input source (provides getUserWords() and confirm()).
		TextInput input = TextInput.fromArgs(args);

		// This is the game we're playing.
		GameWorld game = new Henshaw();
		
		/**
		 * This is calling GameTime class 
		 */
		GameTime time = new GameTime(0, 0);
		/**
		 * This is calling GameTime class 
		 */
		GameTemperature temp = new GameTemperature(0, 0);
		
		// This is the current location of the player (initialize as start).
		// Maybe we'll expand this to a Player object.
		String Thingy = game.getStart();

		// Play the game until quitting.
		// This is too hard to express here, so we just use an infinite loop with breaks.
		while (true) {
			// Print the description of where you are.
			Thingy here = game.getThingy(Thingy);
			System.out.println(here.printDescription(temp));

			// Game over after print!
			if (here.isTerminalState()) {
				break;
			}

			// Show a user the ways out of this Thingy.
			List<Clue> Clues = here.getVisibleClues();
			
			for (int i=0; i<Clues.size(); i++) {
			    Clue e = Clues.get(i);
				System.out.println(" ["+i+"] " + e.getDescription());
			}
			
			// Figure out what the user wants to do, for now, only "quit" is special.
			List<String> words = input.getUserWords(">");
			if (words.size() == 0) {
				System.out.println("Must type something!");
				continue;
			} else if (words.size() > 1) {
				System.out.println("Only give me 1 word at a time!");
				continue;
			}
			
			// Get the word they typed as lowercase, and no spaces.
			String action = words.get(0).toLowerCase().trim();
			
				
			if (action.equals("quit")) {
				if (input.confirm("Are you sure you want to quit?")) {
					break;
				} else {
					continue;
				}
			}
			/**
			 * This will help us find a secret Clue 
			 */
			else if(action.equals("search")) {
				here.search();
				}
			else {
				Integer ClueNum = null;
				try {
					ClueNum = Integer.parseInt(action);
				} catch (NumberFormatException nfe) {
					System.out.println("That's not something I understand! Try a number!");
					continue;
				}
				
				if (ClueNum < 0 || ClueNum > Clues.size()) {
					System.out.println("I don't know what to do with that number!");
					continue;
				}

				// Move to the room they indicated.
				Clue destination = Clues.get(ClueNum);
				Thingy = destination.getTarget();

			}	
		
	
			// From here on out, what they typed better be a number!
			/**
			 * This is allowing for the method to keep looping inside this while-loop and changing the hour
			 */
			time.increaseHour();
			/**
			 * This is allowing for the method to keep looping inside this while-loop and adding to final hours
			 */
			time.increasefinalHour();
			/**
			 * Every time hours are divisible by 5 we forward the time 2 hours.
			 */
			time.rest();
			// From here on out, what they typed better be a number!
			/**
			 * This is allowing for the method to keep looping inside this while-loop and changing the hour
			 */
			temp.increaseDegree(time);
			/**
			 * This is allowing for the method to keep looping inside this while-loop and adding to final hours
			 */
			temp.increasefinalDegree();
			/**
			 * Every time hours are divisible by 5 we forward the time 2 hours.
			*/
			temp.rest();
			temp.deathTemp();
		
		}
		
		// You get here by "quit" or by reaching a Terminal Thingy.
		System.out.println(">>> GAME OVER <<<");
		/**
		 * This is going to print out how many hours you were stuck
		 */
		System.out.println("YOU WERE TRAPPED FOR " + time.getfinalHour() +" HOURS.");
		/**
		 * This is going to print out how hot it was when you escaped.
		 */
		System.out.println("IT IS " + temp.getfinalDegree() +"FAHRENHEIT");
	}

}
