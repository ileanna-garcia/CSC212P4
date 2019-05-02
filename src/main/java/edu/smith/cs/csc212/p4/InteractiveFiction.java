package edu.smith.cs.csc212.p4;

import java.util.ArrayList;
import java.util.List;

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
	
		GameWorld game = new StarterCodeTimesSquare();
		
		//Change to this so you can see how our solution of TimesSquare
		//GameWorld game = new TimesSquare();
		
// This is the solution for heating and time. For steps on how to get here do the to do's
//		/**
//		 * This is calling GameTime class 
//		 */
//		
//		GameTime time = new GameTime(0, 0);
//		
//		/**
//		 * This is calling GameTempertaure class 
//		 */
//		This cannot be commented out from starter code because then we cannot print the description
		GameTemperature temp = new GameTemperature(0);
		
		// This is the current location of the player (initialize as start).
		// Maybe we'll expand this to a Player object.
		String Thingy = game.getStart();

		//Creating an ArrayList that works as a backpack that saves the clues we've collected
		ArrayList<Clue> BackPack= new ArrayList<>();
		
		// Play the game until quitting.
		// This is too hard to express here, so we just use an infinite loop with breaks.
		while (true) {
							
			// Print the description of where you are.
			Thingy here = game.getThingy(Thingy);
			
//			This cannot be commented out from starter code because then we cannot print the description
			// The solution to get your temperature to work is the following. 
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
			if(action.equals("clues")) {
				System.out.println(BackPack);
			}
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
				
				} 
				catch (NumberFormatException nfe) {
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
				//Get clues we've collected along the way
				Clue e = Clues.get(ClueNum);
				BackPack.add(e);
			}	
		
//			This the solution for time and temperature. Review the to do's for steps on how to do it.
			// From here on out, what they typed better be a number!
//			/**
//			 * This is allowing for the method to keep looping inside this while-loop and changing the hour
//			 */
//			
//			time.increaseHour();
//			
//			/**
//			 * This is allowing for the method to keep looping inside this while-loop and adding to final hours
//			 */
//			
//			time.increasefinalHour();
//			
//			/**
//			 * Every time hours are divisible by 5 we forward the time 2 hours.
//			 */
//			
//			time.rest();
//			
//			/**
//			 * This is allowing for the method to keep looping inside this while-loop and changing the degree
//			 */
//			
//			temp.increaseDegree(time);
//			
//			/**
//			 * Every time hours are divisible by 5 we forward the degrees by 30.
//			*/
//			
//			temp.accelerate();
			
//			/**
//			 * update to check if you have reached 250 for the death time.
//			 */
//			temp.deathTemp();
			

		}
		
		// You get here by "quit" or by reaching a Terminal Thingy.
		System.out.println(">>> GAME OVER <<<");
//		This the solution for time and temperature and score. Review the to do's for steps on how to do it.
//      Other solutions for score are acceptable if they follow the rubric.
//		/**
//		 * This is going to print out how many hours you were stuck
//		 */
//		
//		System.out.println("YOU WERE TRAPPED FOR " + time.getfinalHour() +" HOURS.");
//		
//		/**
//		 * This is going to print out how hot it was when you escaped.
//		 */
//		
//		System.out.println("IT IS " + temp.getDegree() +" DEGREES NEWYORKEN.");
//		
//		/**
//		 * The total score will be calculated by subtracting the total number 
//		 * of moves we did (found by counting the size of our backpack)
//		 * from the highest possible score which is 100
//		 */
//		System.out.println("Your total score is: " + (100 - BackPack.size()));
		
	}

}
