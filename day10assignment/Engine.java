package day10assignment;

abstract class Vehicle{
    abstract void engineDisplay();
}

class Car extends Vehicle{

    @Override
    void engineDisplay() {
        System.out.println("Car has good engine");
    }
}

class Truck extends Vehicle{

    @Override
    void engineDisplay() {
        System.out.println("Truck has bad engine");
    }
}
public class Engine {
    public static void main(String[] args){
        Vehicle obj_vehicle;

        obj_vehicle=new Car();
        obj_vehicle.engineDisplay();

        obj_vehicle=new Truck();
        obj_vehicle.engineDisplay();
    }
}
