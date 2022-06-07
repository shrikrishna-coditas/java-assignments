package dau18multithreading;

public class RunnableExample implements Runnable{
    public void run() {
        //getting current thread
        System.out.println("Thread running:"+Thread.currentThread());
        try {
            //making thread sleep for 500 milliseconds
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        RunnableExample re=new RunnableExample();

        //creating threads
        Thread t1=new Thread(re);
        Thread t2=new Thread(re);
        Thread t3=new Thread(re);

        //setting names for threads
        t1.setName("T1 Thread");
        t2.setName("T2 Thread");
        t3.setName("T3 Thread");

        //setting priorities for threads
        t3.setPriority(10);
        t2.setPriority(5);
        t1.setPriority(1);

        //starting threads
        t1.start();
        t2.start();
        t3.start();

        //printing thread state
        System.out.println("T1 state:"+t1.getState());
        System.out.println("T2 state:"+t2.getState());
        System.out.println("T3 state:"+t3.getState());
    }
}

/**Output:
 * T1 state:RUNNABLE
 * Thread running:Thread[T3 Thread,10,main]
 * T2 state:RUNNABLE
 * T3 state:TIMED_WAITING
 * Thread running:Thread[T2 Thread,5,main]
 * Thread running:Thread[T1 Thread,1,main]
 */