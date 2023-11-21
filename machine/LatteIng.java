package machine;

public enum LatteIng {
    WATER(350),
    MILK(75),
    COFFEE_BEANS(20),
    DISPOSABLE_CUPS(1),
    PRICE(7);

    final int amount;

    LatteIng(int amount){
        this.amount = amount;
    }
}
