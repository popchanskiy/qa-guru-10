package guru.qa.lesson4;

public class Cat extends AbstractPet {
    private double catAge;
    private String catName;
    private int catPawsAmount;
    private String catCoatСolor;

    public Cat(double catAgeAge, String catNameName, int catPawsAmountpawsAmount, String catCoatСolorcoatСolor) {
        super(catAgeAge, catNameName, catPawsAmountpawsAmount);
        this.catCoatСolor=catCoatСolorcoatСolor;
    }


    @Override
    public void move() {
        System.out.println("Cat moving");
    }

    @Override
    public void say() {
        System.out.println("Cat saying");
    }

    @Override
    public void toEat() {
        System.out.println("Cat eating");
    }
}
