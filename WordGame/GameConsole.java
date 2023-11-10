import java.util.Scanner;

/**
 * A class that interacts with the user to enable guessing the secret word.
 * 
 * @author rachelcurci
 *
 */
public class GameConsole {

    /**
     * The prompt string used to prompt the user for input. The prompt string
     * can be used as: System.out.printf(InputPrompt, currWord);
     */
    private static final String INPUT_PROMPT = "Word so far: %s%n"
            + "Enter a word or a letter [*: quit, +: AI, ?: hint]: ";

    /**
     * A simple message that is printed whenever the user guesses a character
     * correctly. This string is used as: System.out.printf(MatchMessage, c,
     * e.getMessage());
     */
    private static final String MATCH_MESSAGE = "You guessed a character "
            + "correctly!%nThe character '%c' occurs at index position(s) %s%n";

    /**
     * A simple message that is printed when the users chooses the AI option.
     */
    private static final String RANDOM_LETTER = "The new character added is "
            + "'%c' and occurs at index position(s) %s%n";

    /**
     * A simple message that is printed whenever the user guesses a character
     * that is not in the SECRET word. This string is used as:
     * System.out.printf(MatchMessage, c, e.getMessage());
     */
    private static final String NO_MATCH = "The character '%c' is not in "
            + "the word. %n";

    /**
     * A private static variable that is used to track the characters that have
     * been guessed by the user so far. This word is initialized to a bunch of
     * stars and as the user guesses characters, the corresponding characters
     * are filled-in until the whole word is guessed.
     */
    private static String currWord;

    /**
     * A private static variable that is used to track the character that the
     * user inputs that is used in the charGuess method.
     */
    private static char wordChar;

    /**
     * A private static variable that is used to track the character guesses the
     * user inputs.
     */
    private static String charGuess = "";

    /**
     * A private static variable that is used to hold the alphabet tracker.
     */
    private static String alphaTracker;

    /**
     * A method that determines the number of characters in the secret word by
     * repeatedly calling the guess method from the WordThrow class with words
     * of increasing length until the guess method stops throwing the custom
     * WordThrow.WordLengthMismatchException
     * 
     * @param wt The word throw object to be used in this method
     * @throws WordThrow.CorrectWordException If users word is the exact same as
     *                                        the secret word
     */
    public static void wordLength(WordThrow wt)
            throws WordThrow.CorrectWordException {

        currWord = "*";

        // using try..catch block to find the length of the SECRET word
        for (int i = 0; i < currWord.length(); i++) {
            try {
                wt.guess(currWord);
                // if currWord throws exception a * will be added
            } catch (WordThrow.WordLengthMismatchException err) {
                currWord = currWord + "*";
            }
        }
        System.out.println("Guess the " + currWord.length()
                + " character word.");

    }

    /**
     * A method that prompts user for their input.
     * 
     * @param wt The word throw object to be used in this method
     * @throws WordThrow.WordLengthMismatchException If users word does not
     *                                               match the length of the
     *                                               secret word
     */
    public static void gameLoop(WordThrow wt)
            throws WordThrow.WordLengthMismatchException {

        // initializing scanner variable
        Scanner input = new Scanner(System.in);

        // using while loop so user will continue to be asked for their guess
        // until they guess the word or exit the program
        // loop will only continue of currWord contains * because
        // that means the word has not been found yet
        while (currWord.contains("*")) {

            System.out.printf(INPUT_PROMPT, currWord);
            String word = input.nextLine();
            if (word.equals("*")) {
                break;
            } else if (word.equals("?") || word.equals("+")) {
                // calling method that handles such inputs
                specialChar(word, wt);
            } else if (word.length() < 2) {
                wordChar = word.charAt(0);

                // calling method to check if guess is in the word
                charGuess(wt);
            } else if (word.length() > 1) {

                // calling method to check if the guess was correct
                String message = stringGuess(wt, word);

                // using if else statements to determine if user has
                // correctly guess the word and print the message
                // from the stringGuesss method
                if (message.contains("Congratulations")) {
                    System.out.println(message);

                    // while loop ends if the user inputed
                    // the correct word
                    break;
                } else {
                    System.out.println(message);
                }
            }

        }
    }

    /**
     * Method to check if-and-where the letter occurs in the secret word using
     * the WordThrow.guess method along with WordThrow.MismatchException and
     * WordThrow.MatchAndOccursException
     * 
     * @param wt The word throw object to be used in this method
     */
    public static void charGuess(WordThrow wt) {
        // updating the list that holds the guesses the user has made
        charGuess = charGuess + wordChar;

        // using try..catch block
        try {
            wt.guess(wordChar);

            // if MismatchException is thrown the character is not in the SECRET
            // word -> NO_MATCH prompt is used
        } catch (WordThrow.MismatchException err) {
            System.out.printf(NO_MATCH, wordChar);

            // if MatchAndOccursException is thrown the character is in the
            // SECRET word -> MATCH_MESSAGE prompt is used
        } catch (WordThrow.MatchAndOccursException mao) {

            // initializing variable for the exception message to be able to use
            // in another method
            String index = mao.getMessage();
            System.out.printf(MATCH_MESSAGE, wordChar, index);

            // calling method to update currWord variable
            updateCurrWord(index, wordChar);
        }

    }

    /**
     * Method to check if the guess is correct and returns message based on what
     * exception is thrown.
     * 
     * @param wt   The word throw object to be used in this method
     * @param word The object passed into the method containing the users input
     * @return message Returns a message that is then handled by the gameLoop
     *         method
     */
    public static String stringGuess(WordThrow wt, String word) {

        // Initializing message variable to hold the returned message
        String message;

        // Using try.. catch block
        try {
            wt.guess(word);

            // If method runs with no exceptions the user guessed incorrectly
            message = "Good try, but you guessed wrong.";
        } catch (WordThrow.WordLengthMismatchException err) {

            // If WordLengthMismatchException is thrown the user guessed a word
            // with an incorrect length
            message = "Your guessed word did not have same length.";
        } catch (WordThrow.CorrectWordException cwe) {

            // If CorrectWordException is thrown the user guessed correctly
            message = "You guessed the word! Congratulations!";
        }

        return message;

    }

    /**
     * Method that updates the letters in the currWord variable at the index
     * positions from the MatchAndOccursException message.
     * 
     * @param index MatchAndOccursException message that has the indexes at
     *              which there guess is located
     * @param guess Takes in the character that needs to be added to currWord
     */
    public static void updateCurrWord(String index, char guess) {

        // connecting exception method to scanner object
        Scanner indexPoints = new Scanner(index);

        // using while loop to read through the numbers in the message
        while (indexPoints.hasNextInt()) {

            // changing currWord to a charArray because strings are immutable
            char[] charCurrWord = currWord.toCharArray();
            charCurrWord[indexPoints.nextInt()] = guess;

            // changing currWord back to String variable
            currWord = String.valueOf(charCurrWord);
        }
        // using if statement
        // if updated currWord has no * then the word has been guessed
        if (!currWord.contains("*")) {
            System.out.println("You guessed the word! Congratulations!");
        }

        // closing scanner object
        indexPoints.close();
    }

    /**
     * Method that uses charGuess to find what letters have been guessed.
     * 
     * @return alphaTracker Returns an alphabet string that has "-" for letters
     *         that have already been guessed
     */
    public static String whatLetters() {

        // initializing string array to hold the letters of the alphabet
        // to be able to parse through and edit
        String[] alpha = { "a", "b", "c", "d", "e", "f", "g",
            "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

        // using for loop replace the letters in
        // charGuess with "-" in the alpha array
        for (int i = 0; i < alpha.length; i++) {
            if (charGuess.contains(alpha[i])) {
                alpha[i] = "-";
            }
        }
        // Converting alpha array into a string
        alphaTracker = String.join("", alpha);

        return alphaTracker;

    }

    /**
     * A method that finds a random letter in the secret word using the
     * process-character functionality on behalf of the user.
     * 
     * @param wt The word throw object to be used in the method
     */
    public static void randomLetter(WordThrow wt) {
        int i = 0;

        // using alphaTracker object to make sure a letter that has already been
        // chosen is not found
        while (i < alphaTracker.length()) {
            char charAlpha = alphaTracker.charAt(i);
            try {
                wt.guess(charAlpha);
            } catch (WordThrow.MatchAndOccursException mao) {
                String index = mao.getMessage();
                System.out.printf(RANDOM_LETTER, charAlpha, index);
                charGuess = charGuess + charAlpha;
                updateCurrWord(index, charAlpha);
                break;
            } catch (WordThrow.MismatchException err) {
                i++;
                continue;
            }

        }
    }

    /**
     * A method to handle if ? or + are input and direct program to correct
     * method.
     * 
     * @param word user input
     * @param wt   The word throw object to be used in method
     */

    public static void specialChar(String word, WordThrow wt) {
        String alpha = whatLetters();
        String input = word;
        if (input.equals("?")) {
            System.out.println("Letters left to guess: " + alpha);
        } else {
            randomLetter(wt);
        }
    }

    /**
     * The top-level method that is invoked by WordThrow class to enable the
     * user to use different operations to guess the secret word. This method is
     * expected to prompt the user for input and perform the necessary
     * operations based on user-input. This method essentially uses a set of
     * helper methods to accomplish the necessary functionality.
     * 
     * @param wt The word throw object to be used by this method.
     * @throws WordThrow.CorrectWordException        If users word is the exact
     *                                               same as the secret word
     * @throws WordThrow.WordLengthMismatchException If users word does not
     *                                               match the length of the
     *                                               secret word
     */
    public static void play(WordThrow wt)
            throws WordThrow.WordLengthMismatchException,
            WordThrow.CorrectWordException {

        // calling wordLength method to determine the length of the word
        wordLength(wt);

        // calling userInput method to carry out rest of program
        gameLoop(wt);

    }
}
