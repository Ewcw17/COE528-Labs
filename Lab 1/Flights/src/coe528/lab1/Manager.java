/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mickey mouse
 */
public class Manager {
    
    static ArrayList<Flight> allFlights = new ArrayList<Flight>();
    static ArrayList<Ticket> allTickets = new ArrayList<Ticket>();
    
    public Manager(ArrayList<Flight> allFlights, ArrayList<Ticket> allTickets){
        this.allFlights = allFlights;
        this.allTickets = allTickets;
    }
    
    public ArrayList<Flight> getAllFlights(){
        return allFlights;
    }
    
    public ArrayList<Ticket> getAllTickets(){
        return allTickets;
    }
    
    public void createFlights(){
        
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter flight number: (To stop adding flights, enter 'End')");
            String number = scan.nextLine(); 
            if(number.equals("End")){
                break;
            }
            
            System.out.println("Please enter flight origin:");
            String origin = scan.nextLine();
            
            System.out.println("Please enter flight destination:");
            String destination = scan.nextLine();
            
            System.out.println("Please enter flight departureTime (Date and time):");
            String departureTime = scan.nextLine();
            
            System.out.println("Please enter flight capacity:");
            String capacity = scan.nextLine();
            
            System.out.println("Please enter flight's original price:");
            String originalPrice = scan.nextLine();
            
            allFlights.add(new Flight(Integer.parseInt(number), origin, destination, departureTime, Integer.parseInt(capacity), Double.parseDouble(originalPrice)));
            System.out.println("Flight "+ number + " added.");
        }
    }
    
    public void displayAvailableFlights(String origin, String destination){
        System.out.println("\nDisplaying available flights from "+origin+" to "+destination+".");
        for(int i=0; i<allFlights.size(); i++){
            Flight currentFlight = allFlights.get(i);
            if(currentFlight.getOrigin().equals(origin) && currentFlight.getDestination().equals(destination)){                
                if(currentFlight.getNumberOfSeatsLeft() > 0){
                    System.out.println(currentFlight);
                }
            }
        }
        System.out.println("There are no remaining flights from "+ origin +" to "+ destination +".");
    }
    
    public Flight getFlight(int flightNumber){
        for(int i=0; i<allFlights.size(); i++){
            Flight currentFlight = allFlights.get(i);
            if(currentFlight.getFlightNumber() == flightNumber){
                return currentFlight;
            }
        }
        return null;
    }
    
    public void bookSeat(int flightNumber, Passenger p){
        Flight currentFlight = getFlight(flightNumber);
        if(currentFlight != null){
            if(currentFlight.bookASeat()){
                double newPrice = p.applyDiscount(currentFlight.getOriginalPrice());
                allTickets.add(new Ticket(p, currentFlight, newPrice));
                System.out.println("Ticket created for passenger "+ p.getName() + " for flight number "+ flightNumber +" for $" + newPrice);
            }else {
                System.out.println("Seat not available.");
            }
        }else{
            System.out.println("Flight does not exist.");
        }
       
    }
    
    public static void main(String[] args){
        
        ArrayList<Flight> allFlights = new ArrayList<Flight>();
        ArrayList<Ticket> allTickets = new ArrayList<Ticket>();
        
        Member Tony = new Member("Tony", 36, 6);
        Member James = new Member("James", 23, 3);
        NonMember Nara = new NonMember("Nara", 67);
        NonMember Tom = new NonMember("Tom", 47);
        
        Manager manager = new Manager(allFlights, allTickets);
        manager.createFlights();
        
        manager.displayAvailableFlights("A", "B");
        manager.displayAvailableFlights("I", "D");
        
        manager.bookSeat(1, Nara);
        manager.bookSeat(0, Tony);
        manager.bookSeat(0, Tom);
        manager.bookSeat(0, James);
        manager.bookSeat(2, James);
        manager.bookSeat(3, Nara);
        manager.bookSeat(4, James);
        manager.bookSeat(5, Tom);
        
        System.out.println("\nNow printing all flights:");
        for(int i=0; i < manager.getAllFlights().size(); i++){
            System.out.println(manager.getAllFlights().get(i));
        }
        
        System.out.println("\nNow printing all tickets:");
        for(int i=0; i < manager.getAllTickets().size(); i++){
            System.out.println(manager.getAllTickets().get(i));
        }      
//         Sample input data
//         Flight Number: 0, Origin: A, Destination: B, departureTime: d, capacity: 2, original price: 100
//         Flight Number: 1, Origin: A, Destination: C, departureTime: d, capacity: 4, original price: 100
//         Flight Number: 2, Origin: C, Destination: D, departureTime: d, capacity: 3, original price: 200
//         Flight Number: 3, Origin: A, Destination: B, departureTime: d, capacity: 7, original price: 1000
//         Flight Number: 4, Origin: E, Destination: F, departureTime: d, capacity: 8, original price: 150
//         Flight Number: 5, Origin: G, Destination: H, departureTime: d, capacity: 1, original price: 100
//         End
//        
//         Expected output:
//         Displaying available flights from A to B.
//         Flight 0, A to B, d, original price: 100.0$
//         Flight 3, A to B, d, original price: 1000.0$
//         There are no remaining flights from A to B.
//
//         Displaying available flights from I to D.
//         There are no remaining flights from I to D.
//         Ticket created for passenger Nara for flight number 1 for $90.0
//         Ticket created for passenger Tony for flight number 0 for $50.0
//         Ticket created for passenger Tom for flight number 0 for $100.0
//         Seat not available.
//         Ticket created for passenger James for flight number 2 for $180.0
//         Ticket created for passenger Nara for flight number 3 for $900.0
//         Ticket created for passenger James for flight number 4 for $135.0
//         Ticket created for passenger Tom for flight number 5 for $100.0
//
//         Now printing all flights:
//         Flight 0, A to B, d, original price: 100.0$
//         Flight 1, A to C, d, original price: 100.0$
//         Flight 2, C to D, d, original price: 200.0$
//         Flight 3, A to B, d, original price: 1000.0$
//         Flight 4, E to F, d, original price: 150.0$
//         Flight 5, G to H, d, original price: 100.0$
//
//         Now printing all tickets:
//         Nara, Flight 1, A to C, d, original price :100.0$, ticket price: $90.0
//         Tony, Flight 0, A to B, d, original price :100.0$, ticket price: $50.0
//         Tom, Flight 0, A to B, d, original price :100.0$, ticket price: $100.0
//         James, Flight 2, C to D, d, original price :200.0$, ticket price: $180.0
//         Nara, Flight 3, A to B, d, original price :1000.0$, ticket price: $900.0
//         James, Flight 4, E to F, d, original price :150.0$, ticket price: $135.0
//         Tom, Flight 5, G to H, d, original price :100.0$, ticket price: $100.0

    }
    
}
