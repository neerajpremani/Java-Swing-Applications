/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.inventory;

import business.drug.Drug;
import java.util.List;

/**
 *
 * @author JAINHEMANT
 */
public class Inventory {
    private List<Drug> drugStock;

    public List<Drug> getDrugStock() {
        return drugStock;
    }

    public void setDrugStock(List<Drug> drugStock) {
        this.drugStock = drugStock;
    }
    
}
