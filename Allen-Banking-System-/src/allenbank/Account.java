
package allenbank;

import java.util.Scanner;


public class Account {
    Scanner keyboard = new Scanner(System.in);
    private double balance;
    private double interest;
    private final int accountNumber;
    private  int value=1000000;
    public Account(){
        this.accountNumber=value+1;
    }
   
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the interest
     */
    public double getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public void withdraw(double amount){
        if((amount+5)>balance){
            System.out.println(" You have insufficient funds");
            System.exit(0);
        }
        else{
                this.balance-=(amount+5);
                System.out.print("You have withdrawn $"+amount);
                System.exit(0);
        }
        
    }
    
    public void deposite(double amount){
        if(amount<=0){
            System.out.println(" You cannot deposite a negative amount");
            System.exit(0);     
        }
        else{
            this.balance+=(amount);
            System.out.println("You have deposited $ "+amount);
            System.exit(0);
        }
    }
}

