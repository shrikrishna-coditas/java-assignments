package day3assignment;

import java.util.Arrays;

public class JaggedArrays {
    public static void main(String[] args){
        int[][] firstArray={{1,4,6},{7,9},{2,8,4,3}};
        int[][] secondArray={{2,8,3},{5,8},{1,0,7,4}};

        System.out.println("First Array : ");
        for(int i=0;i<firstArray.length;i++)
            System.out.println(Arrays.toString(firstArray[i]));

        System.out.println("Second Array : ");
        for(int i=0;i<secondArray.length;i++)
            System.out.println(Arrays.toString(secondArray[i]));

        for(int i=0;i<firstArray.length && i<secondArray.length;i++){
            for(int j=0;j<firstArray[i].length && j<secondArray[i].length;j++){
                firstArray[i][j]+=secondArray[i][j];
            }
        }
        System.out.println("Sum of first array and second array  : ");
        for(int i=0;i<firstArray.length;i++)
            System.out.println(Arrays.toString(firstArray[i]));

    }
}
