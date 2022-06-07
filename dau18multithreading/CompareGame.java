package dau18multithreading;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CompareGame {
    static short first=0;
    static short second=0;
    static JLabel lblFirst = new JLabel("First");
    static JLabel lblSecond = new JLabel("Second");
    private JFrame frame;
    static String math = null;
    JButton btnReset = new JButton("Reset");
    JButton btnGo = new JButton("Go");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CompareGame window = new CompareGame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CompareGame() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("CompareGame");
        frame.setBounds(100, 100, 432, 279);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setBounds(161, 30, 81, 14);
        frame.getContentPane().add(lblWelcome);

        lblFirst.setBounds(88, 75, 46, 14);
        frame.getContentPane().add(lblFirst);

        JLabel lblMath = new JLabel("Math");
        lblMath.setHorizontalAlignment(SwingConstants.CENTER);
        lblMath.setBounds(178, 75, 46, 14);
        frame.getContentPane().add(lblMath);

        lblSecond.setBounds(285, 75, 46, 14);
        frame.getContentPane().add(lblSecond);

        JButton btnLeft = new JButton("<");
        btnLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {lblMath.setText("<");
            }
        });
        btnLeft.setBounds(38, 114, 89, 23);
        frame.getContentPane().add(btnLeft);

        JButton btnMid = new JButton("=");
        btnMid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {lblMath.setText("=");
            }
        });
        btnMid.setBounds(166, 114, 89, 23);
        frame.getContentPane().add(btnMid);

        JButton btnRight = new JButton(">");
        btnRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {lblMath.setText(">");
            }
        });
        btnRight.setBounds(285, 114, 89, 23);
        frame.getContentPane().add(btnRight);

        class Countdown implements Runnable{
            public void run(){
                long time=System.currentTimeMillis();
                long future=time+2*1000;            //2 seconds countdown time
                while(time<future){
                    time=System.currentTimeMillis();}
                btnGo.doClick();
            }
        }

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                lblWelcome.setText(null);
                lblMath.setText("?");
                btnLeft.setEnabled(true);btnMid.setEnabled(true);
                btnRight.setEnabled(true);
                math();
                Countdown Time=new Countdown();
                new Thread(Time).start();
                //Thread t=new Thread(Time);
                //t.start();
            }
        });
        btnReset.setBounds(166, 192, 89, 23);
        frame.getContentPane().add(btnReset);
       // btnGo.setText("Go");
        btnGo.addActionListener(new ActionListener() {  // I used button to do job
            public void actionPerformed(ActionEvent e) {
                String result=lblMath.getText();
                if(result==math)
                {lblMath.setText("?");
                    math();
                    Countdown Time=new Countdown();
                    new Thread(Time).start();}
                else
                {lblWelcome.setText("Game Over");
                    btnLeft.setEnabled(false);btnMid.setEnabled(false);
                    btnRight.setEnabled(false);}
            }
        });
        btnGo.setBounds(1, 1, 1, 1);
        frame.getContentPane().add(btnGo);
        btnGo.setVisible(false);
    }
    private static String math(){        // creat number
        Random random=new Random();
        first=randomShort(1, 100, random );
        lblFirst.setText(String.valueOf(first));
        second=randomShort(1,100,random);
        lblSecond.setText(String.valueOf(second));
        if (first<second) math="<";
        if (first==second)math="=";
        if (first>second) math=">";
        return math;
    }
    private static short randomShort(int i, int j, Random random) { //random number
        short range = (short) (j - i + 1);
        short fraction = (short) (range * random.nextDouble());
        short randomNumber = (short) (fraction + i);
        return randomNumber;}
}
