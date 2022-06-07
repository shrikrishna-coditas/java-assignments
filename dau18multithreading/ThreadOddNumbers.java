package dau18multithreading;

import java.util.Scanner;

public class ThreadOddNumbers implements Runnable{
    public void run() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value for N:");
        int n=sc.nextInt();

        for(int i=1;i<=n;i++){
            if(i % 2 != 0){
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args){
        ThreadOddNumbers obj_to=new ThreadOddNumbers();
        Thread t=new Thread(obj_to);
        t.start();
    }
}

/**Output:
 * Enter the value for N:17
 * 1 3 5 7 9 11 13 15 17
 */