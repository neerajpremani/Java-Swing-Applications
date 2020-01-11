/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author jaysh
 */
    
public class CustomerDirectory {
    private ArrayList<Customer> customerDirectory;

    public CustomerDirectory(){
        customerDirectory = new ArrayList<Customer>();
    }       

    public ArrayList<Customer> getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(ArrayList<Customer> customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    public Customer addCustomer(){
        Customer newCustomer = new Customer();
        customerDirectory.add(newCustomer);
        return newCustomer;
    }
    
    public void deleteCustomer(Customer customer){
        customerDirectory.remove(customer);
    }
    
    public Customer searchAccount(String name){
        for(Customer cust : this.customerDirectory){
            if(cust.getCustomerName().equalsIgnoreCase(name)){
                return cust;
            }
        }
        return null;
    }        
}