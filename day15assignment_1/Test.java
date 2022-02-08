package day15assignment_1;

import java.util.Scanner;

class Bank {
    private int balance = 0;

    public int getBalance() {
        return balance;
    }
    public void checkDeposit(int amount) throws InvalidAmountException{
        if (amount <= 0) {
            throw new InvalidAmountException();
        }
        else {
            balance+=amount;
        }
    }
    public void checkWithDraw(int amount) throws InsufficientBalanceException{
        if (balance < amount) {
            throw new InsufficientBalanceException();
        }
        else {
            balance-=amount;
        }
    }
}
public class Test {
    public static void main(String[] args) {
        Bank obj_bank = new Bank();
        boolean i=true;
        while (i) {
            System.out.println("**MENU**");
            System.out.println("1.Deposit\n2.Withdraw\n3.Check balance\n4.Exit");
            System.out.println("Enter your choice");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            int amount;
            try {
                switch (ch) {
                    case 1:
                        System.out.println("Enter amount to deposit");
                        amount = sc.nextInt();
                        obj_bank.checkDeposit(amount);
                        System.out.println("Deposit Successful");
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw");
                        amount = sc.nextInt();
                        obj_bank.checkWithDraw(amount);
                        System.out.println("Withdraw Successful");
                        break;
                    case 3:
                        System.out.println("Balance is:"+obj_bank.getBalance());
                        break;
                    case 4: i = false;
                        break;
                }
            }
            catch (InvalidAmountException e){
                System.out.println(e.getMessage());
            }
            catch (InsufficientBalanceException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

/** Output
 * **MENU**
 * 1.Deposit
 * 2.Withdraw
 * 3.Check balance
 * 4.Exit
 * Enter your choice
 * 3
 * Balance is:0
 * **MENU**
 * 1.Deposit
 * 2.Withdraw
 * 3.Check balance
 * 4.Exit
 * Enter your choice
 * 1
 * Enter amount to deposit
 * -100
 * InvalidAmountException: Please enter values > 0
 * **MENU**
 * 1.Deposit
 * 2.Withdraw
 * 3.Check balance
 * 4.Exit
 * Enter your choice
 * 1
 * Enter amount to deposit
 * 500
 * Deposit Successful
 * **MENU**
 * 1.Deposit
 * 2.Withdraw
 * 3.Check balance
 * 4.Exit
 * Enter your choice
 * 3
 * Balance is:500
 * **MENU**
 * 1.Deposit
 * 2.Withdraw
 * 3.Check balance
 * 4.Exit
 * Enter your choice
 * 2
 * Enter amount to withdraw
 * 600
 * InsufficientBalanceException: There's no sufficient balance
 * **MENU**
 * 1.Deposit
 * 2.Withdraw
 * 3.Check balance
 * 4.Exit
 * Enter your choice
 * 3
 * Balance is:500
 * **MENU**
 * 1.Deposit
 * 2.Withdraw
 * 3.Check balance
 * 4.Exit
 * Enter your choice
 * 4
 */