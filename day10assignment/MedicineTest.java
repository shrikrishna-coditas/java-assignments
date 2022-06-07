package day10assignment;

abstract class Medicine{
    abstract public void displayLabel();
}

class Tablet extends Medicine{
    String companyName,companyAddress;

    public Tablet(String companyName, String companyAddress) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    @Override
    public void displayLabel() {
        System.out.println("Company name:"+companyName);
        System.out.println("Company address:"+companyAddress);
        System.out.println("Note: Store it in a cool dry place");
    }
}

class Syrup extends Medicine{
    String companyName,companyAddress;

    public Syrup(String companyName, String companyAddress) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    @Override
    public void displayLabel() {
        System.out.println("Company name:"+companyName);
        System.out.println("Company address:"+companyAddress);
        System.out.println("Note: Not for 12 or below kids");
    }
}

class Ointment extends Medicine{
    String companyName,companyAddress;

    public Ointment(String companyName, String companyAddress) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    @Override
    public void displayLabel() {
        System.out.println("Company name:"+companyName);
        System.out.println("Company address:"+companyAddress);
        System.out.println("Note: For external use only");
    }
}

public class MedicineTest {
    public static void main(String[] args) {
        Medicine[] medicines = new Medicine[10];

        for (int i = 0; i < medicines.length; i++) {
            int n = 1 + (int) (Math.random() * 3);
            System.out.println("Medicine no:"+(i+1));
            switch (n){
                case 1:medicines[i]=new Tablet("Cipla","Delhi");
                       // medicines[i].displayLabel();
                        break;
                case 2:medicines[i]=new Syrup("Vicks","Bangalore");
                        //medicines[i].displayLabel();
                        break;
                case 3:medicines[i]=new Ointment("Volini","Pune");
                       // medicines[i].displayLabel();
                        break;
            }
            medicines[i].displayLabel();
            System.out.println();

        }
    }
}
