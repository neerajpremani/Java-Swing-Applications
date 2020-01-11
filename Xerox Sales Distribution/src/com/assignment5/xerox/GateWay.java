/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.analytics.AnalysisHelper;
import com.assignment5.analytics.DataStore;
import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kasai
 */
public class GateWay {
    
    AnalysisHelper helper;
    DataReader productReader;
    DataReader orderReader;
     Map<Integer,Integer> count1=new HashMap<>();
    
    public GateWay() throws IOException
    {
        DataGenerator generator = DataGenerator.getInstance();
        productReader = new DataReader(generator.getProductCataloguePath());
        orderReader = new DataReader(generator.getOrderFilePath());
        helper = new AnalysisHelper();
    }
    
    public static void main(String args[]) throws IOException
    {
        GateWay gateway = new GateWay();
        gateway.readData();  
    }
    
    private void readData() throws IOException
    {
        String[] row;
        while((row = productReader.getNextRow()) != null ){
            generateProduct(row);
        }
        while((row = orderReader.getNextRow()) != null ){
           generateOrder(row);
        }
        
        runAnalysis();
    }
    
    private void generateProduct(String row[])
    {
         int productId = Integer.parseInt(row[0]);
         double minPrice = Double.parseDouble(row[1]);
         double maxPrice = Double.parseDouble(row[2]);
         double targetPrice = Double.parseDouble(row[3]);
         Product p = new Product(productId, minPrice, maxPrice,targetPrice);
         DataStore.getInstance().getProductMap().put(productId, p);
      
          DataStore.getInstance().getTargetPriceMap().put(productId, targetPrice);
    }
    
    private void generateOrder(String row[])
    {
        int quanttotal=0,temp=0;
        int orderId = Integer.parseInt(row[0]);
        int productId = Integer.parseInt(row[2]);
        int quantity = Integer.parseInt(row[3]);
        int salesId = Integer.parseInt(row[4]);
        int customerId = Integer.parseInt(row[5]);
        int salesPrice = Integer.parseInt(row[6]);
        Item item = new Item(productId, salesPrice, quantity);
        item.setProductId(productId);
        item.setSalesPrice(salesPrice);
        item.setQuantity(quantity);
        Order order = new Order(orderId, salesId, customerId, item);
        DataStore.getInstance().getOrderMap().put(orderId, order);
        
       
        
        
//        if(count1.containsKey(productId))
//        {
//            quanttotal=count1.get(productId);
//            quanttotal+=quantity;
//        }
//            
//            
//            count1.put(productId, quanttotal);
//        System.out.println(count1);
        
        Map<Integer,Customer> customers = DataStore.getInstance().getCustomer();
        if(customers.containsKey(customerId))
        {
            customers.get(customerId).getArrayListOrder().add(order);
        }
        else
        {
            Customer c = new Customer(customerId);
            customers.put(customerId, c);
            customers.get(customerId).getArrayListOrder().add(order);
        }
        //generate data in salesperson
        Map<Integer,SalesPerson> salesPerson = DataStore.getInstance().getSalesperson();
        if(salesPerson.containsKey(salesId))
        {
            salesPerson.get(salesId).getArrayListOrder().add(order);
        }
        else
        {
            SalesPerson s = new SalesPerson(salesId);
            salesPerson.put(salesId, s);
            salesPerson.get(salesId).getArrayListOrder().add(order);
        }
    }
    
    private void runAnalysis()
    {
        try
        {
       	    helper.top3Products();
            helper.top3Customers();
            helper.top3Sales();
            helper.totalRevenue();
            helper.question5Dynamic();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }    
}
