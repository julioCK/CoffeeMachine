package machine;

public class ActionInputException extends RuntimeException{
    ActionInputException(){
        super("Sorry, wrong input. Please try again choosing an option from the menu.");
    }
}
