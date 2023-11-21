package machine;

public enum CappuccinoIng {
    WATER(200),
    MILK(100),
    COFFEE_BEANS(12),
    DISPOSABLE_CUPS(1),
    PRICE(6);

    final int amount;

    CappuccinoIng(int amount) {
        this.amount = amount;
    }
}
