/*
Alejandra Torres
Delaware Technical Community College
CSC164 - Computer Science II
Spring 2025
I didn't cheat
*/
import java.util.Scanner;

public class Main {

    //add static at the start
    static Scanner input = new Scanner(System.in); // global keyboard

    // display all sales
    static void showAllSales(int[] numCarsSold) {
        for (int i = 1; i < numCarsSold.length; i++ ){
            System.out.printf("Month %d: " + numCarsSold[i-1] + " cars", i);

            if (numCarsSold[i-1] > 20) {
                System.out.print(" ** extra 10% commission");
            }
            System.out.println();
        }
    }

    //show sales by month chosen
    static void showSalesByMonth(int monthChosen, int[] numCarsSold) {
        System.out.println("Month " + monthChosen + ": " + numCarsSold[monthChosen-1] + " cars");
    }

    //calc commission by month
    static double calculateCommissionByMonth(int monthChosen, int[] numCarsSold) {
        double commissionValue = 500;
        double commissionAfter1st20CarsSold = 550;
        double carsSold = numCarsSold[monthChosen-1];
        double totalCommissionEarned;

        if (carsSold > 20) {
            totalCommissionEarned = 20 * commissionValue;
            totalCommissionEarned += (carsSold-20) * commissionAfter1st20CarsSold;
        }
        else {
            totalCommissionEarned = carsSold * commissionValue;
        }
        return totalCommissionEarned;
    }

    public static void main(String[] args) {

        int[] numCarsSold = {10, 19, 21, 15, 25, 9, 11, 15, 30, 35, 21, 19};


        while (true) {
            //menu
            System.out.println("\n1. Show all sales.");
            System.out.println("2. Show sales by month");
            System.out.println("3. Show commissions by month");
            System.out.println("4. Exit Program");
            System.out.println("Enter (1-4)");

            int userInput = input.nextInt();

            while (userInput > 4 || userInput < 1) {
                System.out.println("Invalid, Please try again");
                userInput = input.nextInt();
            }

            switch (userInput) {
                case 1:
                    showAllSales(numCarsSold);
                    break;
                case 2:
                    System.out.println("Which month do you want to view? (1-12)");
                    int selectMonth= input.nextInt();
                    showSalesByMonth(selectMonth, numCarsSold);
                    break;
                case 3:
                    System.out.println("Which month do you want to view? (1-12)");
                    int selectMonthForCommission = input.nextInt();

                    //use %.2f%n in this instance to avoid floating point number error
                    System.out.printf("Commission for month is: %.2f%n", calculateCommissionByMonth(selectMonthForCommission, numCarsSold));
                    break;
                case 4:
                    System.out.println("bye bye!");
                    System.exit(0);
                    break;
                default:
            } // end of switch case
        } // end of infinite while loop
    }
}
