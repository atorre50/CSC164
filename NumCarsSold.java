/*
Alejandra Torres
2/3/2025
CSC164
I didn't cheat.
 */

public class Main {
    public static void main (String[] args) {

        int[] numOfCarsSold = {10, 19, 21, 15, 25, 9, 11, 15, 30, 35, 21, 19};

        for (int i = 1; i <= numOfCarsSold.length; i++){
            System.out.printf("Month %d: " + numOfCarsSold[i-1] + " cars ", i); //%d is the format specifier for integers
            if (numOfCarsSold[i-1] >= 20) {
                System.out.print( "** extra 10% commission ");
            }
            System.out.println(); //new line after text
        }//end of for loop
    }
}
