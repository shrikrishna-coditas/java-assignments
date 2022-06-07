package day6assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class PrintTokens{
    public void printTokens(StringTokenizer st){
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
    public void printSeparatedTokens(StringTokenizer st){
        List<String> operators=new ArrayList<String>();
        List<String> operands=new ArrayList<String>();

        while (st.hasMoreTokens()){
            String token=st.nextToken();
            if("+()%*/".contains(token)) {
                operators.add(token);
            }
            else if(!(" ".contains(token))) {
                operands.add(token);
            }
        }

        System.out.println("Operators: "+operators);
        System.out.println("Operands: "+operands);
    }
}
public class StringTokensExample {
    public static void main(String[] args){
        StringTokenizer st=new StringTokenizer("3 + (20%2) * (20/2)","+()%*/",true);

        PrintTokens pt=new PrintTokens();
        //pt.printTokens(st);
        pt.printSeparatedTokens(st);

    }
}
