# Java quest 

A textual battle rpg based upon dragon quest 1 on the NES created in java.
Created with java 25 using JUnit for the Unit Test and Gson for the jsons.

## Run 

Through IntelliJ, select the Main class and run it through the current file profile and the green play.

## Features 

- Battle with different monsters in a 1 on 1 battle with spell and abilities
- Level up system
- A save feature
- Naming feature for the player character

## The different primaries classes

- Character : the basis for the player and enemies classes
- Combat : manage the battle between the player and enemies
- Action : the basis of an action of a character during a combat
- Status : the basis of the different status of a character
- UserInputManager : manage all of the user input of the project
- JsonManager : read the different java for the levels and the saves

## Technical decisions

- AffichageManager : centralize the graphical aspect of the application to facilitate a possible, later, change in the presentation
- LevelList/StatusList : wrapper containing a each a single list, done to create method of search to reduce redundancy and possible error*
- IAction/ISpell/ICharacter/IPlayer/IEnemie : interfaces places between the different class like Player and Combat to facilitate a possible replacement like a Player not controlled by the user
- IActionAdapter and ActionEnum : an adapter translated strings stock in the .json to the different actions classes since a interface cant be instantiated and so stock natively in a .json

## Inheritance

Character --> Player
          |-> Enemie

Action -> Spell

## Polymorphism

Player and Enemy casted as Character in the Combat class

## Abstract class/interface

- Character : Abstract class used  to create the different Player and Enemy, the two sharing the same basis
- Action/Spell : Abstract used as the basis of all the different action/spell list in ActionEnum
- StatusEffect : Interface containing the observe declaration for applying the effect of the status

## Custom exceptions

- InvalidInputException : for error in the stats of saved in the .json
- LevelDontExistException : when trying to get a level that does'nt exist in a LevelList

## How the application load its data

At the start of the program, if the user want it, it can load the save stocked in save.json, recovering a Player instance.
Or if the user want a new game, the program create a new Player and load its levelList from PlayerLevels.json.
The two using the Gson libraries.

## SOLID



## Run the test

Through IntelliJ, create a new JUnit profile and select all in the package for the test selection. Them launch the profile.

