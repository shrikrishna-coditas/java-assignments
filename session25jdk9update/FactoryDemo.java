package session25jdk9update;

import java.util.Map;
import java.util.Set;

public class FactoryDemo {
    public void FactoryMethodForSet(){
        Set<Integer> numberSet=Set.of(2,4,6,8,10);
        for(Integer i:numberSet){
            System.out.println(i);
        }
    }
    public void FactoryMethodForMap(){
        Map<Integer,String> studentMap=Map.of(1,"Krishna",2,"Rohit",3,"Karan");
        for(Map.Entry<Integer,String> entry:studentMap.entrySet()){
            System.out.println(entry);
        }
    }
    public static void main(String[] args){
        FactoryDemo obj_factory=new FactoryDemo();
        System.out.println("*****Factory Demo for Set*****");
        obj_factory.FactoryMethodForSet();
        System.out.println("*****Factory Demo for Map*****");
        obj_factory.FactoryMethodForMap();
    }
}

/**Output:
 * *****Factory Demo for Set*****
 * 4
 * 6
 * 8
 * 10
 * 2
 * *****Factory Demo for Map*****
 * 3=Karan
 * 1=Krishna
 * 2=Rohit
 */