/*
Alejandra Torres
Assignment 1: Sports Scorekeeper - Arrays
Delaware Technical Community College
CSC164 - Computer Science II
Spring 2025
I didn't cheat
*/
import java.util.Random;
import java.util.Scanner;

public class SportsScoreKeeper {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final int NUM_GAMES = 10;
        final int NUM_PERIODS = 2;
        final int HIGH_SCORE_PER_PERIOD = 5;
        final int LOW_SCORE_PER_PERIOD = 0;

        int[][] teamScores = new int[NUM_GAMES][NUM_PERIODS]; // 2D array, 10 rows, 2 columns

        Random rng = new Random();
        // Set random number generator, so it provides the same random numbers every time
        // If you remove this line, the program will produce pseudorandom numbers that are different every time
        rng.setSeed(0);

        // Assign random scores to each period for each game
        for (int i = 0; i < NUM_GAMES; i++) { // 10 games, 2 periods
            for (int j = 0; j < NUM_PERIODS; j++) {
                teamScores[i][j] = rng.nextInt(LOW_SCORE_PER_PERIOD, HIGH_SCORE_PER_PERIOD+1);
            }
        }

        // display scores for every game
        for (int i = 0; i < NUM_GAMES; i++) {
            System.out.println("\nGame # " + (i + 1));
            for (int j = 0; j < NUM_PERIODS; j++) {
                System.out.println("Period " + (j+1) + ": this team scored, " + teamScores[i][j]);
            }
        } //end of for loop

        while (true) {
            //menu options
            System.out.println("\n##########################################");
            System.out.println("1. View the average points scored per match for the entire season.");
            System.out.println("2. View score details for a given match.");
            System.out.println("3. View the average points scored for a period.");
            System.out.println("4. Exit program.");
            System.out.println("Please enter your choice (1-4)");

            int userChoice = input.nextInt();
            while (userChoice > 4 || userChoice < 1) {
                System.out.println("Invalid Input, Try Again!");
                userChoice = input.nextInt();
            }

            switch (userChoice) {
                case 1: // avg pts scores per match for entire season
                    double sumOfAllScores = 0;
                    for (int i = 0; i < NUM_GAMES; i++) {
                        for (int j = 0; j < NUM_PERIODS; j++) {
                            sumOfAllScores += teamScores[i][j];
                        }
                    }
                    double avgPointsEntireSeason = sumOfAllScores / NUM_GAMES;
                    System.out.println("The average points scored per match for the entire season is, " + avgPointsEntireSeason);
                    break;

                case 2: //score details for given match + total pts
                    System.out.println("Please select a match (1-10)");
                    int selectMatch = input.nextInt();

                    while (selectMatch > NUM_GAMES || selectMatch < 1) {
                        System.out.println("Invalid Input, Try Again!");
                        selectMatch = input.nextInt();
                    }

                    int totalScore = 0;
                    System.out.println("Match " + selectMatch + " details:");
                    for (int j = 0; j < NUM_PERIODS; j++) { //j would represent t
                        System.out.println("Period " + (j + 1) + ": " + teamScores[selectMatch - 1][j]);
                        //(j+1) to print Period 1..2... and then [selectMatch-1] is used to compensate for the index in the array
                        totalScore += teamScores[selectMatch - 1][j]; //compensate for the index using -1
                    }
                    System.out.println("Total Points for this Match: " + totalScore);
                    break;

                case 3: //avg pts scored for a period
                    System.out.println("Please select a period (1-2):");
                    int selectPeriod = input.nextInt();

                    while (selectPeriod > NUM_PERIODS || selectPeriod < 1) {
                        System.out.println("Invalid Input, Try Again!");
                        selectPeriod = input.nextInt();
                    }

                    double sumOfScoresInPeriod = 0;
                    double averagePtsInPeriod;
                    for (int j = 0; j < NUM_GAMES; j++) {
                        sumOfScoresInPeriod += teamScores[j][selectPeriod - 1];
                    }
                    averagePtsInPeriod = sumOfScoresInPeriod / NUM_GAMES;
                    System.out.println("The average number of points scored in period " + selectPeriod + " is " + averagePtsInPeriod);
                    break;

                case 4: //exit program
                    System.exit(0); // exit program
                    break;
                default:
                    continue;
            } // end of switch statement
        } //end of while loop
    }
}

