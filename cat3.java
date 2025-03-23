/*
Alejandra Torres
CSC Spring Semester 2025
I didn't cheat
 */

import java.util.Objects;       //imported in order to do for example, (String == 20)
import  java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Cat garfield = new Cat();
        garfield.setAge(50);

        Bird tweety = new Bird();
        tweety.setAge(30);
        tweety.setAltitude(200);

        garfield.speak();
        System.out.println("garfield's stater age: " + garfield.getAge());
        garfield.birthday();        //garfield ages by 1
        System.out.println("garfield's current age: " + garfield.getAge());

        System.out.println();       //empty line, just for visual purposes

        tweety.speak();
        System.out.println("tweety's stater age: " + tweety.getAge());
        tweety.birthday();
        System.out.println("tweety's current age: " + tweety.getAge());

        System.out.println("\nis garfield is older than 10 years? " + garfield.isOld());
        System.out.println("Are tweety & garfield the same age? " + tweety.sameAge(garfield));

        Animal jellyfish = new Animal();
        jellyfish.speak();      //this jellyfish only has the ability to age or make noises, it cannot have altitude

    }                           // end of public static void main
}                               //end of class Main


class Animal {                  // Superclass
    private int age;

    Animal(){
        System.out.println("A new animal has been created...");
    }

    int getAge(){               // getter
        return age;
    }
    void setAge(int newAge){    //setter
        age = newAge;
    }

    public void birthday(){
        age++;                  // increments by 1
    }
    public boolean isOld(){
        return age > 10;
    }
    boolean sameAge(Animal anotherAnimal){
        return age == anotherAnimal.age;
    }

    public void speak () {
        System.out.println("This animal is making noises");
    }
}

class Cat extends Animal {      // Subclass, inherits Animal's properties

    public void speak () {      // overloaded speak method
        System.out.println("meow meow meow!");
    }
}

class Bird extends Animal {
    private double altitude;

    public void speak () {      // overloaded speak method
        System.out.println("tweet tweet!");
    }

    public void setAltitude(double altitude){
        this.altitude=altitude;
    }
    public double getAltitude () {
        return altitude;
    }
}
