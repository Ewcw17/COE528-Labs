/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab2;

/**
 *
 * @author e225wong
 */
public class ProceduralAbstraction {
    
    //Requires: x > -1
    //Modifies: None
    //Effects: Returns the smallest positive integer n for which n!
    // (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
    // integer x. Otherwise returns 1.
    public static int reverseFactorial(int x) {
        int compare = 0;
        int n = 0;
        
        if(x <= 0){
            throw new IllegalArgumentException("Number must be positive");
        }
        
        while(compare < x){
            if(n == 0){
                compare = 1;
            }else {
                compare = compare * n;
            }
            n++;
        }
        return n-1;
    }
    
    //Requires: arr[0].length == arr.length
    //Modifies: None
    //Effects: returns true if the sum of all of the columns of the array are
    // equal to the provided tSum
    public static boolean checkColumns(int[][] arr, int tSum){
        int sum = 0;
        for(int j = 0; j < (arr.length); j++){
            for(int i = 0; i < (arr.length); i++){
            sum += arr[i][j];
            }
            if(sum != tSum) return false;
            sum = 0;
        }
        
        return true;
    }
    
    //Requires: arr[0].length == arr.length
    //Modifies: None
    //Effects: returns true if the sum of all of the rows of the array are equal
    // to the provided tSum
    public static boolean checkRows(int[][] arr, int tSum){
        int sum = 0;
        for(int j = 0; j < (arr.length); j++){
            for(int i = 0; i < (arr.length); i++){
            sum += arr[j][i];
            }
            if(sum != tSum) return false;
            sum = 0;
        }
        
        return true;
    }
    
    //Requires: arr[0].length == arr.length
    //Modifies: None
    //Effects: returns true if the sum of both diagonals of the given square 2D
    // array are equal to tSum
    public static boolean checkDiagonals(int[][] arr, int tSum){
        int diag1 = 0;
        int diag2 = 0;
        for(int i = 0; i < (arr.length); i++){
            diag1 += arr[i][i];
            diag2 += arr[i][(arr.length-1)-i];
        }
        if(diag1 == diag2 && diag1 == tSum){
            return true;
        }else{
            return false;
        }
    }
    
    //Requires: None
    //Modifies: None
    //Effects: If the matrix arr satisfies Nice property, prints the sum and
    // returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr) {
        int totalSum = 0;
        if(arr.length == arr[0].length){
            for(int i = 0; i < (arr.length); i++){
                totalSum += arr[0][i];
            }
            if(checkRows(arr, totalSum) && checkColumns(arr, totalSum) && checkDiagonals(arr, totalSum)){
                System.out.println(totalSum);
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        int array[][] = {{10, 5, 6}, {3, 7, 11}, {8, 9, 4}};
        System.out.println(reverseFactorial(119));
        System.out.println(isMatrixNice(array));
    }
}
