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
public class FlytScheduleDirectory {
    
    private ArrayList<FlytSchedule> flytscheduleDirectory;
       ArrayList<FlytSchedule> searchFlightsDirectory=new ArrayList<>();
       
    public FlytScheduleDirectory(){
        flytscheduleDirectory = new ArrayList<FlytSchedule>();
    }       

    public ArrayList<FlytSchedule> getFlytscheduleDirectory() {
        return flytscheduleDirectory;
    }

    public void setFlytscheduleDirectory(ArrayList<FlytSchedule> flytscheduleDirectory) {
        this.flytscheduleDirectory = flytscheduleDirectory;
    }
    
    public FlytSchedule addFlytSchedule(){
        FlytSchedule newFlytSchedule = new FlytSchedule();
        flytscheduleDirectory.add(newFlytSchedule);
        return newFlytSchedule;
    }
    
    
    public void deleteFlytSchedule(FlytSchedule flytschedule){
        flytscheduleDirectory.remove(flytschedule);
    }
    
    public FlytSchedule searchAccount(String name,String date,String timeoption){
        for(FlytSchedule flsch : this.flytscheduleDirectory){
            int flyttime = Integer.parseInt(flsch.getFlytTime());
            if(flsch.getFlytNum().equalsIgnoreCase(name)
                    && 
               flsch.getFlytDate().contentEquals(date))
            {
               switch(timeoption)
               {
                   case "A" :
                         if (flyttime > 000 && flyttime <= 600)
                             {
                              return flsch;
                             }
                             break;
                   case "B" :
                         if  (flyttime > 600 && flyttime <= 1200)
                             {
                              return flsch;
                             }
                             break;
                   case "C" :
                         if  (flyttime > 1200 && flyttime <= 1800)
                             {
                              return flsch;
                             }
                             break; 
                   case "D" :   
                         if  (flyttime > 1800 && flyttime <= 2400)
                             {
                              return flsch;
                             }
                             break;
               } 
            }
                              
        }
        return null;
    }    
      public ArrayList<FlytSchedule> searchFlight(String from, String to, String date,String timeoption){
          searchFlightsDirectory.clear();
        for(FlytSchedule flsch : this.flytscheduleDirectory){
            int flyttime = Integer.parseInt(flsch.getFlytTime());
            if(flsch.getFlytFrom().equalsIgnoreCase(from)
               &&
               flsch.getFlytTo().equalsIgnoreCase(to)
               &&
               flsch.getFlytDate().contentEquals(date)     
              )
            {
               switch(timeoption)
               {
                   case "A" :
                         if (flyttime > 000 && flyttime <= 600)
                             {
//                              return flsch;
                                 searchFlightsDirectory.add(flsch);
                             }
                             break;
                   case "B" :
                         if  (flyttime > 600 && flyttime <= 1200)
                             {
                                    searchFlightsDirectory.add(flsch);
                              //return flsch;
                             }
                             break;
                   case "C" :
                         if  (flyttime > 1200 && flyttime <= 1800)
                             {
                                    searchFlightsDirectory.add(flsch);
                              //return flsch;
                             }
                             break; 
                   case "D" :   
                         if  (flyttime > 1800 && flyttime <= 2400)
                             {
                                    searchFlightsDirectory.add(flsch);
                              //return flsch;
                             }
                             break;
               } 
            }
        }
        if(   searchFlightsDirectory.size()>0)
        {
            return searchFlightsDirectory;
        }
        else
        {
           return null; 
        }
        
    }  
}
