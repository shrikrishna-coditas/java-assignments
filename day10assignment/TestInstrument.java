package day10assignment;

import java.util.Scanner;

abstract class Instrument{
    abstract void play();
}

class Piano extends Instrument{

    @Override
    void play() {
        System.out.println("Piano is playing tan tan tan tan ");
    }
}

class Flute extends Instrument{

    @Override
    void play() {
        System.out.println("Flute is playing toot toot toot toot");
    }
}

class Guitar extends Instrument{

    @Override
    void play() {
        System.out.println("Guitar is playing tin tin tin");
    }
}

public class TestInstrument {
    public static void main(String[] args){
        Instrument[] obj_instruments=new Instrument[10];
        Scanner sc=new Scanner(System.in);

        for (int i=0;i<10;i++){
            System.out.println("***Menu***");
            System.out.println("1.Piano\n2.Flute\n3.Guitar");
            System.out.print("Enter your choice:");
            int ch=sc.nextInt();
            System.out.println("Instrument no:"+(i+1));
            switch (ch){
                case 1:obj_instruments[i]=new Piano();
                        obj_instruments[i].play();
                        break;
                case 2:obj_instruments[i]=new Flute();
                        obj_instruments[i].play();
                        break;
                case 3:obj_instruments[i]=new Guitar();
                        obj_instruments[i].play();
                        break;
                default:System.out.println("Invalid choice");
            }
            System.out.println();
        }

        System.out.println("Indexes of Objects created:");
        for(int i=0;i<10;i++){
            if(obj_instruments[i] instanceof Piano){
                System.out.println("At index:"+i+" Piano object is present");
            }else if(obj_instruments[i] instanceof Flute){
                System.out.println("At index:"+i+" Flute object is present");
            }else{
                System.out.println("At index:"+i+" Guitar object is present");
            }

        }


    }
}
