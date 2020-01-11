/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.employee;

/**
 *
 * @author JAINHEMANT
 */
public class Employee {

    private String name;
    //left
    private int id; // Generate UUID
    //private static int count = 1;

    public Employee(int id) {
        this.id = id;
        //count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
