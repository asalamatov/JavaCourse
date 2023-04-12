package org.example;
import static org.example.StartGameOrNot.startGame;

/**
 * this main class is very short and uses methods from other classes and superclasses
 *
 */
public class Main extends DisplayInstructions{
    public static void main(String[] args){
        GameLogic game = new GameLogic();  // new instance of GameLogic class, to use its methods later
        boolean endOfGame = false;
        while (startGame()) {  //startGame return boolean, if the user want to play or not
            showInstructions();
            game.selectWord();
            while (!endOfGame) {
                endOfGame = game.checkUserGuesses();
            }
        }
    }
}
