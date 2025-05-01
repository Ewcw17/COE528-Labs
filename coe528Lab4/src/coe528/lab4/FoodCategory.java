/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab4;

import java.util.ArrayList;

/**
 *
 * @author Bridge design pattern is goated, don't listen to Driver
 */
public class FoodCategory extends FoodComponent{
    private ArrayList<FoodComponent> components = new ArrayList<>();
    
    public FoodCategory(String name){
        super(name);
    }
    
    //Modifies: components
    //Effects: adds x to the components arraylist
    public void add(FoodComponent x){
        components.add(x);
    }
    
    //Modifies: components
    //Effects: removes x to the components arraylist
    public void removeComponent(FoodComponent x){
        components.remove(x);
    }
    
    @Override
    //Effects: prints the sum of all FoodComponents in the category
    public double getPrice(){
        double total = 0;
        for(FoodComponent comp : components){
            total += comp.getPrice();
        }
        return total;
    }
    
    @Override
    //Requires: level must be 0 or greater
    //Effects: Prints out the category's name and full price along with everything it contains
    public void print(int level){
        for(int i = 0; i < level; i++){
            System.out.print("     ");
        }
        System.out.println("FoodCategory (" + name + ", " + this.getPrice() + ") contains:");
        
        for(FoodComponent comp : components){
            comp.print(level+1);
        }
    }
}
