/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author  VARSHA PREMANI
 */
public class Fleet {

    public String getAirname() {
        return airname;
    }

    public void setAirname(String airname) {
        this.airname = airname;
    }
    private String airname;
    private String fleetModel;  
    private Integer totalSeats;

    public String getFleetModel() {
        return fleetModel;
    }

    public void setFleetModel(String fleetModel) {
        this.fleetModel = fleetModel;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }
    
    @Override
    public String toString() {
        return this.getFleetModel();
    }
}
