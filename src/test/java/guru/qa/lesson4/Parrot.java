package guru.qa.lesson4;

import guru.qa.lesson4.AbstractPet;

public class Parrot extends AbstractPet {
    private double parrotAge;
    private String parrotName;
    private int parrotPawsAmount;
    private String parrotPlumageСolor;

    public Parrot(double parrotAge, String parrotName, int parrotPawsAmount, String parrotPlumageСolor) {
        super(parrotAge,parrotName,parrotPawsAmount);
        this.parrotPlumageСolor=parrotPlumageСolor;

    }


    @Override
    public void move() {
        System.out.println("Parrot Flying");
    }

    @Override
    public void say() {
        System.out.println("Parrot saying");
    }

    @Override
    public void toEat() {
        System.out.println("Parrot eating");
    }
}
