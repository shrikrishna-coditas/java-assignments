package day15assignment;

public class ABC {
    public static void main(String[] args) {
        int[] array = new int[10]; int sum = 0;

        try {
            // good code
            for (int i = 0; i < 11; i++) {
                sum = sum + array[i];
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

}
