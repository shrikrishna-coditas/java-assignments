package day15assignment_1;

public class InvalidAmountException extends Exception{
    public String getMessage(){
        return "InvalidAmountException: Please enter values > 0";
    }
}
