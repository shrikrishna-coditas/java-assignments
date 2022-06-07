package session26jdk10_11Updates;

public class EpsilonExample {
    public static void main(String[] args){
        final double EPSILON = 0.0001;
        double a=6.787878900076;
        double b=6.787878900077;

        if(Math.abs(a-b) < EPSILON){
            System.out.println("Same");
        }else{
            System.out.println("not same");
        }
    }
}
