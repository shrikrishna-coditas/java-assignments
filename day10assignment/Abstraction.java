package day10assignment;

abstract class Bank{
    abstract public int rateOfInterest();
    abstract public void checkIFSC();
}

class CanaraBank extends Bank{

    @Override
    public int rateOfInterest() {
        return 3;
    }

    @Override
    public void checkIFSC() {
        System.out.println("Ainapur Canara Branch:CNRB0000522");
    }
}

class ICICIBank extends Bank{

    @Override
    public int rateOfInterest() {
        return 4;
    }

    @Override
    public void checkIFSC() {
        System.out.println("Dharwad ICICI Branch:ICICI170017");
    }
}

public class Abstraction {
    public static void main(String args[]){
        Bank obj_bank;
        obj_bank=new CanaraBank();
        System.out.println("ROI of Canara Bank:"+obj_bank.rateOfInterest());
        obj_bank.checkIFSC();

        obj_bank=new ICICIBank();
        System.out.println("ROI of ICICI Bank:"+obj_bank.rateOfInterest());
        obj_bank.checkIFSC();
    }
}
