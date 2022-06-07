package day12assignment;

abstract class Anonymous{
    abstract public void show();
}
public class AnonymousClass {
    public static void main(String[] args){
        Anonymous obj_an=new Anonymous() {
            @Override
            public void show() {
                System.out.println("Anonymous class method");
            }
        };

        obj_an.show();
    }
}
