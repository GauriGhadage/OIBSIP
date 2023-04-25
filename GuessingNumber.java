import java.util.Random;
import javax.swing.JOptionPane;

public class GuessingNumber {

    public static void main(String[] args) {
        int minNumber = 1;
        int maxNumber = 100;
        int numberOfGuesses = 10; // set a maximum number of guesses
        int score = 0;
        boolean playAgain = true;
        
        Random random = new Random();
        int randomNumber;
        
        while (playAgain) {
            // generate a random number within the given range
            randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            System.out.println("Guess a number between " + minNumber + " and " + maxNumber);
            for (int i = 0; i < numberOfGuesses; i++) {
                // prompt the user to enter their guess
                String guessString = JOptionPane.showInputDialog("Guess #" + (i+1));
                int guess = Integer.parseInt(guessString);
                
                if (guess == randomNumber) {
                    // the guess is correct
                    System.out.println("Congratulations, you guessed the number!");
                    score += (numberOfGuesses - i) * 10; // give more points for fewer attempts
                    break;
                } else if (guess < randomNumber) {
                    // the guess is too low
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    // the guess is too high
                    System.out.println("Your guess is too high. Try again.");
                }
            }
            
            // display the score and prompt the user to play again
            System.out.println("Your score is: " + score);
            String playAgainString = JOptionPane.showInputDialog("Do you want to play again? (y/n)");
            playAgain = playAgainString.equalsIgnoreCase("y");
        }
    }

}
