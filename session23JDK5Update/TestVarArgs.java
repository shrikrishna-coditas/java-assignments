package session23JDK5Update;

class Addition{
    public int add(int a,int b){
        return a + b;
    }
    public int add(int a,int b,int c){
        return a + b + c;
    }
}
class VarArgsAddition{
    public int add(int... a){
        int sum = 0;
        for(int i: a){
            sum += i;
        }
        return sum;
    }
}
public class TestVarArgs {
    public static void main(String args[]){
        Addition obj_add=new Addition();
        System.out.println("Add method with 2 param's: "+obj_add.add(2,5));
        System.out.println("Add method with 3 param's: "+obj_add.add(4,7,9));

        VarArgsAddition obj_vadd=new VarArgsAddition();
        System.out.println("Add method with var-args: "+obj_vadd.add(8,10));
        System.out.println("Add method with var-args: "+obj_vadd.add(45,6,9));
        System.out.println("Add method with var-args: "+obj_vadd.add(8,55,33,77));
    }
}

/**Output:
 * Add method with 2 param's: 7
 * Add method with 3 param's: 20
 * Add method with var-args: 18
 * Add method with var-args: 60
 * Add method with var-args: 173
 */