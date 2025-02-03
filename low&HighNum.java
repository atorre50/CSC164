/*
Alejandra Torres
1/22/2025
CSC164
I didn't cheat
 */

import java.util.Scanner; // Explicit Import, similar to #include <iostream>
// java.util.*  (Implicit Import, No performance diff)

public class Main {
    public static void main (String[] args) {

        //input is the "variable" for the keyboard
        Scanner input = new Scanner (System.in);

        System.out.print("Input one number with a low threshold: ");
        int lowThreshold = input.nextInt();

        System.out.print("Input one number with a high threshold: ");
        int highThreshold = input.nextInt();

            //ensuring high threshold is higher than the low
            while (lowThreshold > highThreshold) {
                System.out.println("ERROR: High Threshold must be higher than low threshold. ");
                System.out.print("Please try again: ");
                highThreshold = input.nextInt(); //user input!!
            }

        System.out.print("Please enter a number within the range of " + lowThreshold + " & " + highThreshold + ": ");
        int thirdNum = input.nextInt();

            while (thirdNum < lowThreshold || thirdNum > highThreshold) {
                System.out.println("ERROR: Number is not within range");
                System.out.print("Please try again: ");
                thirdNum = input.nextInt();
            }

        System.out.println("SUCCESS! " + thirdNum + " is within range!");
    }
}
