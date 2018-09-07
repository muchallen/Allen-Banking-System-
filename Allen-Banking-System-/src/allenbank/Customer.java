/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allenbank;


public class Customer {
 String firstName,Surname,ssn;
         Account account;

    Customer(Account account, String fname, String sname, String ssn) {
        this.firstName=fname;
                this.Surname=sname;
                this.ssn=ssn;
                this.account=account;
    }
    
    @Override
    
    public  String toString(){
        return "/Customer Details/"+
                "FirstName: "+firstName+"\n"+
                "Surname: "+Surname+"\n"+
                "Account Number: "+account.getAccountNumber()+"\n";
    }
    
    public  String basicInfo(){
        return 
                "FirstName: "+firstName+"\n"+
                "Surname: "+Surname+"\n"+
                "Account Number: "+account.getAccountNumber()+"\n";
    }
    
    
    
    Account getAccount(){
        return account;      
    }
}
