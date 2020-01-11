/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.PatientRequest.PatientRequest;
import business.drug.Drug;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEERAJ PREMANI
 */
public class WorkRequestDoctor extends WorkRequest {

    List<PatientRequest> patientRequestList;
    List<Drug> drugsOrderList;

    public WorkRequestDoctor(String size) {
        super(size);
        this.patientRequestList = new ArrayList<>();
        this.drugsOrderList=new ArrayList<>();
    }

    public List<Drug> getDrugsOrderList() {
        return drugsOrderList;
    }

    public void setDrugsOrderList(List<Drug> drugsOrderList) {
        this.drugsOrderList = drugsOrderList;
    }

    public List<PatientRequest> getPatientRequestList() {
        return patientRequestList;
    }

    public void setPatientRequestList(List<PatientRequest> patientRequestList) {
        this.patientRequestList = patientRequestList;
    }

}
