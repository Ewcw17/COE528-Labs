/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;


/**
 *
 * @author e225wong
 */
public class Member extends Passenger{
    private int yearsOfMembership;
    
    public Member(String name, int age, int yearsOfMembership){
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    @Override
    public double applyDiscount(double p){
        if(yearsOfMembership > 5){
            return p*0.50;
        }else if(yearsOfMembership > 1 && yearsOfMembership <=5){
            return p*0.9;
        }else{
            return p;
        }
    }
}
