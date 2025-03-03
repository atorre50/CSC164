public class Main {
    public static void main(String[] args) {
        Cat garfield = new Cat();
        garfield.age = 90; //dot operator used to access age

        Cat kitty = new Cat(); // this will be passed to the anotherCat method
        kitty.age = 55;

        System.out.println(garfield.sameAge(kitty));

        garfield.birthday(); // mutator method: modifies the object
        System.out.println(garfield.age); //incremented by 1

        System.out.print("Garfield's age is greater than 10..? " + garfield.isOld());
    }
}

class Cat {
    int age;
    //constructor
    Cat(){
       age = 0;
    }

    int getAge(int age){
        return age;
    }

    void setAge(int newAge){
        age = newAge;
    }

    void setAge (String newAge) {
        age = Integer.parseInt(newAge);
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
