/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab4;

/**
 *
 * @author e225wong
 */
public abstract class FoodComponent {
    protected String name;
    
    public FoodComponent(String name){
        this.name = name;
    }
    
    abstract double getPrice();
    
    abstract void print(int level);
    
}
