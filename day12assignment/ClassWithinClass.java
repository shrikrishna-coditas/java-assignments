package day12assignment;
class Outer{
    int var;

    public void show(){
        System.out.println("Outer class method");
    }

    class Inner{
        public void display(){
            System.out.println("Inner class method");
        }
    }
}


public class ClassWithinClass {
    public static void main(String[] args) {
        Outer obj_outer = new Outer();
        obj_outer.show();

        Outer.Inner obj_inner=obj_outer.new Inner();
        obj_inner.display();
    }
}
