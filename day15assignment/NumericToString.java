package day15assignment;

public class NumericToString {
    public static void main(String[] args){
        try{
            String str="abc";
            int a=Integer.parseInt(str);
        }catch (NumberFormatException e){
            System.out.println(e);
        }finally {
            System.out.println("Finally block executed");
        }
    }
}
