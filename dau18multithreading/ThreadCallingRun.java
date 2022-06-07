package dau18multithreading;
class ThreadDemo extends Thread{
    public void run(){
        System.out.println("Thread started");
    }
}
public class ThreadCallingRun{
    public static void main(String[] args){
        ThreadDemo obj_cr=new ThreadDemo();
        obj_cr.run();
        System.out.println(Thread.currentThread());
        obj_cr.start();
        System.out.println(Thread.currentThread());
    }
}
/**Note:The run method is just another method.
 * If you call it directly, then it will execute not in another thread,
 * but in the current thread.
 * Output:
 * Thread started
 */
