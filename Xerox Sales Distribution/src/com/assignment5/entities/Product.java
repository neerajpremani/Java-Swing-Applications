/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

/**
 *
 * @author kasai
 */
public class Product {
    
    
    public Product(int productId, double minPrice, double maxPrice, double targetPrice)
   {
       this.productId=productId;
       this.minPrice=minPrice;
       this.maxPrice=maxPrice;
       this.targetPrice=targetPrice;
   }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }
    private int productId;
    private double minPrice;
    private double maxPrice;
    private double targetPrice;

    @Override
    public String toString() {
        return "Product{" + "Product id = " + productId + ", Minimum Price = " + minPrice + ", Maximum Price = " + maxPrice + ", Target Price = " + targetPrice + '}';
    }
}
