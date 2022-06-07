package day12assignment;

class CPU {
    double price;

    // nested class
    class Processor {

        // members of nested class
        double cores;
        String manufacturer;

        double getCache() {
            return 4.3;
        }
    }

    // nested protected class
    protected class RAM {

        // members of protected nested class
        double memory;
        String manufacturer;

        double getClockSpeed() {
            return 5.5;
        }
    }
}

public class Assignment {
    public static void main(String[] args){
        CPU obj_cpu=new CPU();

        CPU.Processor obj_processor=obj_cpu.new Processor();
        System.out.println("Nested class method:"+obj_processor.getCache());

        CPU.RAM obj_ram=obj_cpu.new RAM();
        System.out.println("Nested class static method:"+obj_ram.getClockSpeed());
    }
}
