	INDIVIDUAL INFORMATION

 Name: James McCarthy
 Course: CS141
 Professor: Edwin Rodríguez
 Assignment #: 2

	- ASSIGNMENT DESCRIPTION- 

 This program is meant to fufill the requirements outlined 
 in the Assignment #2 specification posted on Blackboard. It
 is meant to be a simple version of a dungeon escape game
 that is implemented using object oriented patterns.

	- APPROACH -

 My approach in completing this assignment was as follows:
 First, I wrote method and field signatures for all model 
 based objects including the weapons, items, and actors
 featured in the requirement sheet. Then, I created a game
 class to hold all the methods related to the game's logic
 and wrote signatures for each method. Then I created a UI
 class using the Java Swing library to act as a view and 
 bound each button to a related method from a seperate 
 Application class acting as a presenter. Then I filled
 out the signatures so that it fit the generic pattern of 
 using a presenter to store and retrieve data from the model 
 while updating the UI.

	- CONCLUSION -

 I'm in the process of re-reading a book I read many years
 ago, but never really understood called Game Design Patterns.
 A big theme of the book is about disentangling different
 parts of your code so that things can be more maintanble and
 that knowledge really paid off for this assignment.

 After writing the bulk of this program I was informed that
 using Swing for the UI probably wasn't the best choice and 
 instead I should just go with a plain console based UI
 instead. Luckily, because I used an MVP implementation
 I only had to alter the methods of the UI class to take
 text entery based input rather than event based. No changes
 had to be made to other parts of the program because I
 tried to write it in a way that was more disentangled and
 consequently it only took me an hour or so to finish.

 The only real problem I had was trying to recoconcille
 newly gained knowledge about the workings of big and complex
 programs with the fact that this was meant to be a small
 scale assignment. There are parts of this program's code 
 that looks very sloppy to me, and I could make them a lot
 nicer, but I feel like that would betray the simple nature 
 of this assignment. 
 
 The other biggest difficulty I had with this assignment was 
 having to Javadoc everything. It seems like complete overkill
 to have to put links to every reference and write lengthy
 details about all sorts of call backs when a simple 
 "//this method does this" would suffice.