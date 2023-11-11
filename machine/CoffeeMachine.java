package machine;


public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCupsAmount;
    private double money;
    private int cupsOfCoffeeAmount;
    private final Cup cups = new Cup();

    public int getWater() {return this.water;}
    public int getMilk() {return this.milk;}
    public int getCoffeeBeans() {return this.coffeeBeans;}
    public int getCupsOfCoffeeAmount() {return this.cupsOfCoffeeAmount;}
    public int getDisposableCupsAmount() {return this.disposableCupsAmount;}
    public double getMoney() {return this.money;}

    private void setWater(int water) {this.water = Math.max(water, 0);}
    private void setMilk(int milk) {this.milk = Math.max(milk, 0);}
    private void setCoffeeBeans(int coffeeBeans) {this.coffeeBeans = Math.max(coffeeBeans, 0);}
    private void setDisposableCupsAmount(int disposableCupsAmount) {this.disposableCupsAmount = Math.max(disposableCupsAmount, 0);}
    private void setMoney(double money) {this.money = Math.max(money, 0);}
    private void setCupsOfCoffeeAmount(int cupsOfCoffeeAmount) {this.cupsOfCoffeeAmount = Math.max(cupsOfCoffeeAmount, 0);}

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCupsAmount, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCupsAmount = disposableCupsAmount;
        this.money = money;
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
    protected void fillStock(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        setWater(water);
        setMilk(milk);
        setCoffeeBeans(coffeeBeans);
        setDisposableCupsAmount(disposableCups);
        setMoney(money);
    }
    protected void dropEspresso() {
        setWater(this.water - 250);
        setCoffeeBeans(this.coffeeBeans - 16);
        setMoney(this.money + 4);
        setDisposableCupsAmount(this.disposableCupsAmount - 1);
    }
    protected void dropLatte() {
        setWater(this.water - 350);
        setMilk(this.milk - 75);
        setCoffeeBeans(this.coffeeBeans - 20);
        setMoney(this.money + 7);
        setDisposableCupsAmount(this.disposableCupsAmount - 1);
    }
    protected void dropCappuccino() {
        setWater(this.water - 200);
        setMilk(this.milk - 100);
        setCoffeeBeans(this.coffeeBeans - 12);
        setMoney(this.money + 6);
        setDisposableCupsAmount(this.disposableCupsAmount - 1);
    }
    protected void withdrawMoney() {
        setMoney(0);
    }
}
