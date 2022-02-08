package day15assignment_1;

public class InsufficientBalanceException extends Exception {
    public String getMessage(){
        return "InsufficientBalanceException: There's no sufficient balance";
    }

}
