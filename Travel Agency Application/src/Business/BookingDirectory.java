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
public class BookingDirectory {
    private ArrayList<Booking> bookingDirectory;

    public BookingDirectory(){
        bookingDirectory = new ArrayList<Booking>();
    }       

    public ArrayList<Booking> getBookingDirectory() {
        return bookingDirectory;
    }

    public void setBookingDirectory(ArrayList<Booking> bookingDirectory) {
        this.bookingDirectory = bookingDirectory;
    }
    
    public Booking addBooking(){
        Booking newBooking = new Booking();
        bookingDirectory.add(newBooking);
        return newBooking;
    }
    
    public void deleteBooking(Booking booking){
        bookingDirectory.remove(booking);
    }
    
    public Booking searchAccount(String name){
        for(Booking book : this.bookingDirectory){
            if(book.getFlytCustName().equalsIgnoreCase(name)){
                return book;
            }
        }
        return null;
    }       
}
