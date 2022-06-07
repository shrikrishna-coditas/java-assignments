package day12assignment;
class Outer1{
    int var;

    public void show(){
        System.out.println("Outer class method");
    }

    static class Inner{
        public void display(){
            System.out.println("Inner static class method");
        }
    }
}
public class StaticClassWithinClass {
    public static void main(String[] args){
        Outer1 obj_outer = new Outer1();
        obj_outer.show();

        Outer1.Inner obj_inner=new Outer1.Inner();
        obj_inner.display();

    }
}
