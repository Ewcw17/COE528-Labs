/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author e225wong
 */
import java.util.ArrayList;
public class QueueOfDistinctStrings {
    // Overview: QueueOfDistinctStrings are mutable, bounded
    // collection of distinct strings that operate in
    // FIFO (First-In-First-Out) order.
    //
    // The abstraction function is:
    // AF(c): an abstract object d such that
    // d.queue = c.items
    // d.front = c.items.get(0)
    // d.end = c.items.get(items.size()-1)
    // d.entryInQueue = c.items.get(i) Where i spans from 0 to the length of the arraylist. 
    // items represents a queue of strings. Each element in items represents
    // an element in a queue.
    //
    //
    //
    //
    // The rep invariant is:
    // RI(c) = false if(c[i] == null || items.remove(i).contains(items.get(i)))
    //         true otherwise
    // all elements of items are non-null Strings &&
    // there are no duplicate elements in items
    //
    //
    //
    //the rep
    private ArrayList<String> items;
    
    // constructor
    public QueueOfDistinctStrings () {
        // EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }
    
    // MODIFIES: this
    // EFFECTS: Appends the element at the end of the queue
    // if the element is not in the queue, otherwise
    // does nothing.
    public void enqueue(String element) throws Exception {
        if(element == null) throw new Exception();
        if(false == items.contains(element))
        items.add(element);
    }
    
    // MODIFIES: this
    // EFFECTS: Removes an element from the front of the queue
    public String dequeue() throws Exception {
        if (items.size() == 0) throw new Exception();
        return items.remove(0);
    }
    
    public boolean repOK() {
    // EFFECTS: Returns true if the rep invariant holds for this
    // object; otherwise returns false
        boolean holds = true;
        for(int i = 0; i < items.size(); i++){
            if(! (items.get(i) instanceof String)){
                holds = false;
            }
            
            if(items.remove(i).contains(items.get(i))){
                holds = false;
            }
        }
        return holds;
    }
    
    @Override
    public String toString() {
    // EFFECTS: Returns a string that contains the strings in the
    // queue, the front element and the end element.
    // Implements the abstraction function.
        String queue = "";
        for(int i = 0; i < items.size(); i++){
            queue = queue.concat(items.get(i) + " ");
        }
        return "The queue is as follows: " + queue + " The front is: " + items.get(0) + ". The back is: " + items.get(items.size() -1) + "";
    }
    
    public static void main(String[] args){
        QueueOfDistinctStrings queue = new QueueOfDistinctStrings();
        
        System.out.println("Result of repOk function: " + queue.repOK());
        
        try{
            queue.enqueue("zz");
            queue.enqueue("ab");
            queue.enqueue("cd");
            queue.enqueue("ae");
            queue.enqueue("bd");
        }catch (Exception e){
            System.out.println("Invalid string");
        }
        
        System.out.println(queue);
        
        try{ 
            queue.dequeue();
        }catch (Exception e){
            System.out.println("Queue is empty");
        }
        System.out.println(queue);
        System.out.println("Result of repOk function: " + queue.repOK());
        
    }
}