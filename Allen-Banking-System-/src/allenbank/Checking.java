
package allenbank;

public class Checking extends Account {
Checking(double initialDeposite) {
        super();
        this.setBalance(initialDeposite);
        if(initialDeposite>1000){
        this.setInterest(0.05);}
        else
        this.setInterest(0.02);
}
    
}
