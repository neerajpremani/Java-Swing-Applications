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
public class AvlFlytDirectory {
     private ArrayList<FlytSchedule> avlflytDirectory;

    public AvlFlytDirectory(){
        avlflytDirectory = new ArrayList<FlytSchedule>();
    }       

    public ArrayList<FlytSchedule> getAvlflytDirectory() {
        return avlflytDirectory;
    }

    public void setAvlflytDirectory(ArrayList<FlytSchedule> avlflytDirectory) {
        this.avlflytDirectory = avlflytDirectory;
    }
    
    
    public FlytSchedule addFlytSchedule(){
        FlytSchedule newFlytSchedule = new FlytSchedule();
        avlflytDirectory.add(newFlytSchedule);
        return newFlytSchedule;
    }
    
    public void deleteFlytSchedule(FlytSchedule flytschedule){
        avlflytDirectory.remove(flytschedule);
    }
}
