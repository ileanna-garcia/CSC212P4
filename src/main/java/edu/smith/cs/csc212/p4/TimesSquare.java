package edu.smith.cs.csc212.p4;

import java.util.HashMap;
import java.util.Map;

/**
 * Escape, the game.
 * @author jfoley
 *
 */
/**
 * All graphics were taken from asciiart.eu
 */
public class TimesSquare implements GameWorld {
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
	public TimesSquare() {
		Thingy turnstile = insert(
				Thingy.create("turnstile", "You have just entered Times Square train station.\n" 
						+ "You have to catch the fastest train out of the city. Where do you want to go?"));
		turnstile.addClue(new Clue("Kinkyboots", "You follow the poster of Kinky Boots."));
		turnstile.addClue(new Clue("The Umbrella Academy", "You follow the billboard of The Umbrella Academy."));
		
		
		Thingy Kinkyboots = insert(
				Thingy.create("Kinkyboots", "You're heading towards the N,Q,R train    "
						+ "_____                 . . . . . o o o o o\n" + 
						"  __|[_]|__ ___________ _______    ____      o\n" + 
						" |[] [] []| [] [] [] [] [_____(__  ][]]_n_n__][.\n" + 
						"_|________|_[_________]_[________]_|__|________)<\n" + 
						"  oo    oo 'oo      oo ' oo    oo 'oo 0000---oo\\_\n" + 
						" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.\n" + 
		                           "It looks kind of packed, but what train station isn't.\n" +
						"You get the sense a secret is nearby, but you only see the stairs you came from."
						));
		Kinkyboots.addClue(new Clue("BlaringHorn", "You contiue towards the Queens bound N train, only to see the train is delayed by 30 mins."+""
			  + "                     /|\n" + 
				"       =  =  =      / |\n" + 
				"  ____| || || |____/  | -_-_-_-_-_-_\n" + 
				"|)----| || || |____   |     AH\n" + 
				"  ((  | || || |  ))\\  | _-_-_-_-_-_-\n" + 
				"   \\\\_|_||_||_|_//  \\ |\n" + 
				"    \\___________/    \\|\n" + 
				""));
		Kinkyboots.addClue(new Clue("Rats", "You head further down to the end of the platform to wait because it's the shortest route home, but then you are faced with a swarm of rats./n"));
		Kinkyboots.addClue(new Clue("turnstile","Go back to where you started!"));
		
		Thingy Rats= insert(Thingy.terminal("Rats","The rats eat you!"+ ""
				+ "						  (\\,/)\n" + 
				"                            oo   '''//,        _\n" + 
				"                          ,/_;~,        \\,    / '\n" + 
				"                      \"'   \\    (    \\    !\n" + 
				"                                ',|  \\    |__.'\n" + 
				"                                '~  '~----''\n" + 
				""
				 ));
		Thingy BlaringHorn= insert(Thingy.terminal("BlaringHorn","The train runs you over."));
		
		Thingy TheUmbrellaAcademy = insert(Thingy.create("The Umbrella Academy",
				"You continue to walk down the long vibrant tunnel."));
		TheUmbrellaAcademy.addClue(new Clue("turnstile", "You head back to the the turnstile."));
		TheUmbrellaAcademy.addClue(new Clue("TheMusic", "You head towards the sound of music a couple feet forward. "));
		TheUmbrellaAcademy.addClue(new Clue("Maintinance Door", "You head into the maintance door."));
			
		Thingy Maintinance_Door= insert(Thingy.terminal("Maintinance Door","You are immediately faced with a sleeping janitor."+
				"            __________\n" + 
				"           |  __  __  |\n" + 
				"           | |  ||  | |\n" + 
				"           | |  ||  | |\n" + 
				"           | |__||__| |\n" + 
				"           |  __  __()|\n" + 
				"           | |  ||  | |\n" + 
				"           | |  ||  | |\n" + 
				"           | |  ||  | |\n" + 
				"           | |  ||  | |\n" + 
				"           | |__||__| |\n" + 
				"ejm        |__________|" ));
		
		
		Thingy TheMusic = insert(Thingy.create("TheMusic", "You watch the struggling musician play their spin on Old MacDonald."));
		TheMusic.addClue(new Clue("Tunnel", "Continue down the tunnel to the sound of opera."));
		TheMusic.addClue(new Clue("Beggar","You see an unemployed beggar in the corner. You head over to offer some help."));
		
		Thingy Beggar= insert(Thingy.terminal("Beggar","You walk away after giving them a chopped cheese and an arizona, only to find that you can't find your wallet./n"
				+ " You head up to the Police Station :("));
		
		Thingy Tunnel = insert(Thingy.create("Tunnel", " At the end of the tunnel you see an escalator and head down."));
		Tunnel.addClue(new Clue("Head_Left", "Make a Left"));
		Tunnel.addClue(new Clue("Head_Right", "Make a Right"));
		
		
		Thingy Head_Left= insert(Thingy.terminal("Head_Left","You are faced with a beautiful mural that cosequently collapses and suffocates you.:(. /n"+
				"           _..--\"\"---.\n" + 
				"          /           \".\n" + 
				"          `            l\n" + 
				"          |'._  ,._ l/\"\\\n" + 
				"          |  _J&lt;__/.v._/\n" + 
				"           \\( ,~._,,,,-)\n" + 
				"            `-\\' \\`,,j|\n" + 
				"               \\_,____J\n" + 
				"          .--.__)--(__.--.\n" + 
				"         /  `-----..--'. j\n" + 
				"         '.- '`--` `--' \\\\\n" + 
				"        //  '`---'`  `-' \\\\\n" + 
				"       //   '`----'`.-.-' \\\\\n" + 
				"     _//     `--- -'   \\' | \\________\n" + 
				"    |  |         ) (      `.__.---- -'\\\n" + 
				"     \\7          \\`-(               74\\\\\\\n" + 
				"     ||       _  /`-(               l|//7__\n" + 
				"     |l    ('  `-)-/_.--.          f''` -.-\"|\n" + 
				"     |\\     l\\_  `-'    .'         |     |  |\n" + 
				"     llJ   _ _)J--._.-('           |     |  l\n" + 
				"     |||( ( '_)_  .l   \". _    ..__I     |  L\n" + 
				"     ^\\\\\\||`'   \"   '\"-. \" )''`'---'     L.-'`-.._\n" + 
				"          \\ |           ) /.              ``'`-.._``-.\n" + 
				"          l l          / / |                      |''|\n" + 
				"           \" \\        / /   \"-..__                |  |\n" + 
				"           | |       / /          1       ,- t-...J_.'\n" + 
				"           | |      / /           |       |  |\n" + 
				"           J  \\  /\"  (            l       |  |\n" + 
				"           | ().'`-()/            |       |  |\n" + 
				"          _.-\"_.____/             l       l.-l\n" + 
				"      _.-\"_.+\"|                  /        \\.  \\\n" + 
				"/\"\\.-\"_.-\"  | |                 /          \\   \\\n" + 
				"\\_   \"      | |                1            | `'|\n" + 
				"  |ll       | |                |            i   |\n" + 
				"  \\\\\\       |-\\               \\j ..          L,,'. `/\n" + 
				" __\\\\\\     ( .-\\           .--'    ``--../..'      '-..\n" + 
				"   `'''`----`\\\\\\\\ .....--'''\n" + 
				"              \\\\\\\\                           -nabis  ''\n" + 
				""));
		
		Thingy Head_Right= insert(Thingy.create("Head_Right","You make a right and are faced with two hallways."));
		Head_Right.addClue(new Clue("hallway0", "There is a long hallway."));
		Head_Right.addClue(new Clue("hallway1", "There is an equally long hallway."));
		
		Thingy hallway0= insert(Thingy.terminal("hallway0", "You decide it's too long and turn back around:)/n" + "			88888888888888888888888888888888888888888888888888888888888888888888888\n" + 
				"88.._|      | `-.  | `.  -_-_ _-_  _-  _- -_ -  .'|   |.'|     |  _..88\n" + 
				"88   `-.._  |    |`!  |`.  -_ -__ -_ _- _-_-  .'  |.;'   |   _.!-'|  88\n" + 
				"88      | `-!._  |  `;!  ;. _______________ ,'| .-' |   _!.i'     |  88\n" + 
				"88..__  |     |`-!._ | `.| |_______________||.\"'|  _!.;'   |     _|..88\n" + 
				"88   |``\"..__ |    |`\";.| i|_|MMMMMMMMMMM|_|'| _!-|   |   _|..-|'    88\n" + 
				"88   |      |``--..|_ | `;!|l|MMoMMMMoMMM|1|.'j   |_..!-'|     |     88\n" + 
				"88   |      |    |   |`-,!_|_|MMMMP'YMMMM|_||.!-;'  |    |     |     88\n" + 
				"88___|______|____!.,.!,.!,!|d|MMMo * loMM|p|,!,.!.,.!..__|_____|_____88\n" + 
				"88      |     |    |  |  | |_|MMMMb,dMMMM|_|| |   |   |    |      |  88\n" + 
				"88      |     |    |..!-;'i|r|MPYMoMMMMoM|r| |`-..|   |    |      |  88\n" + 
				"88      |    _!.-j'  | _!,\"|_|M)(MMMMoMMM|_||!._|  `i-!.._ |      |  88\n" + 
				"88     _!.-'|    | _.\"|  !;|1|MbdMMoMMMMM|l|`.| `-._|    |``-.._  |  88\n" + 
				"88..-i'     |  _.''|  !-| !|_|MMMoMMMMoMM|_|.|`-. | ``._ |     |``\"..88\n" + 
				"88   |      |.|    |.|  !| |u|MoMMMMoMMMM|n||`. |`!   | `\".    |     88\n" + 
				"88   |  _.-'  |  .'  |.' |/|_|MMMMoMMMMoM|_|! |`!  `,.|    |-._|     88\n" + 
				"88  _!\"'|     !.'|  .'| .'|[@]MMMMMMMMMMM[@] \\|  `. | `._  |   `-._  88\n" + 
				"88-'    |   .'   |.|  |/| /                 \\|`.  |`!    |.|      |`-88\n" + 
				"88      |_.'|   .' | .' |/                   \\  \\ |  `.  | `._    |  88\n" + 
				"88     .'   | .'   |/|  /                     \\ |`!   |`.|    `.  |  88\n" + 
				"88  _.'     !'|   .' | /                       \\|  `  |  `.    |`.|  88\n" + 
				"88 vanishing point 888888888888888888888888888888888888888888888 fL 888\n" + 
				""));
		
		Thingy hallway1=insert(Thingy.create("hallway1","You hear another train approaching the platform"));
		hallway1.addClue(new Clue("Train","You see the lights of an incoming train."));
		hallway1.addClue(new Clue("turnstile","You turn around and find another way to get home."));
		
		Thingy Train = insert(Thingy.terminal("Train", "You see the A,C,& E train and the small crowd and no delays! You head home :) /n "+""
				+ "           o x o x o x o . . .\n" + 
				"         o      _____            _______________ ___=====__T___\n" + 
				"       .][__n_n_|DD[  ====_____  |    |.\\/.|   | |   |_|     |_\n" + 
				"      &gt;(________|__|_[_________]_|____|_/\\_|___|_|___________|_|\n" + 
				"      _/oo OOOOO oo`  ooo   ooo   o^o       o^o   o^o     o^o\n" + 
				"-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" + 
				""));
		
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

