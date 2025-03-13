import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Cat garfield = new Cat(); //cat object
        garfield.setName("Garfield");
        garfield.setAge(7);

        Cat crookshanks = new Cat();
        crookshanks.setName("Crookshanks");
        crookshanks.setAge(11);

        //checking if cats are older than 10 yrs
        System.out.println("Garfield is older than 10 years: " + garfield.isOld());
        System.out.println("Crookshanks is older than 10 years: " + crookshanks.isOld());

        //checking if they are the same age
        System.out.println("Garfield is the same age as Crookshanks: " + garfield.sameAge(crookshanks));

        Cat thirdCat = new Cat(); //made a 3rd cat
        System.out.println("Choose a name for your new cat");
        String thirdCatName = input.nextLine();
        thirdCat.setName(thirdCatName);


        System.out.println("Choose the age of " + thirdCatName);
        int thirdCatAge = input.nextInt();
        thirdCat.setAge(thirdCatAge);

        System.out.println("You chose the name: " + thirdCatName);
        System.out.println(thirdCatName + " is " + thirdCatAge);

        //(garfield is 7 & crook is 11)
        Cat oldestCat = findOlderCat(garfield, crookshanks, thirdCat);
        System.out.println("Oldest cat: " + oldestCat.getName() + ", they are " + oldestCat.getAge() + " years old");

    }

    //determining who is older
    static Cat findOlderCat (Cat cat1, Cat cat2, Cat cat3) {
        Cat oldestCat = cat1;

        if (cat2.getAge() > oldestCat.getAge()){
            oldestCat = cat2;
        }
        if (cat3.getAge() > oldestCat.getAge()){
            oldestCat = cat3;
        }
        return oldestCat;
    }
}

class Cat {
    private int age;
    private String name;

    //constructor, must be public
    public Cat(){
       age = 0;
    }

    public Cat(int initialAge){ //overloaded constructor

    }

    int getAge(){ // getter
        return age;
    }

   void setAge(int newAge){ //setter
        age = newAge;
    }

    void setAge (String newAge) {
        age = Integer.parseInt(newAge);
    }

    void setName (String newName) {
        name = newName;
    }

    String getName() {
        return name;
    }

    boolean isOld(){
        return age > 10;
    }

    boolean sameAge(Cat anotherCat){
        return age == anotherCat.age;
    }

    void birthday(){ //mutator method
        age++; //increments by 1
    }
}
