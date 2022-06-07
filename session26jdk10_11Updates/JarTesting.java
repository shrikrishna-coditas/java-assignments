package session26jdk10_11Updates;

//importing my custom library
import com.mathhelper.calculate.Calculator;

public class JarTesting {
    public static void main(String[] args){
        Calculator c=new Calculator();
        System.out.println(c.add(2,9));
        System.out.println(c.sub(5,3));
    }
}

/**Output:
 * 11
 * 2
 */