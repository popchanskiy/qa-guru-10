package guru.qa.lesson4;

import java.util.AbstractMap;

public abstract class AbstractPet {
   private double petAge;
   private String petName;
   private int pawsAmount;

    public AbstractPet(double petAge, String petName, int pawsAmount) {
        this.petAge = petAge;
        this.petName = petName;
        this.pawsAmount = pawsAmount;
    }

    public abstract void move();

    public abstract void say();

   public   abstract  void toEat();



}
