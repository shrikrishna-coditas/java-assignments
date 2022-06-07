/**1. Accessing private field using reflection
 * 2. Exploration of new methods related to reflection
 */


package session23reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Parent{
    private int data = 4;
}
public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchFieldException {
        Parent p=new Parent();

        Class obj_p=p.getClass();
        Field field=obj_p.getDeclaredField("data");
        field.setAccessible(true);
        System.out.println("Modifier of field:"+ Modifier.toString(field.getModifiers()));
        System.out.println("Private field:"+field);
        System.out.println("Private field name:"+field.getName());

        System.out.println("\n******Methods of obj_p*******");
        System.out.println("Package name:"+obj_p.getPackage());
        System.out.println("Name of class: "+obj_p.getName());
        System.out.println("Simple name of class: "+obj_p.getSimpleName());
        System.out.println("Canonical name: "+obj_p.getCanonicalName());
        System.out.println("Type name: "+obj_p.getTypeName());
        System.out.println("Class loader: "+obj_p.getClassLoader());
        System.out.println("Protection Domain: "+obj_p.getProtectionDomain());
        System.out.println("Source code path: "+obj_p.getProtectionDomain().getCodeSource());
    }
}

/**Output:
 * Modifier of field:private
 * Private field:private int session23reflections.Parent.data
 * Private field name:data
 *
 * ******Methods of obj_p*******
 * Package name:package session23reflections
 * Name of class: session23reflections.Parent
 * Simple name of class: Parent
 * Canonical name: session23reflections.Parent
 * Type name: session23reflections.Parent
 * Class loader: sun.misc.Launcher$AppClassLoader@18b4aac2
 * Protection Domain: ProtectionDomain  (file:/C:/Users/Coditas/IdeaProjects/JavaTraining/out/production/JavaTraining/ <no signer certificates>)
 *  sun.misc.Launcher$AppClassLoader@18b4aac2
 *  <no principals>
 *  java.security.Permissions@74a14482 (
 *  ("java.io.FilePermission" "\C:\Users\Coditas\IdeaProjects\JavaTraining\out\production\JavaTraining\-" "read")
 *  ("java.lang.RuntimePermission" "exitVM")
 * )
 *
 *
 * Source code path: (file:/C:/Users/Coditas/IdeaProjects/JavaTraining/out/production/JavaTraining/ <no signer certificates>)
 */