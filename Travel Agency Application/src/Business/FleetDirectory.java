/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author JAINHEMANT
 */
public class FleetDirectory {
    
    private ArrayList<Fleet> fleetDirectory;

    public FleetDirectory(){
        fleetDirectory = new ArrayList<Fleet>();
    }       

    public ArrayList<Fleet> getFleetDirectory() {
        return fleetDirectory;
    }

    public void setFleetDirectory(ArrayList<Fleet> fleetDirectory) {
        this.fleetDirectory = fleetDirectory;
    }
    public Fleet addFleet(){
        Fleet newFleet = new Fleet();
        fleetDirectory.add(newFleet);
        return newFleet;
    }
    
    public void deleteFleet(Fleet fleet){
        fleetDirectory.remove(fleet);
    }
    
    public Fleet searchAccount(String name){
        for(Fleet fleet : this.fleetDirectory){
            if(fleet.getFleetModel().equalsIgnoreCase(name)){
                return fleet;
            }
        }
        return null;
    }    
}
