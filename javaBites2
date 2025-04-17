/*
Alejandra Torres
CSC Spring Semester 2025
I didn't cheat
 */

import java.util.ArrayList;
import java.util.Objects; //imported in order to do for example, (String == 20)
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<RestaurantItem> menu = new ArrayList<>();
        menu.add(new Food("Burger", 5.99, "Gluten, Dairy"));
        menu.add(new Food("Salad", 4.49, "Nuts"));
        menu.add(new Drink("Soda", 2.99, "Large", true));
        menu.add(new Drink("Coffee", 3.49, "Medium", false));
        menu.add(new GiftCard("Gift Card"));

        while (true) {
            printMenu(menu);

            System.out.println("\nEnter a name for your order: ");
            String customerName = input.nextLine();
            Order newOrder = new Order(customerName);

            System.out.println("\nEnter the number of the items you want to order (Up to 10 items, Enter 0 to stop ordering): ");
            final int MAX_ITEMS = 10;
            int count = 0;
            while(count < 10) {
                int option = input.nextInt();                           //I tried to be able to take a String input separated by spaces
                input.nextLine();                                       //then using parseInt(), however I failed, therefore I did my best with
                if (option == 0) {                                      //what I could comfortably do
                    break;  //breaks out of loop
                }
                RestaurantItem item = selectFood(menu, input, option);  //whatever item chosen is returned and stored in this item
                newOrder.addItem(item);                                 //reference variable. Then the item is added to the newOrder's ArrayList
                count++;   //increments by one by the end of the loop so it stops user from ordering 10+ items if count = 10
            }
            //Printing receipt to the screen
            System.out.println(newOrder);
            exitOrOrder(input);
        }
    } // end of psvm


    static void exitOrOrder (Scanner input){
        System.out.println("\nWould you like to place another order? Type 'Yes' or 'No': " );
        String exitOption = input.nextLine();

        //if the input is NOT "yes," "no," etc. the loop will run until otherwise
        while(!(exitOption.equals("Yes") || exitOption.equals("No") || exitOption.equals("yes") || exitOption.equals("no"))){
            System.out.println("Invalid input, please select item from menu: ");
            exitOption = input.nextLine();
        }
        if (Objects.equals(exitOption, "no") || Objects.equals(exitOption, "No")) { // You can't do (x == "no") with strings
            System.out.println("Thanks for dining with us!");
            System.exit(0);
        }
    } //end of method


    static void printMenu (ArrayList<RestaurantItem> menu) {    //passing the ArrayList as a parameter
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.print((i+1) + ". " + menu.get(i).getName());
            if (menu.get(i) instanceof Drink){
                System.out.print(" (" + ((Drink) menu.get(i)).getSize() + " ");
                if (((Drink) menu.get(i)).hasIce()) {
                    System.out.print(", Ice)");
                }
                else {
                    System.out.print(", No Ice)");
                }
            }
            if (menu.get(i) instanceof GiftCard) {
                System.out.print(" (Custom Message)");
            }
            System.out.print( " - $" + menu.get(i).getPrice());
            if (menu.get(i) instanceof Food) {
                System.out.print(", (Contains:" + ((Food) menu.get(i)).getAllergens() + ")");
            }
            System.out.println();
        }
    }

    static RestaurantItem selectFood (ArrayList<RestaurantItem> menu, Scanner input, int option) {
        while (option < 0 || option > menu.size()) {
            System.out.println("Invalid input, please select item from menu: ");
            option = input.nextInt();
        }
        if (menu.get(option-1) instanceof GiftCard){
            GiftCard newGiftCard = new GiftCard("Gift Card");
            System.out.println("Type the amount you'd like to add to this gift card: ");
            double amount = input.nextDouble();
            input.nextLine();              //consumes a new line or sumn like that
            newGiftCard.setBalance(amount);

            System.out.println("Type the message you'd like add to the gift card: ");
            String message = input.nextLine();
            newGiftCard.setMessage(message);
            return newGiftCard;
        }
        return menu.get(option-1); //returns the RestaurantItem item chosen, -1 is accounting for the index
    }


} // end of main class


class RestaurantItem {
    private String name;
    private double price;

    RestaurantItem(String name, double price){
        this.name = name;
        this.price = validatePrice(price);
    }
    RestaurantItem(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice (double price) {
        this.price = price;
    }

    @Override //toString method
    public String toString () {
        String output = " ";
        output += "\n\t- " + getName();
        output += " ($" + String.format("%.2f", getPrice()) + ") ";
        return output;
    }

    // Input validation: Moved all the initial input validation to the
    // RestaurantItem class since Drink & others class extends from
    // RestaurantItem and not the Food class
    public String validateName(String name){
        Scanner input = new Scanner(System.in);
        while (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty, enter a valid name: ");
            name = input.nextLine();
        }
        return name;
    }
    public double validatePrice(double price){
        Scanner input = new Scanner(System.in);
        while (price < 0.00){
            System.out.println("Prices cannot be negative values. Enter a valid price: ");
            price = input.nextDouble();
        }
        return price;
    }
}   // end of RestaurantItem class


class Food extends RestaurantItem{
    private String allergens;

    public Food (String name, double price, String allergens){
        super(name, price);         //parameters from the superclass' constructor. (constructor chaining)
        this.allergens = allergens;
    }

    public String getAllergens () {
        return allergens;
    }
    public void setAllergens (String allergens) {
        this.allergens = allergens;
    }

    @Override
    public String toString(){
        String output = " ";
        output += super.toString();
        output += "[Allergens: " + getAllergens() + "]";
        return output;
    }
    //Input Validation:
    @Override
    public double validatePrice(double price) {
        return super.validatePrice(price);
    }
    @Override
    public String validateName(String name) {
        return super.validateName(name);
    }
}   // end of Food class


class Drink extends RestaurantItem{
    private String size;
    private boolean hasIce;

    public Drink (String name, double price, String size, boolean hasIce) {
        super(name,price);
        this.size = size;
        this. hasIce = hasIce;
    }

    public String getSize(){
        return size;
    }
    public void setSize(){
        this.size = size;
    }

    public boolean hasIce(){    //boolean getter
        return hasIce;          //wasn't sure what to name it but I figure
    }                           //this is the best option
    public void setIce (){
        this.hasIce = hasIce;
    }

    @Override
    public String toString(){
        String output = "";
        output += super.toString(); //adds on the superclass' toString()
        output += "(" + getSize();
        if (hasIce()){
            output += ", Ice)";
        } else {
            output += ", No Ice)";
        }
        return output;
    }

    //Input Validation:
    public double validatePrice(double price) {
       return super.validatePrice(price);
    }
    public String validateName(String name) {
        return super.validateName(name);
    }

    public String validateSize (){
        Scanner input = new Scanner(System.in);
        while (!(Objects.equals(size, "Small") || Objects.equals(size, "Medium") || Objects.equals(size, "Large"))) {
            System.out.println("Drink size must be, Small, Medium, or Large, please enter a valid input");
            size = input.nextLine();
        }
        return size;
    }
}   // end of Drink class


class GiftCard extends RestaurantItem{
    private double balance;
    private String message;

    public GiftCard (String name, double balance, String message) {
        super(name);
        this.balance = balance;
        this.message = message;
    }
    public GiftCard (String name){
        super(name);
    }


    //getter & setters
    public double getBalance () {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMessage(){
        return message;
    }
    public void setMessage (String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        String output = "";
        output += "\n\t- " + getName();
        output += " ($" + String.format("%.2f", getBalance()) + ") ";
        output += "\n\t\tMessage: " + getMessage();
        return output;
    }

    // Input Validation:
    public double validatePrice(double price) {
        return super.validatePrice(price);
    }
    public String validateName(String name) {
        return super.validateName(name);
    }
}   // end of GiftCard class


class Order {
    Scanner keyboard = new Scanner(System.in);

    private ArrayList<RestaurantItem> itemsOrdered;
    private String customerName;
    private double totalCost;

    public Order (String customerName){
        this.customerName = customerNameValidation(customerName);
        this.itemsOrdered = new ArrayList<>();

    }

    public void addItem(RestaurantItem item) {          //adds elements to ArrayList
        itemsOrdered.add(item);
        calculateTotalCost();                           //then adds the item's price to the totalCost
    }
    public double calculateTotalCost () {
        double totalCost = 0.00;                        //Anatomy of a for each loop!!
        for (RestaurantItem each : itemsOrdered) {      //for (dataType each: whatWillBeIterated){}
            totalCost += each.getPrice();
            if (each instanceof GiftCard){
                totalCost += ((GiftCard) each).getBalance();
            }
        }
        return totalCost;
    }

    @Override
    public String toString() {
        String output = "";
        output += "\n#######################################\n";
        output += "RECEIPT:\n";
        output += "Customer Name:" + getCustomerName();
        output += "\nOrdered Items:";

        for (RestaurantItem each: itemsOrdered){
            output += "\t" + each.toString();
        }

        output += "\nTOTAL COST: $" + String.format("%.2f", getTotalCost());    // tried to make the totalCost print with
        output += "\n#######################################\n";                // 2 decimal places as opposed to 1. Asked help from
        return output;                                                          // ChatGPT & learned to use String.format() which is
    }                                                                           // similar to printf();

    public String getCustomerName() {
        return customerName;
    }
    public double getTotalCost() {
        return totalCost = calculateTotalCost();
    }

    //Input Validation;
    public String customerNameValidation(String chosenName){
        while (chosenName == null || chosenName.isEmpty()) {
            System.out.println("Name cannot be empty, enter a valid name: ");
            chosenName = keyboard.nextLine();
        }
        return chosenName;
    }
}
