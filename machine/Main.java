package machine;

import java.util. Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        CoffeeMachine machine1 = new CoffeeMachine(400, 540, 120, 9, 550.0);

        String action;

        do{
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scan.next();

            switch(action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String option = scan.next();
                    switch (option) {
                        case "1":
                            machine1.dropEspresso();
                            break;
                        case "2":
                            machine1.dropLatte();
                            break;
                        case "3":
                            machine1.dropCappuccino();
                            break;
                        case "back":
                            break;
                    }
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
                    break;

                case "take":
                    double totalMoney = machine1.getMoney();
                    System.out.printf("I gave you $%.0f\n", totalMoney);
                    machine1.withdrawMoney();
                    break;

                case "remaining":
                    machine1.displayStatus();
                    break;

                default:
                    if(!action.equals("exit")) {
                        System.out.println("Please enter with one of the options:");
                        System.out.println("(buy, fill, take, remaining, exit)");
                    } else
                        break;
            }
        } while (!action.equals("exit"));
    }
}
