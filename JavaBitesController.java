/*
Alejandra Torres
CSC164 - Spring 2025
I didn't cheat
 */

package com.example.javafxassignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class RestaurantController {

    private ArrayList<RestaurantItem> menu = new ArrayList<>();

    @FXML
    private Text menuText;
    @FXML
    private MenuButton filterMenuButton;
    @FXML
    private Button resetButton;

    @FXML
    private Text burgerText;
    @FXML
    private Text saladText;
    @FXML
    private Text sodaText;
    @FXML
    private Text coffeeText;
    @FXML
    private Text giftCardText;

    @FXML
    private Button addBurgerButton;
    @FXML
    private Button addSaladButton;
    @FXML
    private Button addSodaButton;
    @FXML
    private Button addCoffeeButton;
    @FXML
    private Button addGiftCardButton;

    @FXML
    private ListView<RestaurantItem> menuListView;

    @FXML
    public void initialize() {

        menu.add(new Food("Burger", 5.99, "Gluten, Dairy"));
        menu.add(new Food("Salad", 4.49, "Nuts"));
        menu.add(new Drink("Soda", 2.99, "Large", true));
        menu.add(new Drink("Coffee", 3.49, "Medium", false));
        menu.add(new GiftCard("Gift Card", 25.00, 25.00, "Happy Birthday!"));

        menuText.setText("MENU");
        filterMenuButton.setText("Filter");
        resetButton.setText("Reset");

        // Setting the menu item's names!
        burgerText.setText(menu.get(0).getName()); //Burger
        String burgerButtonText = String.format("%.2f", menu.get(0).getPrice());     //  did this because
        addBurgerButton.setText("Add to Bag - " + burgerButtonText);                 //  addBurgerButton.setText("" + menu.get(0).getPrice());
                                                                                     //  didn't work
        saladText.setText(menu.get(1).getName());
        String saladButtonText = String.format("%.2f", menu.get(1).getPrice());
        addSaladButton.setText("Add to Bag - " + saladButtonText);

        sodaText.setText(menu.get(2).getName());
        String sodaButtonText = String.format("%.2f", menu.get(2).getPrice());
        addSodaButton.setText("Add to Bag - " + sodaButtonText);

        coffeeText.setText(menu.get(3).getName());
        String coffeeButtonText = String.format("%.2f", menu.get(3).getPrice());
        addCoffeeButton.setText("Add to Bag - " + coffeeButtonText);

        giftCardText.setText(menu.get(4).getName());
        String giftCardText = String.format("%.2f", menu.get(4).getPrice());
        addGiftCardButton.setText("Add to Bag - " + giftCardText);
    }
} // end of restaurant controller


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

    public boolean hasIce(){
        return hasIce;
    }
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

    public GiftCard (String name, double price, double balance, String message) {
        super(name, price);
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
