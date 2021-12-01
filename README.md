Added function:
Player able to choose colour of the bar and also the ball before start.
There is a new button in home menu that is named as info that will show gameplay instruction for the player.
There will be background music when the game started and user can mute or un-mute the BGM of the game.
Player can either use LEFT and RIGHT arrow to move the player left and right or A and D.
Time taken for each level will be recorded and high score which have the shortest time will be counted.
There is a training level for each of the type of brick and it will be available fpr player to test the game

Refactor:
The colour for player that was in player class and called in game board class is now in game board class.
Maven is now added in the project with a JAR file.
Changed the rubber ball class and set the colour of the ball directly when drawing the ball.
Removed crack class in brick class so that each class have only one function(Singularity).
