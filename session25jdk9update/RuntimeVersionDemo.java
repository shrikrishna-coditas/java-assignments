package session25jdk9update;

public class RuntimeVersionDemo {
    public static void main(String[] args){
        System.out.println("Minor version:"+Runtime.version().minor());
        System.out.println("Major version:"+Runtime.version().major());
    }
}

/**Output:
 * Minor version:0
 * Major version:17
 */