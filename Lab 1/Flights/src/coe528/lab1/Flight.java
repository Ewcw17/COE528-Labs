/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author e225wong
 */
public class Flight {
    
    private int flightNumber, capacity, numberOfSeatsLeft;
    private String origin, destination, departureTime;
    private double originalPrice;
    
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice){
        
        if(origin.equals(destination)){
            throw new IllegalArgumentException("Origin cannot be the same as destination");
        }
        
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.originalPrice = originalPrice;
        this.numberOfSeatsLeft = capacity;
    }
    
    // Getters
    
    public int getFlightNumber(){
        return flightNumber;
    }
    public String getOrigin(){
        return origin;
    }
    public String getDestination(){
        return destination;
    }
    public String getDepartureTime(){
        return departureTime;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getNumberOfSeatsLeft(){
        return numberOfSeatsLeft;
    }
    public double getOriginalPrice(){
        return originalPrice;
    }
    
    //Setters
    
    public void setFlightNumber(int x){
        flightNumber = x;
    }
    public void setOrigin(String x){
        origin = x;
    }
    public void setDestination(String x){
        destination = x;
    }
    public void setDepartureTime(String x){
        departureTime = x;
    }
    public void setCapacity(int x){
        capacity = x;
    }
    public void setNumberOfSeatsLeft(int x){
        numberOfSeatsLeft = x;
    }
    public void setOriginalPrice(double x){
        originalPrice = x;
    }
    
    public boolean bookASeat(){
        if(numberOfSeatsLeft > 0){
            numberOfSeatsLeft--;
            return true;
        }else {
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "Flight "+ flightNumber+", "+ origin +" to "+ destination +", "+ departureTime +", original price: "+ originalPrice +"$";
    }
}
