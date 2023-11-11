package machine;

import java.util. Scanner;


public class Main {
    public static void main(String[] args) {
//        System.out.println("Write how many ml of water the coffee machine has:");
//        int mlWater = scan.nextInt();
//
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int mlMilk = scan.nextInt();
//
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        int gCoffeeBeans = scan.nextInt();
//
//        System.out.println("Write how many cups of coffee you will need:");
//        int cupsNeeded = scan.nextInt();
//
//        CoffeeMachine coffeeM = new CoffeeMachine(mlWater, mlMilk, gCoffeeBeans);
//        coffeeM.calcCurrentCupsAmount();
//        int maxCoffeeOnMachine = coffeeM.getCupsOfCoffeeAmount();
//
//        if(cupsNeeded == maxCoffeeOnMachine) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (cupsNeeded < maxCoffeeOnMachine) {
//            System.out.printf("Yes, i can make that amount of coffee (and even %d more than that)",
//                    maxCoffeeOnMachine - cupsNeeded);
//        } else {
//            System.out.printf("No, i can make only %d cup(s) of coffee", maxCoffeeOnMachine);
//        }

        Scanner scan = new Scanner(System.in);
        CoffeeMachine machine1 = new CoffeeMachine(400, 540, 120, 9, 550.0);

        machine1.displayStatus();

        System.out.println("Write action (buy, fill, take):");
        String action = scan.next();

        switch(action) {
            case "buy":
                System.out.println("""
                        What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:
                        """);
                int option = scan.nextInt();
                if (option == 1)
                    machine1.dropEspresso();
                else if (option == 2)
                    machine1.dropLatte();
                else
                    machine1.dropCappuccino();

                machine1.displayStatus();
                break;

            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                int waterFill = scan.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                int milkFill = scan.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                int coffeeFill = scan.nextInt();
                System.out.println("Write how many disposable cups you want to add:");
                int cupsFill = scan.nextInt();

                machine1.fillStock(waterFill, milkFill, coffeeFill, cupsFill);
                machine1.displayStatus();
                break;

            case "take":
                double totalMoney = machine1.getMoney();
                System.out.printf("I gave you $%.0f\n", totalMoney);
                machine1.withdrawMoney();
                machine1.displayStatus();
                break;
        }

    }
}
