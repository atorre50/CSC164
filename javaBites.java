/*
Alejandra Torres
CSC Spring Semester 2025
I didn't cheat
 */

import java.util.Objects; //imported in order to do for example, (String == 20)
import  java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Food[] menu = {
                new Food("Burger", 5.99, "Gluten, Dairy"),
                new Food("Salad", 4.49, "Nuts"),
                new Food("Pizza", 8.99, "Gluten, Dairy"),
                new Food("Soup", 3.99, "None"),
                new Food("Pasta", 7.49, "Gluten, Dairy")
        };

        while (true) {
            printMenu(menu);

            //Asking for customer's name
            System.out.println("Enter your name:");
            String chosenName = input.nextLine();

            //temporary order in order to access name validation
            Order validateName = new Order(null,null,chosenName);
            chosenName = validateName.getCustomerName();

            //Ordering Item 1 & 2
            System.out.println("Enter the number of the 1st item you'd like to order: ");
            int itemSelect1 = input.nextInt();
            Food choice1 = selectFood(menu, itemSelect1, input);

            System.out.println("Enter the number of the 2nd item you'd like to order (or 0 for none): ");
            int itemSelect2 = input.nextInt();
            Food choice2 = selectFood(menu, itemSelect2, input);


            Order newOrder = new Order(choice1, choice2, chosenName);
            newOrder.printReceipt();

            String exitOption = input.nextLine();
            exitOrOrder(exitOption,input);
        }

    }

    static Food selectFood (Food[] menu, int option, Scanner input) {
        if (option < 0 || option > menu.length) {
            while (option < 1 || option > menu.length) {
                System.out.println("Invalid input, please select item from menu: ");
                option = input.nextInt();
            }
        }
        else if (option == 0) {
            return new Food("N/A", 0.00, "N/A"); //In case user chooses not to order anything
        }
        return menu[option - 1]; //returns the food item chosen, -1 is accounting for the index
    }

    static void exitOrOrder (String exitOption, Scanner input){
        System.out.println("Would you like to place another order? Type 'Yes' or 'no': " );
        exitOption = input.nextLine();

        //if the input is NOT "yes," "no," etc. the loop will run until otherwise
        while(!(exitOption.equals("Yes") || exitOption.equals("No") || exitOption.equals("yes") || exitOption.equals("no"))){
            System.out.println("Invalid input, please select item from menu: ");
            exitOption = input.nextLine();
        }
        if (Objects.equals(exitOption, "no") || Objects.equals(exitOption, "No")) { // You can't do (x == "no") with strings
            System.exit(0);
        }
    } //end of method

    //method to print menu items
    static void printMenu(Food[] menu){
        System.out.println("Welcome to Java Bites Restaurant!");
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i].getFoodName() + " - $" + menu[i].getPrice() + " (Contains: " + menu[i].getAllergens() + ")");
        }
    } //end of method
} // end of main class


class Food {
    private String foodName;
    private double price;
    private String allergens;

    public Food(String foodName, double price, String allergens){ // constructor, add the object's
        this.foodName = validateName(foodName);                   //instance variables as parameters so they are initialized
        this.price = validatePrice(price);
        this.allergens = allergens;
    }

    public String getFoodName(){                // food name getter
        return foodName;
    }
    public void setFoodName(String foodName) {  // food name setter
        this.foodName = validateName(foodName); // food name validation everytime a name is set
    }

    public double getPrice() {              // price getter
        return price;
    }
    public void setPrice(double price){     // price setter
        this.price = validatePrice(price);  // price validation everytime a value is set
    }

    public String getAllergens() {          // allergens getter
        return allergens;
    }
    public void setAllergens(){             // allergens setter
        this.allergens = allergens;
    }

    //validation methods
    public double validatePrice(double price){
        Scanner input = new Scanner(System.in);
        while (price < 0.00){
            System.out.println("Prices cannot be negative values. Enter a valid price: ");
            price = input.nextDouble();
        }
        return price;
    }
    public String validateName(String foodName){
        Scanner input = new Scanner(System.in);
        while (foodName == null || foodName.length() == 0) {
            System.out.println("Name cannot be empty, enter a valid name: ");
            foodName = input.nextLine();
        }
        return foodName;
    }

}

class Order {
    Scanner keyboard = new Scanner(System.in);
    private Food item1;
    private Food item2;
    private double totalCost;
    private String customerName;

    public Order (Food item1, Food item2, String customerName){
        this.item1 = item1;
        this.item2 = item2;
        this.customerName = customerNameValidation(customerName);;  //INPUT VALIDATION: name cannot be null
    }

    public String customerNameValidation(String chosenName){
        while (chosenName == null || chosenName.length() == 0) {                // IntelliJ says this is equivalent to chosenName.isEmpty()
            System.out.println("Name cannot be empty, enter a valid name: ");   // ...Keeping it simple for now
            chosenName = keyboard.nextLine();
        }
        return chosenName;
    }

    public Food getItem1() {
        return item1;
    }
    public Food getItem2() {
        return item2;
    }
    public String getCustomerName() {
        return customerName;
    }

    public double calculateTotalCost () {;
        totalCost = item1.getPrice();
        if (item2 != null){
            totalCost += item2.getPrice();
        }
        return totalCost;
    }

    public void printReceipt (){
        System.out.println("###############");
        System.out.println("Receipt:");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Ordered items:");
        System.out.println("- " + item1.getFoodName());
        if (item2 != null) {
            System.out.println("- " + item2.getFoodName());
        }
        System.out.println("Total Cost: " + calculateTotalCost());
        System.out.println("Allergens: ");
        System.out.println(item1.getFoodName() + " - " + item1.getAllergens());
        System.out.println(item2.getFoodName() + " - " + item2.getAllergens());
    }
}
