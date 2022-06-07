package session26jdk10_11Updates;

import java.util.Optional;

public class OptionalClassDemo {
    public static void main(String[] args){
        String[] items=new String[5];
        Optional<String> stringOptional=Optional.ofNullable(items[3]);
        items[2]="Hello";

        //checking whether data is present or not
        if(stringOptional.isPresent()){
            System.out.println(items[3]);
        }
        else{
            System.out.println("Item[3] is null");
        }

        //checking for non-empty Optional
        Optional<String> value=Optional.of(items[2]);
        System.out.println("Item[2] is"+value.get());
        System.out.println("Value present or not:"+value.isPresent());
    }
}

/**Output:
 * Item[3] is null
 * Item[2] isHello
 * Value present or not:true
 */