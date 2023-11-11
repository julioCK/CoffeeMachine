package machine;


public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cupsOfCoffeeAmount;
    private int disposableCupsAmount;
    private double money;
    private final Cup cups = new Cup();

    public int getWater() {
        return this.water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCupsOfCoffeeAmount() {
        return this.cupsOfCoffeeAmount;
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

    private void setCupsOfCoffeeAmount(int cupsOfCoffeeAmount) {
        if(cupsOfCoffeeAmount > 0)
            this.cupsOfCoffeeAmount = cupsOfCoffeeAmount;
        else
            this.cupsOfCoffeeAmount = 0;
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
        setCupsOfCoffeeAmount(maxCups);
    }

    public void displayStatus() {
        System.out.printf(
                """
                        The coffee machine has:
                        %d ml of water
                        %d ml of milk
                        %d g of coffee beans
                        %d disposable cups
                        $%.0f of money
                        """,
                this.water, this.milk, this.coffeeBeans, this.disposableCupsAmount, this.money
        );
    }
}
