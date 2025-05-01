/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package coe528.lab4;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Singleton
 */
public class Record {
    
    private static Record instance;
    
    public Record() {
    }
    
    public static Record getInstance()
    {
        if (instance == null)
            instance = new Record();
        return instance;
    }
    
    // Effects: Reads and prints the contents of the associated
    // file to the standard output.
    public void read() {
        try {
            File recordfile = new File("record.txt");
            Scanner myReader = new Scanner(recordfile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    // Effects: Appends the specified message, msg, to the
    // associated file.
    public void write(String msg) {
        try {
            FileWriter myWriter;
            myWriter = new FileWriter("record.txt", true);
            myWriter.write(msg);
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        }
    
    public static void main(String[] args) {
        
        Record r = Record.getInstance();
        
        r.write("Hello-1\n");
        r.write("Hello-2\n");
        System.out.println("Currently the file record.txt " +
        "contains the following lines:");
        r.read();
    }
}
