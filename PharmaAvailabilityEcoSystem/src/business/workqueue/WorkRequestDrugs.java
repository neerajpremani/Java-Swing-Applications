/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.drug.Drug;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEERAJ PREMANI
 */
public class WorkRequestDrugs extends WorkRequest {

    List<Drug> drugsOrderList;

    public WorkRequestDrugs(String size) {
        super(size);
        this.drugsOrderList = new ArrayList<>();
    }

    public List<Drug> getDrugsOrderList() {
        return drugsOrderList;
    }

    public void setDrugsOrderList(List<Drug> drugsOrderList) {
        this.drugsOrderList = drugsOrderList;
    }

}
