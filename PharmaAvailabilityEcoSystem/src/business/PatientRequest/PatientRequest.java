/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.PatientRequest;

import java.util.List;

/**
 *
 * @author jaysh
 */
public class PatientRequest {
    
    private int id;
    private String name;
     private List<String> disease;

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
