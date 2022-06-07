package ChainOfResponsibilityPattern;

public class DivideNumbers implements Chain{
    private  Chain nextInChain;
    // Defines the next Object to receive the
    // data if this one can't use it

    public void setNextChain(Chain nextChain) {

        nextInChain = nextChain;

    }

    // Tries to calculate the data, or passes it
    // to the Object defined in method setNextChain()

    public void calculate(Numbers request) {
        if(request.getCalcWanted() == "div"){
            System.out.print(request.getNumber1() + " / " + request.getNumber2() + " = "+
                    (request.getNumber1()/request.getNumber2()));
        } else {
            System.out.print("Only works for add, sub, mult, and div");
        }
    }
}
