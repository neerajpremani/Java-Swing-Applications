/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author JAINHEMANT
 */
public class Booking {
    private String flytCustName;  
    private String flytCustEmail;
    private String flytNum;
    private String flytFrom;
    private String flytTo;
    private String flytDate;
     private String flytTime;
    private Integer flytSeatNum;
    private static int count = 0;
    private Integer flytBookingId;
    public Booking() {
        count++;
        flytBookingId = count;
    }

    public String getFlytTime() {
        return flytTime;
    }

    public void setFlytTime(String flytTime) {
        this.flytTime = flytTime;
    }
    public String getFlytCustName() {
        return flytCustName;
    }

    public void setFlytCustName(String flytCustName) {
        this.flytCustName = flytCustName;
    }

    public String getFlytCustEmail() {
        return flytCustEmail;
    }

    public void setFlytCustEmail(String flytCustEmail) {
        this.flytCustEmail = flytCustEmail;
    }

    public String getFlytNum() {
        return flytNum;
    }

    public void setFlytNum(String flytNum) {
        this.flytNum = flytNum;
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

    public String getFlytDate() {
        return flytDate;
    }

    public void setFlytDate(String flytDate) {
        this.flytDate = flytDate;
    }

    public Integer getFlytSeatNum() {
        return flytSeatNum;
    }

    public void setFlytSeatNum(Integer flytSeatNum) {
        this.flytSeatNum = flytSeatNum;
    }

    public Integer getFlytBookingId() {
        return flytBookingId;
    }

    public void setFlytBookingId(Integer flytBookingId) {
        this.flytBookingId = flytBookingId;
    }
    
    
    @Override
    public String toString() {
        return this.getFlytCustName();
    }
}
