/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author Jawline, chewing gum, sexy
 */
public abstract class Passenger {
    
    private String name;
    private int age;
    
    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setName(String x){
        name = x;
    }
    
    public void setAge(int x){
        age = x;
    }
    
    public abstract double applyDiscount(double p);
    
}
