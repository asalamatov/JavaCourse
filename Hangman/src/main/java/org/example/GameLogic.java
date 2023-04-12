package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameLogic extends HangmanDrawings implements GameRequirements{

    /**
     * all the necessary field variables are declared here,
     * I used List and ArrayList in this code, because they are mutable and have more functions
     */

    private static int numberOfIncorrectAnswers = 0;
    private static List<String> words;
    protected static List<Character> wordCharacters;
    protected static String hiddenWordShow ;
    protected static List<Character> hiddenWordCharacters = new ArrayList<>();
    private static final String PATH_TO_WORDS_TXT = "/home/azamat/IdeaProjects/Hangman/src/main/java/org/example/words.txt";
    private static boolean isEndOfGame =false;


    public GameLogic() {
    }

    /**
     * the next 4 methods are implemented from GameRequirements Interface
     * they are all non-static
     */
    @Override
    public void getWordsList() {

        /**
         * this method uses Streams API to get the words from the words.txt
         * then collects the String in the stream into the ArrayList of words
         */
        try {
            words = Files.lines(Path.of(PATH_TO_WORDS_TXT))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (words.isEmpty()){
            System.out.println("*********************************************************File Error occurred*********************************************************");
            return;
        }
    }

    /**
     * selectWord method gets Stream of char and collects them into the wordCharacters List
     */
    @Override
    public void selectWord(){
        this.getWordsList();
        int random = new SecureRandom().nextInt(0, words.size());
        hiddenWordShow = words.get(random);
        wordCharacters = hiddenWordShow
                .chars()
                .mapToObj(e->(char)e)
                .collect(Collectors.toList());
        for (char c : wordCharacters) {hiddenWordCharacters.add('_');}
        System.out.println(wordCharacters);
        System.out.println("\n\n\n");

        encryptWord();
    }

    /**
     * this method takes the hiddenWordCharacters, initially list of underscores
     * then, prints them on the console uses Runnable class and lambda (IntelliJ IDE generated it automatically)
     */
    @Override
    public void encryptWord(){
        Runnable runnable = () -> {
            for (char c : hiddenWordCharacters) {
                System.out.printf("%c ", c);
            }
            System.out.println("\n\n\n");
        };
        runnable.run();
    }

    /**
     * This method is the main part of the Game, it validates the guesses and return boolean,
     *     -> true if endOfGame is true
     *     -> else false
     * @return
     */
    @Override
    public boolean checkUserGuesses() {
        displayHangMan(numberOfIncorrectAnswers);  // Shows the image of hangman

        System.out.println("\nWhat is your guess?");
        Scanner scan = new Scanner(System.in);
        String userLetter = scan.next().strip().toLowerCase();


        /**
         * This is the main logic of the game
         * it checks if the entered letter is valid
         * if the input is not a char -> retry
         * if the input is not a correct answer -> 1 attempt lost
         * if the input is correct -> everything is OK -> proceed to next attempt
         */
        if (userLetter.length()==1) {
            if ( numberOfIncorrectAnswers<6) {
                char userChar = userLetter.charAt(0);
                if (wordCharacters.contains(userChar)){
                    int index = wordCharacters.indexOf(userChar);
                    System.out.println("********Correct!*********");
                    hiddenWordCharacters.set(index, userChar);
                } else {
                    System.out.println("Try Again");
                    numberOfIncorrectAnswers++;
                }
            } else {
                System.out.println("Just joking, you are already dead hahahahahaha");
                displayHangMan(numberOfIncorrectAnswers);
                System.out.println("The hidded word was \"".concat(hiddenWordShow).concat("\""));
                isEndOfGame = true;
                return isEndOfGame;
            }
        } else {
            System.out.println("Please enter one letter");
        }
        System.out.println();

        encryptWord();

        if (hiddenWordCharacters.equals(wordCharacters)) {
            System.out.println("\n\n\n!!!!!   You WON   !!!!!\n\n\n");
            isEndOfGame = true;
        }
        return isEndOfGame;
    }


    /**
     * getters and setters
     *
     * generate automatically in IntelliJ IDE
     *
     * @return
     */
    public static int getNumberOfIncorrectAnswers() {
        return numberOfIncorrectAnswers;
    }

    public static void setNumberOfIncorrectAnswers(int numberOfIncorrectAnswers) {
        GameLogic.numberOfIncorrectAnswers = numberOfIncorrectAnswers;
    }

    public static List<String> getWords() {
        return words;
    }

    public static void setWords(List<String> words) {
        GameLogic.words = words;
    }

    public static List<Character> getWordCharacters() {
        return wordCharacters;
    }

    public static void setWordCharacters(List<Character> wordCharacters) {
        GameLogic.wordCharacters = wordCharacters;
    }

    public static String getHiddenWordShow() {
        return hiddenWordShow;
    }

    public static void setHiddenWordShow(String hiddenWordShow) {
        GameLogic.hiddenWordShow = hiddenWordShow;
    }

    public static List<Character> getHiddenWordCharacters() {
        return hiddenWordCharacters;
    }

    public static void setHiddenWordCharacters(List<Character> hiddenWordCharacters) {
        GameLogic.hiddenWordCharacters = hiddenWordCharacters;
    }

    public static boolean isIsEndOfGame() {
        return isEndOfGame;
    }

    public static void setIsEndOfGame(boolean isEndOfGame) {
        GameLogic.isEndOfGame = isEndOfGame;
    }
    /**
     * end of getters and setters
     */
}
