/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allenbank;

import java.util.ArrayList;


public class Bank {
    
    ArrayList<Customer>customers = new ArrayList<>();

    void addCustomer(Customer customer) {
       customers.add(customer);
    }
    
   
    ArrayList<Customer> customer(){
        return customers;
    }

    Customer getCustomer(int accounts) {
         return customers.get(accounts);
    }
    
    
}
