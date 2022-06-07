package session25jdk9update;

abstract class AnonymClass<T>{
    abstract T sum(T a,T b);
}
public class DiamondOperator {
    public static void main(String[] args){
        AnonymClass<Integer> obj_anonym=new AnonymClass<>() {
            @Override
            Integer sum(Integer a, Integer b) {
                return (a+b);
            }
        };

        Integer result=obj_anonym.sum(5,8);
        System.out.println("Addition: "+result);
    }
}

/**Output:
 * Addition: 13
 */