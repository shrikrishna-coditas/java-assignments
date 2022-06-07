package session25jdk9update;

import java.util.ArrayList;
import java.util.List;

public class SafeVarargsDemo {
    @SafeVarargs
    public final void display(List<String>... items){
        for(List<String> item:items){
            System.out.println(item);
        }
    }
    public static void main(String[] args){
        SafeVarargsDemo obj_svdemo=new SafeVarargsDemo();
        List<String> itemList=new ArrayList<>();
        itemList.add("Pen");
        itemList.add("Pencil");
        itemList.add("Book");
        obj_svdemo.display(itemList);
    }
}

/**Output:
 * Without using @SafeVarargs:
 * Compile time warnings:
 * Raw use of parameterized class 'List'
 * Unchecked assignment: 'java.util.List' to 'java.util.List<java.lang.String>'
 * Runtime:
 * [Pen, Pencil, Book]
 *
 * With using @SafeVarArgs:
 * No warnings at compile time.
 * Runtime:
 * [Pen, Pencil, Book]
 */