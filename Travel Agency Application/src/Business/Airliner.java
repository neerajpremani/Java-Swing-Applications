/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author VARSHA PREMANI
 */

public class Airliner 
{
    private String airlinerName;  
    private String airlinerEmail;
    private Integer airlinerflyperday;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String zipcode;

    public Integer getAirlinerflyperday() {
        return airlinerflyperday;
    }

    public void setAirlinerflyperday(Integer airlinerflyperday) {
        this.airlinerflyperday = airlinerflyperday;
    }



    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public String getAirlinerEmail() {
        return airlinerEmail;
    }

    public void setAirlinerEmail(String airlinerEmail) {
        this.airlinerEmail = airlinerEmail;
    }
    
    @Override
    public String toString() {
        return this.getAirlinerName();
    }
}
