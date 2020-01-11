/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.drug;

import java.util.List;

/**
 *
 * @author JAINHEMANT
 */
public class Drug {

    private int id;
    private String name;
    private int quantity;
    private double manufacturerPrice;
    private List<String> disease;
    private double supplierPrice;
    private int requestCountFromMan;

    public int getRequestCountFromMan() {
        return requestCountFromMan;
    }

    public void setRequestCountFromMan(int requestCountFromMan) {
        this.requestCountFromMan = requestCountFromMan;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getManufacturerPrice() {
        return manufacturerPrice;
    }

    public void setManufacturerPrice(double manufacturerPrice) {
        this.manufacturerPrice = manufacturerPrice;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public List<String> getDisease() {
        return disease;
    }

    public void setDisease(List<String> disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return name;
    }

}
