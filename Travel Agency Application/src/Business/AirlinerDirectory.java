/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author VARSHA PREMANI
 */

public class AirlinerDirectory {
    private ArrayList<Airliner> arilinerDirectory;

    public AirlinerDirectory(){
        arilinerDirectory = new ArrayList<Airliner>();
    }    

    public ArrayList<Airliner> getArilinerDirectory() {
        return arilinerDirectory;
    }

    public void setArilinerDirectory(ArrayList<Airliner> arilinerDirectory) {
        this.arilinerDirectory = arilinerDirectory;
    }
    public Airliner addAirliner(){
        Airliner newAirliner = new Airliner();
        arilinerDirectory.add(newAirliner);
        return newAirliner;
    }
    
    public void deleteAirliner(Airliner airliner){
        arilinerDirectory.remove(airliner);
    }
    
    public Airliner searchAccount(String name){
        for(Airliner airl : this.arilinerDirectory){
            if(airl.getAirlinerName().equalsIgnoreCase(name)){
                return airl;
            }
        }
        return null;
    }    
}