package day7assignment;
public class WrapperClass {
    public static void main(String[] args){
        int a=5;
        Integer a1=a;
        a=a1;
        System.out.println("int variable:"+a);
        System.out.println("Autoboxed Integer:"+a1);
        System.out.println("Unboxed int:"+a1);

        double b=12.8;
        Double b1=b;
        b=b1;
        System.out.println("double variable:"+b);
        System.out.println("Autoboxed Double:"+b1);
        System.out.println("Unboxed double:"+b1);

        char c='z';
        Character c1=c;
        c=c1;
        System.out.println("char variable:"+c);
        System.out.println("Autoboxed Character:"+c1);
        System.out.println("Unboxed char:"+c1);
    }
}
