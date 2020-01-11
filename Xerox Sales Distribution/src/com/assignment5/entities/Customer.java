/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

import java.util.ArrayList;

/**
 *
 * @author kasai
 */
public class Customer {

    private int customerId;
    /*private String name;
    private String address;*/

    private ArrayList<Order> arrayListOrder;

    public Customer(int customerId) {
        this.customerId = customerId;
        this.arrayListOrder = new ArrayList<Order>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /* public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
     */
    public ArrayList<Order> getArrayListOrder() {
        return arrayListOrder;
    }

}
