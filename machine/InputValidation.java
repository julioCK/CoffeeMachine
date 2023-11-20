package machine;

public class InputValidation {

    public static boolean validateAlpha(String entry){
        if(!entry.matches("[a-zA-Z]+")) {
            throw new ActionInputException();
        } else
            return true;
    }
    public static boolean validateANum(String entry) {
        if(!entry.matches("\\d+") && !entry.equals("back")) {
            throw new ActionInputException();
        } else
            return true;
    }
}
