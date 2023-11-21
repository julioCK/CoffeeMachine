package machine;


import java.util.LinkedHashMap;
import java.util.Map;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCupsAmount;
    private double money;
    //private int cupsOfCoffeeAmount;

    public int getWater() {return this.water;}
    public int getMilk() {return this.milk;}
    public int getCoffeeBeans() {return this.coffeeBeans;}
    //public int getCupsOfCoffeeAmount() {return this.cupsOfCoffeeAmount;}
    public int getDisposableCupsAmount() {return this.disposableCupsAmount;}
    public double getMoney() {return this.money;}

    private void setWater(int water) {this.water = Math.max(water, 0);}
    private void setMilk(int milk) {this.milk = Math.max(milk, 0);}
    private void setCoffeeBeans(int coffeeBeans) {this.coffeeBeans = Math.max(coffeeBeans, 0);}
    private void setDisposableCupsAmount(int disposableCupsAmount) {this.disposableCupsAmount = Math.max(disposableCupsAmount, 0);}
    private void setMoney(double money) {this.money = Math.max(money, 0);}
    //private void setCupsOfCoffeeAmount(int cupsOfCoffeeAmount) {this.cupsOfCoffeeAmount = Math.max(cupsOfCoffeeAmount, 0);}

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCupsAmount, double money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCupsAmount = disposableCupsAmount;
        this.money = money;
    }

    private Map<String, Integer> MapStock() {
        Map<String, Integer> instantMachineStock = new LinkedHashMap<>(5);
        instantMachineStock.put("water", this.water);
        instantMachineStock.put("milk", this.milk);
        instantMachineStock.put("coffeeBeans", this.coffeeBeans);
        instantMachineStock.put("disposableCups", this.disposableCupsAmount);

        return instantMachineStock;
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
                        \n""",
                this.water, this.milk, this.coffeeBeans, this.disposableCupsAmount, this.money
        );
    }
    protected void fillStock(int water, int milk, int coffeeBeans, int disposableCups) {
        setWater(getWater() + water);
        setMilk(getMilk() + milk);
        setCoffeeBeans(getCoffeeBeans() + coffeeBeans);
        setDisposableCupsAmount(getDisposableCupsAmount() + disposableCups);
    }
    protected void dropEspresso() {
        Map<String, Integer> machineStock = MapStock(); //create a map with the current amount of each ingredient on stock
        Map<String, Integer> espressoIngredients = new LinkedHashMap<>(); //create a map that will contain the ingredients needed to make an espresso

        espressoIngredients.put("water", EspressoIng.WATER.amount); //water to make one espresso
        espressoIngredients.put("coffeeBeans", EspressoIng.COFFEE_BEANS.amount); //milk to make one espresso
        espressoIngredients.put("disposableCups", EspressoIng.DISPOSABLE_CUPS.amount); //disposable cups to make one espresso


        /*
            the next loop will iterate over the map of espresso ingredients. The Map.entry "entry" will contain
            one pair "key-value" of espresso ingredients each iteration.

            The "espressoIngredients.entrySet()" returns a set of all key-value pairs of the map "espressoIngredients".
                -On each iteration the key(.getKey()) will be saved in the "ingredient" variable.
                -The if statement will test if value (of the ingredient) exceeds the amount in stock
                -If the stock amount is not enough for one espresso, the message "Sorry..." will be displayed and the function
                 will end.
                -Otherwise the machine will drop the coffee
        */


        for (Map.Entry<String, Integer> entry : espressoIngredients.entrySet()) {
            String ingredient = entry.getKey();
            if(entry.getValue() > machineStock.get(ingredient)) {
                System.out.println("Sorry, not enough " + ingredient);
                return;
            }
        }

        System.out.println("I have enough resources, making you a coffee!");
        setWater(this.water - EspressoIng.WATER.amount);
        setCoffeeBeans(this.coffeeBeans - EspressoIng.COFFEE_BEANS.amount);
        setDisposableCupsAmount(this.disposableCupsAmount - EspressoIng.DISPOSABLE_CUPS.amount);
        setMoney(this.money + EspressoIng.PRICE.amount);
    }
    protected void dropLatte() {
        Map<String, Integer> machineStock = MapStock();
        Map<String, Integer> latteIngredients = new LinkedHashMap<>();

        latteIngredients.put("water", LatteIng.WATER.amount);
        latteIngredients.put("milk", LatteIng.MILK.amount);
        latteIngredients.put("coffeeBeans", LatteIng.COFFEE_BEANS.amount);
        latteIngredients.put("disposableCups", LatteIng.DISPOSABLE_CUPS.amount);

        for (Map.Entry<String, Integer> entry : latteIngredients.entrySet()) {
            String ingredient = entry.getKey();
            if(entry.getValue() > machineStock.get(ingredient)) {
                System.out.println("Sorry, not enough " + ingredient);
                return;
            }
        }

        System.out.println("I have enough resources, making you a coffee!");
        setWater(this.water - LatteIng.WATER.amount);
        setMilk(this.milk - LatteIng.MILK.amount);
        setCoffeeBeans(this.coffeeBeans - LatteIng.COFFEE_BEANS.amount);
        setDisposableCupsAmount(this.disposableCupsAmount - LatteIng.DISPOSABLE_CUPS.amount);
        setMoney(this.money + LatteIng.PRICE.amount);
    }
    protected void dropCappuccino() {
        Map<String, Integer> machineStock = MapStock();
        Map<String, Integer> cappuccinoIngredients = new LinkedHashMap<>();

        cappuccinoIngredients.put("water", CappuccinoIng.WATER.amount);
        cappuccinoIngredients.put("milk", CappuccinoIng.MILK.amount);
        cappuccinoIngredients.put("coffeeBeans", CappuccinoIng.COFFEE_BEANS.amount);
        cappuccinoIngredients.put("disposableCups", CappuccinoIng.DISPOSABLE_CUPS.amount);

        for(Map.Entry<String, Integer> entry : cappuccinoIngredients.entrySet()) {
            String ingredient = entry.getKey();
            if(entry.getValue() > machineStock.get(ingredient)) {
                System.out.println("Sorry, not enough " + ingredient);
                return;
            }
        }

        System.out.println("I have enough resources, making you a coffee!");
        setWater(this.water - CappuccinoIng.WATER.amount);
        setMilk(this.milk - CappuccinoIng.MILK.amount);
        setCoffeeBeans(this.coffeeBeans - CappuccinoIng.COFFEE_BEANS.amount);
        setDisposableCupsAmount(this.disposableCupsAmount - CappuccinoIng.DISPOSABLE_CUPS.amount);
        setMoney(this.money + CappuccinoIng.PRICE.amount);
    }
    protected void withdrawMoney() {
        setMoney(0);
    }
}
