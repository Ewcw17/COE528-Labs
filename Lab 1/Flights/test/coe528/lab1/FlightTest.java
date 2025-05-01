/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package coe528.lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author e225wong
 */
public class FlightTest {
    
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test //This test also tests the toString method
    public void testConstructor() {
        // TODO review the generated test code and remove the default call to fail.
        Flight instance = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 300, 1000);
        String testString = "Flight 1030, Toronto to Kolkata, 03/02/99 7:50 pm, original price: 1000.0$";
        assertEquals(instance.toString(), testString);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        Flight instance2 = new Flight(1030, "Toronto", "Toronto", "03/02/99 7:50 pm", 300, 1000);
        
    }
    
    @Test //This test also tests the toString method
    public void testMethods() {
        // TODO review the generated test code and remove the default call to fail.
        Flight instance3 = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 300, 1000);
        
        instance3.setFlightNumber(1040);
        assertEquals(1040, instance3.getFlightNumber());
        
        instance3.setOrigin("Ottawa");
        assertEquals("Ottawa", instance3.getOrigin());
        
        instance3.setDestination("Iqualit");
        assertEquals("Iqualit", instance3.getDestination());
        
        instance3.setDepartureTime("02/25/01 3:30 pm");
        assertEquals("02/25/01 3:30 pm", instance3.getDepartureTime());
        
        instance3.setCapacity(1);
        assertEquals(1, instance3.getCapacity());
        
        instance3.setNumberOfSeatsLeft(5);
        assertEquals(5, instance3.getNumberOfSeatsLeft());
        
        instance3.setOriginalPrice(500.0);
        assertEquals(500.0, instance3.getOriginalPrice(), 1);
        
        int initial = instance3.getNumberOfSeatsLeft();
        instance3.bookASeat();
        assertEquals(initial-1, instance3.getNumberOfSeatsLeft());
    }
    
}
