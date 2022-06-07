package day20CollectionsFramework;

import java.util.*;

public class ListExample {
    public static void main(String[] args){
        List<Integer> intList=new ArrayList<>();


        //adding data
        intList.add(4);
        intList.add(1);
        intList.add(17);
        intList.add(4);
        intList.add(9);
        intList.add(3);
        intList.add(null);

        //printing data
        System.out.println(intList);

        ListIterator<Integer> listIterator=intList.listIterator();
        System.out.println("Forward direction");
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println("Backward direction");
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

    }
}

/**Output:
 * for ArrayList:
 * Duplicates: Allowed
 * Null values: Allowed
 * Order: Inserted order
 *
 * for LikedList:
 * Duplicates: Allowed
 * Null values: Allowed
 * Order: Inserted order
 *
 * for Vector:
 * Duplicates: Allowed
 * Null values: Allowed
 * Order: Inserted order
 */