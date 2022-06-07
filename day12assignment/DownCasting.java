package day12assignment;

abstract class Parent{
    abstract public void downCast(Parent p);
}
class Child extends Parent{
    public void downCast(Parent p){
        if(p instanceof Child){
            Child obj_c=(Child) p;
            System.out.println("Down-casting done");
        }
    }

}
public class DownCasting {
    public static void main(String[] args){
        Parent obj_p=new Child();
        obj_p.downCast(obj_p);
    }
}
