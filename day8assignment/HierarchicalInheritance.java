package day8assignment;

class Parent{
    int adhaarNumber=1234;
    int houseNumber=101;
    String carName="Audi";

    public void display(){
        System.out.println("Parent's adhaar number:"+adhaarNumber+"\nHouse number:"+houseNumber+"\nCar Name:"+carName);
    }
}
class Daughter extends Parent{
    int adhaarNumber=1948;
    String scooterName="Activa";

    public void display(){
        System.out.println("Daughter's adhaar number:"+adhaarNumber+"\nHouse number:"+houseNumber+"\nCar Name:"+carName);
        System.out.println("Scooter Name:"+scooterName);
    }

}
class Son extends Parent{
    int adhaarNumber=7854;
    String bikeName="Yamaha";

    public void display(){
        System.out.println("Son's adhaar number:"+adhaarNumber+"\nHouse number:"+houseNumber+"\nCar Name:"+carName);
        System.out.println("Bike Name:"+bikeName);
    }
}

public class HierarchicalInheritance {
    public static void main(String[] args){
        Parent obj_p=new Parent();
        obj_p.display();
        System.out.println();

        Daughter obj_d=new Daughter();
        obj_d.display();
        System.out.println();

        Son obj_s=new Son();
        obj_s.display();
        System.out.println();

    }
}
