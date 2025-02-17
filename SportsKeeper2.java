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

public class SportsScoreKeeper2 {

    static Scanner input = new Scanner(System.in); // global scanner

    //methods
    static double avgPtsPerMatchForEntireSeason (int[][] teamScores, final int NUM_GAMES, final int NUM_PERIODS) {
        double sumOfAllScores = 0;
        for (int i = 0; i < NUM_GAMES; i++) {
            for (int j = 0; j < NUM_PERIODS; j++) {
                sumOfAllScores += teamScores[i][j];
            }
        }
        return sumOfAllScores / NUM_GAMES; // returns the avg point per match for entire season
    }

    static int invalidInputMsg (int userInput, int lowThreshold, int highThreshold) {
            while (userInput > highThreshold || userInput < lowThreshold) {
                System.out.print("Invalid Input, Try Again!\n");
                userInput = input.nextInt();
            }
            return userInput;
    }

    static int displayPtsForGivenMatch (int selectMatch, int totalScore, int[][] teamScores, final int NUM_PERIODS){
        for (int j = 0; j < NUM_PERIODS; j++) {
            System.out.println("Period " + (j + 1) + ": " + teamScores[selectMatch - 1][j]);
            //(j+1) to print Period 1..2... and then [selectMatch-1] is used to compensate for the index in the array
            totalScore += teamScores[selectMatch - 1][j]; //compensate for the index using -1
        }
        return totalScore;
    }

    static double avgPtsScoredPerPeriod (int periodSelected, int[][] teamScores, final int NUM_GAMES) {
        double sumOfScores = 0;
        for (int j = 0; j < NUM_GAMES; j++) {
            sumOfScores += teamScores[j][periodSelected - 1];
        }
        return sumOfScores / NUM_GAMES;
    }


    public static void main(String[] args) {

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
            userChoice = invalidInputMsg(userChoice, 1, 4); //returning the right input

            switch (userChoice) {
                case 1: // avg pts scores per match for entire season
                    System.out.println("The average points scored per match for the entire season is, " + avgPtsPerMatchForEntireSeason(teamScores, NUM_GAMES,NUM_PERIODS));
                    break;

                case 2: //score details for given match + total pts
                    System.out.println("Please select a match (1-10)");
                    int selectMatch = input.nextInt();
                    selectMatch = invalidInputMsg(selectMatch, 1,NUM_GAMES); //input validation

                    int totalScore = 0;
                    System.out.println("Match " + selectMatch + " details:");
                    System.out.println("Total Points for this Match: " + displayPtsForGivenMatch(selectMatch, totalScore, teamScores, NUM_PERIODS));
                    break;

                case 3: //avg pts scored for a period
                    System.out.println("Please select a period (1-2):");
                    int selectPeriod = input.nextInt();
                    selectPeriod = invalidInputMsg(selectPeriod, 1, NUM_PERIODS); // more input validation

                    System.out.println("The average number of points scored in period " + selectPeriod + " is " + avgPtsScoredPerPeriod(selectPeriod, teamScores, NUM_GAMES));
                    break;

                case 4: //exit program
                    System.exit(0); // exit program
                    break;
                default:
            } // end of switch statement
        } //end of while loop
    }
}
