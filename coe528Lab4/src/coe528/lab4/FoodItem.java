/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab4;

/**
 *
 * @author e225wong
 */
public class FoodItem extends FoodComponent{
    private double price;
    
    public FoodItem(String name, double price){
        super(name);
        this.price = price;
    }
    
    //Effects: returns the price of the food item
    @Override
    public double getPrice(){
        return price;
    }
    
    //Effects: Prints the name and price of the given food item
    @Override
    public void print(int level){
        for(int i = 0; i < level; i++){
            System.out.print("     ");
        }
        System.out.println("FoodItem: " + this.name + ", " + this.price);
    }
    
}
