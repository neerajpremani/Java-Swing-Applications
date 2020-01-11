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
public class SalesPerson {

    private int salesId;
    /*private String name;
    private String address;*/
    private ArrayList<Order> arrayListOrder;

    public SalesPerson(int salesId) {
        this.salesId = salesId;

        this.arrayListOrder = new ArrayList<Order>();
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public ArrayList<Order> getArrayListOrder() {
        return arrayListOrder;
    }
}
