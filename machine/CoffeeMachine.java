package machine;
import machine.Cup;


public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private final Cup cups = new Cup();
    private int cupsAmount;

    public int getWater() {
        return this.water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCupsAmount() {
        return this.cupsAmount;
    }

    public void setWater(int water) {
        if(water > 0)
            this.water = water;
    }

    public void setMilk(int milk) {
        if(milk > 0)
            this.milk = milk;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        if(coffeeBeans > 0)
            this.coffeeBeans = coffeeBeans;
    }

    private void setCupsAmount(int cupsAmount) {
        if(cupsAmount > 0)
            this.cupsAmount = cupsAmount;
        else
            this.cupsAmount = 0;
    }

    public CoffeeMachine(int water, int milk, int coffeeBeans) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
    }

    public void calcCurrentCupsAmount() {

        //the ingredient with the least amount is what will define the quantity of cups. The order here is important.
        int[] ingredients = new int[]{this.water, this.milk, this.coffeeBeans};
        int[] aCup = new int[]{cups.cupWater, cups.cupMilk, cups.cupCoffeeBeans};


        int ingredientIndex = 0;
        double aux;
        double smaller =(double) ingredients[2] / aCup[2];
        //this loop will find the ingredient in smaller proportion and assign its index to the ingredientIndex variable.
        for (int i = 0; i < ingredients.length; i++) {
            aux = (double) ingredients[i] / aCup[i];

            if(aux < smaller) {
                smaller = aux;
                ingredientIndex = i;
            }
        }
        int maxCups = (int) Math.floor(smaller);
        setCupsAmount(maxCups);
    }
}
