/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import com.assignment5.entities.Customer;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.util.*;

/**
 *
 * @author neera
 */
public class DataStore {

    private static DataStore dataStore;
    private Map<Integer, Product> productMap;
    private Map<Integer, Order> orderMap;
    private Map<Integer, Double> minPriceMap;
     private Map<Integer, Double> targetPriceMap;
    private Map<Integer, Customer> customer;
    private Map<Integer, SalesPerson> salesperson;

    public Map<Integer, Integer> getProdquantity() {
        return prodquantity;
    }

    public void setProdquantity(Map<Integer, Integer> prodquantity) {
        this.prodquantity = prodquantity;
    }
    private Map<Integer, Integer> prodquantity;
    

    public Map<Integer, Double> getTargetPriceMap() {
        return targetPriceMap;
    }

    public void setTargetPriceMap(Map<Integer, Double> targetPriceMap) {
        this.targetPriceMap = targetPriceMap;
    }
   

    public Map<Integer, SalesPerson> getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(Map<Integer, SalesPerson> salesperson) {
        this.salesperson = salesperson;
    }

    private DataStore() {
        productMap = new HashMap<>();
        orderMap = new HashMap<>();
        minPriceMap = new HashMap<>();
        customer = new HashMap<>();
        salesperson = new HashMap<>();
        targetPriceMap = new HashMap<>();
    }

    public static DataStore getInstance() {
        if (dataStore == null) {
            dataStore = new DataStore();
        }
        return dataStore;
    }

    public static DataStore getDataStore() {
        return dataStore;
    }

    public static void setDataStore(DataStore dataStore) {
        DataStore.dataStore = dataStore;
    }

    public Map<Integer, Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Map<Integer, Customer> customer) {
        this.customer = customer;
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }

    public Map<Integer, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Integer, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public Map<Integer, Double> getMinPriceMap() {
        return minPriceMap;
    }

    public void setMinPriceMap(Map<Integer, Double> minPriceMap) {
        this.minPriceMap = minPriceMap;
    }

}
