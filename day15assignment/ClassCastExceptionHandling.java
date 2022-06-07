package day15assignment;

class Parent{

}
class Child extends Parent{

}
public class ClassCastExceptionHandling {
    public static void main(String[] args){
        try {
            Child obj_child = (Child) new Parent();
        }catch (ClassCastException e){
            System.out.println(e);
        }finally {
            System.out.println("Finally block of ClassCastException handling");
        }
    }
}
