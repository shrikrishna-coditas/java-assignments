package day3assignment;

import java.util.Arrays;
import java.util.Collections;


class AscendDescend{
    public void printSorted(int[] intArray){
        Arrays.sort(intArray);
        System.out.println("Ascending order : "+Arrays.toString(intArray));
        System.out.print("Descending order : ");
        for(int i=intArray.length-1;i>=0;i--){
            System.out.print(intArray[i]+"  ");
        }

    }
}
class Duplicate{
    public void printDuplicate(int[] intArray){
        for(int i=0;i<intArray.length;i++){
            for(int j=0;j<intArray.length;j++){
                if(intArray[i]==intArray[j] && i!=j)
                    System.out.println("Duplicate element is : " +intArray[i]);
            }
        }
    }
    public void removeDuplicate(int[] intArray){
        int n=intArray.length;;
        for(int i=0;i<intArray.length;i++){
            for(int j=0;j<intArray.length;j++){
                if(intArray[i]==intArray[j] && i!=j) {
                    --n;
                    for (int k = i; k < n; k++)
                        intArray[k] = intArray[k + 1];
                }
            }
        }
    }

}

public class ArraysProgram {
    public static void main(String[] args) {
        int[] intArray = {12, 54, 3, 49, 80, 54, 33, 37, 92};
        System.out.println("Original array is : "+Arrays.toString(intArray));

        int[] newArray=Arrays.copyOf(intArray,intArray.length);
        System.out.println("Copy of array using inbuilt : "+Arrays.toString(newArray));

        AscendDescend ad=new AscendDescend();
        ad.printSorted(intArray);

        Duplicate dp=new Duplicate();
        dp.printDuplicate(intArray);

        dp.removeDuplicate(intArray);
        System.out.println("Removed Duplicates : "+Arrays.toString(intArray));

    }

}
