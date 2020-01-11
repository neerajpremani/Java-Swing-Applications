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
public class FlytSchedule implements Comparable<FlytSchedule> {
    private String flytNum;  
    private String flytAirline;
    private String flytFleet;
    private String flytFrom;
    private String flytTo;
    private String flytDate;
    private String flytTime;
    private Integer flytAvlSeats;

    public Double getFlyPrice() {
        return flyPrice;
    }

    public void setFlyPrice(Double flyPrice) {
        this.flyPrice = flyPrice;
    }
    private Double flyPrice;
    private ArrayList<Seats> seatsDirectory;      

    public ArrayList<Seats> getSeatsDirectory() {
        return seatsDirectory;
    }

    public void setSeatsDirectory() {
        seatsDirectory = new ArrayList<Seats>(150);
        for (int i=1; i <= 150; i++ )
          {
            Seats seats = new Seats();              
            seats.setSeatNum(i);
            seats.setSeatStatus("A");
            int temp = i % 6 ;
            switch(temp){
			case 1:
				seats.setSeatType("W");
                                
                                break ;                            
                        case 0:
				seats.setSeatType("W");
                                
                                break ;
			case 2:
                                seats.setSeatType("M");
                                
				break;
                        case 5:
				seats.setSeatType("M");
                                
				break;
			case 3:
                                seats.setSeatType("A");
                                
				break;
                        case 4:
				seats.setSeatType("A");
                                
				break;
		}
            seatsDirectory.add(seats);
          }
        this.seatsDirectory = seatsDirectory;
    }
    public String getFlytDate() {
        return flytDate;
    }

    public void setFlytDate(String flytDate) {
        this.flytDate = flytDate;
    }

    public String getFlytTime() {
        return flytTime;
    }

    public void setFlytTime(String flytTime) {
        this.flytTime = flytTime;
    }
    public Integer getFlytAvlSeats() {
        return flytAvlSeats;
    }

    public void setFlytAvlSeats(Integer flytAvlSeats) {
        this.flytAvlSeats = flytAvlSeats;
    }
    

    public String getFlytNum() {
        return flytNum;
    }

    public void setFlytNum(String flytNum) {
        this.flytNum = flytNum;
    }

    public String getFlytAirline() {
        return flytAirline;
    }

    public void setFlytAirline(String flytAirline) {
        this.flytAirline = flytAirline;
    }

    public String getFlytFrom() {
        return flytFrom;
    }

    public void setFlytFrom(String flytFrom) {
        this.flytFrom = flytFrom;
    }

    public String getFlytTo() {
        return flytTo;
    }

    public void setFlytTo(String flytTo) {
        this.flytTo = flytTo;
    }

    public String getFlytFleet() {
        return flytFleet;
    }

    public void setFlytFleet(String flytFleet) {
        this.flytFleet = flytFleet;
    }
    public Seats searchSeat(String name){
        for(Seats seats : this.seatsDirectory){
            if(seats.getSeatType().equalsIgnoreCase(name)
                    &&
                    
               seats.getSeatStatus().contentEquals("A")
              )
            {
                return seats;
            }
        }
        return null;
    }
    
    
    public Seats searchSeatNum(String num){
        for(Seats seats : this.seatsDirectory){
            if( seats.getSeatNum() == Integer.parseInt(num)
              )
            {
                return seats;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return this.getFlytNum();
    }
    
     @Override
    public int compareTo(FlytSchedule o) {
        return (int) (flyPrice-o.flyPrice);
    }
}
