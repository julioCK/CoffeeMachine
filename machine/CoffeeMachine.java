package machine;


import java.util.LinkedHashMap;
import java.util.Map;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCupsAmount;
    private double money;
    private int cupsOfCoffeeAmount;

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
        instantMachineStock.put("coffee", this.coffeeBeans);
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
        int[] espressoIng = new int[] {250, 16, 1};
        int[] currentStock = new int [] {this.water, this.coffeeBeans, this.disposableCupsAmount};

        for (int i = 0; i < 3; i++) {
            if (espressoIng[i] > currentStock[i])
                System.out.println();
        }

        setWater(this.water - 250);
        setCoffeeBeans(this.coffeeBeans - 16);
        setDisposableCupsAmount(this.disposableCupsAmount - 1);
        setMoney(this.money + 4);
    }
    protected void dropLatte() {
        setWater(this.water - 350);
        setMilk(this.milk - 75);
        setCoffeeBeans(this.coffeeBeans - 20);
        setDisposableCupsAmount(this.disposableCupsAmount - 1);
        setMoney(this.money + 7);
    }
    protected void dropCappuccino() {
        setWater(this.water - 200);
        setMilk(this.milk - 100);
        setCoffeeBeans(this.coffeeBeans - 12);
        setDisposableCupsAmount(this.disposableCupsAmount - 1);
        setMoney(this.money + 6);
    }
    protected void withdrawMoney() {
        setMoney(0);
    }
}
