package org.example;

/**
 * Interface is implemented by GameLogic class, where all of these methods are overridden and used
 */
public interface GameRequirements {
    void getWordsList();
    void selectWord();
    boolean checkUserGuesses();
    void encryptWord();
}
