/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;


/**
 *
 * @author Is it ok to be sad?
 */
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private static int nextNumber = 1;
    private int number;
    
    public Ticket(Passenger passenger, Flight flight, double price){
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
    }
    
    public Flight getFlight(){
        return flight;
    }
    
    public Passenger getPassenger(){
        return passenger;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setFlight(Flight x){
        flight = x;
    }
    
    public void setPassenger(Passenger x){
        passenger = x;
    }
    
    public void setPrice(double x){
        price = x;
    }
    
    @Override
    public String toString(){
        Passenger p = getPassenger();
        Flight f = getFlight();
        return ""+ p.getName() +", Flight "+ f.getFlightNumber() +", "+f.getOrigin()+" to "+f.getDestination()+", "+f.getDepartureTime()+", original price :"+f.getOriginalPrice()+"$, ticket price: $" + price;
    }
}
