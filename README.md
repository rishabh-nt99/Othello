# Othello Game - CS3343 course Project_Group 07 

- [Introduction](#introduction)  
- [Rules of the game](#rules-of-the-game)   
- [How to Play](#how-to-play) 
- [Version 1](#version-1)   
- [Version 2](#version-2)  
- [Version 3](#version-3)  
- [Installation](#installation)  
- [Creators](#creators)   
- [Copyrights](#copyrights-and-license)




# Introduction
Othello(also known as Reversi) is a strategy board game for two players usually played on an 8 x 8 checkerboard. This project also contains board versions of 6x6 and 10x10. 

## Rules of the game 
- At the very start, you will have four stones that will be centrally placed, in an 8x8 board, with the diagonal stones being of the same colour. This is a two-player game, with white and black stones that define the two players. 
- The speciality of these stones are that they have two sides: black on one and white on the other, so flipping them would mean changing the colour. 
- To make a move, one must change the colour of one or more of the opponent's stones. This can be done, by various strategies, using one particular concept. You can reverse the opponent's stone/s by placing two of your own colour stones on two sides of the sequence of your opponent's stones.  
- Therefore, 
A Legal Move is one which can reverse one or more of the opponent's stones. 
- This reversal can happen in any straight line, including vertical, diagonal or horizontal. 
- If there are no legal moves, that is possible, the chance is skipped, and passed on to the other player. 
- When, both the players are out of legal moves, the game is over. 
- At this point, whichever is the dominant number of stones on the board, wins the game!

## How to Play 
- Choose the Board Size from 3 different options:
  - Small: 6x6
  - Medium: 8x8
  - Large: 10x10
- Select the mode:   
  - Player v/s Player (both enter their moves via keyboard one by one)
  - Player v/s Computer with two Difficulty Modes:  
    - Easy 
    - Hard
- Choose from the shown valid Moves when prompted to enter a move. 
- Use Undo and Redo Move Options by entering -2,-2 and -3,-3 respectively for Player ( 2 moves are undone each time so that if player 1 types undo his last move is undone)
- If you need help, enter 4 at the start menu to get the rules of the game.
- Press -1,-1 to exit the game while in the game or press 5 to Exit the game from the Main menu. 

![Othello Game](https://github.com/CharanRudraraju/Othello-Game/blob/charan/Othello/src/othello.png)

## Version 1
  - ### Version 1.1.
    Basic Othello game with two player mode and variable board sizes. 
  - ### Version 1.2
    Minor bug fixes and Added the much awaited option to undo and redo the moves. 

## Version 2
- Added an option to play with the computer. There's currently one level, Easy, for the computer which will be chosen automatically for the computer. 
- Minor Bug fixes

## Version 3
- Added level 'Hard' for the computer to choose form. Mode can be selected from the main menu before starting the game. 
- Minor Bug fixes


## Installation 
#### Windows
- Download the executable file from the repository and store it in your local device. 
- Run the executable file.(If the system issues any warning, ignore and run the application anyway

## Copyrights and License 
This project is part of a coursework and courtesy of the above mentioned teammates. Please send us a message to fork the project or for any questions.  
