package dau18multithreading;

public class MultiStart extends Thread{
    public void run(){
        System.out.println("Thread started");
    }
    public static void main(String[] args){
        MultiStart obj_mt=new MultiStart();
        obj_mt.start();
        obj_mt.start();
    }
}

/**Note: we get exception because when we call the thread.start()
 * the thread state will be changed to Runnable,so again we can't make it Runnable.
 * Output:
 * Thread started
 * Exception in thread "main" java.lang.IllegalThreadStateException
 * at java.lang.Thread.start(Thread.java:708)
 * at dau18multithreading.MultiStart.main(MultiStart.java:10)
 */