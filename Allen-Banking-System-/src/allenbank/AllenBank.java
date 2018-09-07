
package allenbank;

import java.util.ArrayList;
import java.util.Scanner;


public class AllenBank {
    boolean exit;
    Scanner keyboard = new Scanner(System.in);
    Bank bank =new Bank();
    public static void main(String[] args) {
        AllenBank bank = new AllenBank();
        bank.printer();
        
    }
    
    public void printer(){
        
        printHeader();
        while(!exit){
        printMenu();
        int choice = getInput();
        perfomAction(choice);
        
                }
        
    }

    private void printHeader() {
        System.out.println("-----------------------------------------------------");
        System.out.println("|          WELCOME TO ALLEN BANK APP                |");
        System.out.println("-----------------------------------------------------");
    }

    private void printMenu() {
        
        System.out.println("1)Create a new Account");
        System.out.println("2)Makea a Withdrawal");
        System.out.println("3) Make a Deposite");
        System.out.println("4)List Account Balance");
        System.out.println("0)exit");
        System.out.println("Please enter your choice");
      
    
    }

    private int getInput() {
        int choice = -1;
        
        do {
            try{
                choice=Integer.parseInt(keyboard.next());
            if(choice<0||choice>4)
                System.out.print("your input is out of range");

            }
            catch(NumberFormatException e){
                System.out.print("Please enter a number!");
            }
        } 
        while(choice<0||choice>4);
        return choice;
    }

    private void perfomAction(int choice) {
       
        switch(choice){
            case(0): 
                System.out.print("Thank you for choosing our Bank");
                System.exit(0);
                break;
            case(1):
                createAccount();
                break;
            case(2):
                makeWithdrawal();
                break;
            case(3):
                makeDeposite();
            case(4):
                listAccountBalance();
            default:
                System.out.print("System Error");
                System.exit(0);
                       
            
                    
                
                 
            
        }
        
    }

    private void createAccount() {
        String fname,sname,account="",ssn;
        double initialDeposite=0.0;
        boolean valid=false;
        
         System.out.println("Please enter your Account Type(Savings/Checkings)");
        while(!valid){
        account=keyboard.nextLine();
        if(account.equalsIgnoreCase("savings")||account.equalsIgnoreCase("Checking")){
            valid = true;
        }
        }
        if(account.equalsIgnoreCase("savings")){
            System.out.println("Enter You Initial Deposite");
            initialDeposite=Double.parseDouble(keyboard.next());
            if(initialDeposite<100){
                System.out.print("You cannot create a savings account with value less than $100");
                System.exit(0);
            }
        }
        if(account.equalsIgnoreCase("checking")){
            System.out.println("Enter You Initial Deposite");
            initialDeposite=Double.parseDouble(keyboard.next());
            if(initialDeposite<100){
                System.out.print("You cannot create a checking account with value less than $50");
                System.exit(0);
            }
        }
            
        System.out.println("enter your first name");
        fname=keyboard.next();
        System.out.println("enter your Last name");
        sname=keyboard.next();
        System.out.println("enter your Social Security Number");
        ssn=keyboard.next();
        
         Account accounts=null;
         if(account.equalsIgnoreCase("checking"))
         accounts=new Checking(initialDeposite);
         else if(account.equalsIgnoreCase("savings"))
             accounts = new Savings(initialDeposite);
        Customer customer = new Customer(accounts, fname, sname, ssn);
        bank.addCustomer(customer);
        
    }
    
    private void makeWithdrawal() {
        int account=selectaccount();
        System.out.print("please enter your deposit amount");
        double amount=0.0;
        try{
           amount=Double.parseDouble(keyboard.next());            
        }
        catch(Exception e){
            amount=-1;
            
        }
        bank.getCustomer(account).getAccount().withdraw(amount);
       
    }

    private void makeDeposite() {
        int account=selectaccount();
        System.out.print("please enter your deposit amount");
        double amount=0;
        try{
           amount=Double.parseDouble(keyboard.next());            
        }
        catch(Exception e){
            amount=-1;
            
        }
        bank.getCustomer(account).getAccount().deposite(amount);
            
            
    }

    private void listAccountBalance() {
       
    }

    private int selectaccount() {
        ArrayList<Customer> customers =bank.customer();
        System.out.println("Please enter your account number from the listed");
        for(int i=0; i<customers.size();i++)
        {
            System.out.println((i+1)+") " +customers.get(i).basicInfo());
            
        }
         int account=0;
        try{
          account=Integer.parseInt(keyboard.next())-1;            
        }
        catch(Exception e){
            account=-1;
        }
       
     return account;
       
    }
    
}
