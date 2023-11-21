package machine;

public enum EspressoIng {
    WATER(250),
    COFFEE_BEANS(16),
    DISPOSABLE_CUPS(1),
    PRICE(4);

    final int amount;

    EspressoIng (int amount) {
        this.amount = amount;
    }
}
