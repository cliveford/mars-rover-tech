# Mars Rover Tech Project  
---
## The Task  

### Setting the scene  
You have been asked to create a program to move rovers around the surface of Mars!
The surface of Mars is represented by a Plateau, you can make the assumption that the Plateau is a square/rectangular grid for the purpose of
this task.
Rovers navigate the Plateau, so they can use their special cameras and robot arms to collect samples back to Planet Earth.  

### Representation of a Rover’s Position on the Plateau  
The Plateau is divided into a grid. A Rover’s position is represented by x and y co-ordinates and the letters N, S, W, E to represent North,
South, West, East (the four cardinal compass points) respectively.  
Example:  
0 0 N  
This means the Rover is in the bottom-left corner facing in the North direction.  

### Instructing a Rover to Move Around the Plateau  
To move a Rover around the Plateau, a string of letters is sent to a Rover.
Here are the letters and their resultant action:
L Spins the Rover 90 degrees Left without moving from the current coordinate point.    
R Spins the Rover 90 degrees Right without moving from the current coordinate point.    
M Moves the Rover forward by one grid point, maintaining the same heading (i.e. from where the Rover is facing (its orientation)).  
N.B. Assume that the square directly North from (x, y) is (x, y+1).  

### First Line of Input to the Program  
The first line inputted into the program represents the upper-right coordinates of the Plateau.  
5 5  
This Plateau has maximum (x, y) coordinates of (5, 5).  
N.B. Assume that the lower-left coordinates is (0, 0).  

### Subsequent Lines of Input into the Program - Input to Rovers  
This represents the instructions to move the rovers.  
Each rover receives two lines of input.  
#### First Line of Input to a Rover:
The Rover’s position is represented by two integers representing the X and Y coordinates and a letter representing where the Rover is facing (its orientation).  
1 2 N
#### Second Line of Input to a Rover:
A string of letters representing the instructions to move the Rover around the Plateau.
#### Movement Rules
Rovers move sequentially, this means that the first Rover needs to finish moving first before the next one can move.
#### Output
For each Rover, the output represents its final position (final coordinates and where it is facing).  

### Example Test Case
#### Lines of Input to the Program:  
5 5  
1 2 N  
LMLMLMLMM  
3 3 E  
MMRMMRMRRM  
#### Expected Output:  
1 3 N  
5 1 E  

---
## Assumptions:  
1. I assumed it would be ok to change how the user input instructions.
2. I changed this in an attempt to prevent error, improve error handling, and to make the input more intuitive.  
---
## Approach and thought processes:  
In my first approach I attempted to follow TDD to the letter.   
This led to creating methods that became redundant when I implemented user interaction via the console.  
I also realised that I had gone off track, so I sketched out some user flow diagrams.  
This led me to deciding to scrap my initial approach and start afresh.  

My second approach worked out much better.  
However, I ran into some problems when trying to maintain state with only my Rover and Plateau classes.  
I created a Houston class to enable maintaining state.  
I am unsure whether it's ok to use my Houston class the way that I'm using it ??? - question:  
1. Is it ok to have a class that doesn't instantiate any objects but isn't abstract?  
I decided to use nested hashmaps to maintain state, it took me a considerable amount of time to get them working in a for each loop.  
I hate nested hashmaps :-)  
I became so distracted by hashmaps and state that my regular commits became non-existent.  
The hashmaps worked out well, and I got collision detection working.  
Added unit tests to test for collisions from all directions.  
Added a side game to entertain anyone that has had the patience to read this far :-)  
All unit tests are passing.  
Added finals and changed some access modifiers.  
Created UML class diagram.  
Final commit and push :-)  
To run the programme - Run `App.main()`  
---

## Tech used:  
IntelliJ IDEA(community edition), Java(17.0.2), Maven(3.8.4), junit(5.8.2)  


## Project set-up methodology:  
1. Create Maven project.  
2. Add dependencies to POM.
3. Add .gitignore & README.md  
4. Create packages for initial classes.  
5. Initialise local repo.
6. Commit.
7. Create git tag.
8. Create remote repo & push.  
9. Push git tag to remote.  

---
## Improvements & future considerations:  
1. Commit, Commit, Commit.  
2. Create parameterised tests.
3. Ensure correct access modifiers are in place. 
4. Ensure DRY.  
5. Refactor Plateau class to be a superclass to enable different shape plateau subclasses.  
6. Refactor Rover class to be a superclass to enable rover subclasses with different features.
