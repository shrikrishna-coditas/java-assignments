class Addition{
    public void add(){
        int a=25,b=7,sum=0;
        sum=a+b;
        System.out.println("Sum of "+a+" and "+b+" is "+sum);
    }
}
class Subtraction{
    int a=10,b=3;
    public int sub(){
        return a-b;
    }
}
class Multiplication{
    public int mult(int a,int b){
        return a*b;
    }
}
class Division{
    int a=20,b=7;
    public double div(){
        return (double) a/b;
    }
}

public class Calculator {
    static short c;
    static byte d;
    public static void main(String[] args){
        Addition objAdd=new Addition();
        objAdd.add();
        Subtraction objSub=new Subtraction();
        System.out.println("Subtraction of "+objSub.a+" and "+objSub.b+" is "+objSub.sub());
        int a=12,b=5;
        Multiplication objMult=new Multiplication();
        System.out.println("Multiplication of "+a+" and "+b+" is "+objMult.mult(a,b));
        Division objDiv=new Division();
        System.out.println("Division of "+objDiv.a+" and "+objDiv.b+" is "+objDiv.div());
        System.out.println(c+" "+d);
    }
}
