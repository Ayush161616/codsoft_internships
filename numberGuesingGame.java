import java.util.Random;
import java.util.Scanner;

public class numberGuesingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("welcome to number guessing game:");
        int score = 0;
        boolean playAgain= true;
        while (playAgain){
            int targetNumber = random.nextInt(100)+1;
            int attempts = 0;
            int maxAttempt = 5;
            System.out.print(" I have selected a number between 1 and 100. can you guess it?");
            while (attempts<maxAttempt){
                System.out.print("Enter your guess:");
                int userGuess = sc.nextInt();
                sc.nextLine();
                attempts++;
                if(userGuess==targetNumber){
                    System.out.println("Congratulations ! you guessed the number "+targetNumber+"in"+attempts+" attempts.");
                    score++;
                    break;
                }
                else if (userGuess<targetNumber){
                    System.out.println("Too low! try again");

                }else {
                    System.out.println("To high! try again ");
                }

            }
            if(attempts>=maxAttempt){
                System.out.println("sorry , you runout of attempts the correct number was"+targetNumber+" . ");

            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        System.out.println("Game over! you score: " +score);
        sc.close();
    }
}
