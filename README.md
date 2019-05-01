# CSC212P4 Escape

You are stuck at the Times Square subway stop. We’ve given you some clues in order for you to find your way around this stop. Keep in mind there are multiple subway lines but only one way out. Make sure to find the clue before the temperature gets to 250 degrees and you die. In case you get stuck, we have also provided you with a backpack that stores the clue you’ve selected. You can access this by typing in “clues”.


## Learning Objectives
The learning objectives of this assignment are:
 - Using Escape and other Interactive Fiction to explore using and understanding Graphs. 
 - To practice using Maps with Java. 
 - To gain an understanding of Graphs.
 - Get a comprehensive understanding of how and where it is appropriate to add user interface.  

# Lab Challenges

## (Lab) Play Escape and Draw a "graph" for yourself
 - Import the starter code. (Don't forget the Maven step).
 - Play Escape, and sketch out the "game" on paper.
 - Finish the game by finding the "A/C/E subway line" Thingy.
 - Include a scan (or clear cell phone photo) of your graph in your writeup.

 
## (Lab) Get a handle on the Escape Code
- Add a clue and thingy (called a thingy because calling an object results in a Java confusion).
- Change some descriptions to fit your personality more.


## (Lab) Get a sense of the InteractiveFiction Code
Look in Interactive Fiction and search for particular clue words that will help you Clue the game. Add more like ‘good-bye’ or ‘end’.

# Challenges for P4:

### Reflection (=15)

After submitting your code, there should be a PDF attached that will identify the grade you expect on this assignment based on what you completed. In addition, you will write a paragraph describing your struggles and how (if you did) overcame them.


### Program Compiles (=15)
Your code should be professional. There should be comments on everything that you have created. Make sure to proofread your work and delete unnecessary comments and experiments.


## Optional Suggested Challenges

### Implement Your Own Game (=16)
- (4) Must have at least 8 objects.
- (4) Must have at least 8 functional clues that lead to somewhere else.
- (4) Must have one terminal place (a way to win the game).
- (4) Have some misleading clues aka one-way paths (a clue that leads nowhere)

### Implement a score (= 5)
 - (5) Add a score that displays the maximum amount in the beginning and prints out the final score at the end.
 
### Implement a starting option (= 5)
 - (5) Before your game starts give the player an option on where to start.

### Implement SecretClue (=24)
- (4) Create a class SecretClue that extends Clue.
- (4) Put a method called "boolean isSecret()" on Clues that works for both classes. Clues are never secret, but SecretClues are until you search for them.
- (4) SecretClue should have a private boolean hidden, that starts off as true.
- (4) Make it so SecretClues are not printed to the user (in InteractiveFiction) when hidden. Change Object.getVisibleClues() to return only the clues that are not secret.
- (4) When a user types search, if there is a SecretClue in the room they are currently in, it should be made visible to them. Make a void search() method on Clue and SecretClue that does nothing to Clue but reveals the SecretClue.
- (4) Put a SecretClue that leads from one object to the last clue.
 
### Create a heating system in your game. (=16) 
- (8) Create a class GameTemperature, that has an int degree as a state, ranging from 0 to 250 (inclusive). Implement int getDegree() and void increaseDegree() and print out the temperature in newyorken. 
- (4) Extend the game's concept of a player with current temperature. Increment the temperature every time the player finds a clue. Print out the current temperature after a clue description.
- (4) End the game when the temperature reaches 250 degrees.
 
### Create a time system in your game. (=16 or 32 if you do a heating system)
- (8) Create a class GameTime, that has an int hour as a state, ranging from 0 to 23 (inclusive). Implement int getHour() and void increaseHour() and print out the hour like a 12 or 24-hour watch.
- (4) Extend the game's concept of a player with a current time. Increment the hour every time the player moves. Print out the current time after a clue description.
- (4) Tell the player how many hours they spent in your game upon Game-Over. (Not the current time, so you'll need a new int on your GameTime class).
- (4 or 20) Implement a temperature system. Every 5 hours the temperature should be accelerated by 2 degrees.

### Implement Different Perspectives depending on the temperature (=20) 
- (4) Make an action rest that advances the temperature by 30 degrees so you can test the descriptions. (This could be independent of GameTime)
- (4) Implement a boolean method called isCold()
- (4) Add GameTemperature as a parameter to the getClueDesciption method on Object (maybe printDescription now).
- (8) Create some places with descriptions based whether GameTemperature isCold() -- maybe specific Places need to be subclasses with their own custom printDescription!

 
### Implement a new game with some other tool or switch or idea (=?)
 - Check with me to make sure it's not too hard :)
 
