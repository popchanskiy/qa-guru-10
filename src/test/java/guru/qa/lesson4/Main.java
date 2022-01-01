package guru.qa.lesson4;

public class Main {
    public static void main(String[] args) {
        AbstractPet cat = new Cat(2, "Musiya", 4, "black");
        AbstractPet parrot = new Parrot(300, "Flint", 2, "red");
        cat.say();
        parrot.say();
    }


}
