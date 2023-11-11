package machine;

public class IngredientCalculator {
    private int water = 200;
    private int milk = 50;
    private int coffeeBeans = 15;

    public IngredientCalculator() {
    }

    public void calcIngredients(int cups){
        System.out.printf("For %d cups of coffee you will need:\n", cups);
        System.out.printf("%d ml of water\n", cups * this.water);
        System.out.printf("%d ml of milk\n", cups * this.milk);
        System.out.printf("%d g of coffee beans\n", cups * this.coffeeBeans);
    }
}
