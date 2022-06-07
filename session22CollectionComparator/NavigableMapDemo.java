package session22CollectionComparator;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {
    public static void main(String[] args){
        NavigableMap<Integer,String> nmap=new TreeMap<Integer,String>();

        nmap.put(45,"K");
        nmap.put(22,"R");
        nmap.put(1,"I");
        nmap.put(67,"S");

        System.out.println("Navigable Map:"+nmap);
        System.out.println("Floor entry:"+nmap.floorEntry(23));
        System.out.println("First entry:"+nmap.firstEntry());
        System.out.println("Last entry:"+nmap.lastEntry());
        System.out.println("Value of 67:"+nmap.get(67));
        System.out.println("Descending map:"+nmap.descendingMap());
        System.out.println("******Iteration******");
        Iterator itr=nmap.entrySet().iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
