/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package coe528.lab2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author e225wong
 */
public class ProceduralAbstractionTest {
    
    public ProceduralAbstractionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of reverseFactorial method, of class ProceduralAbstraction.
     */
    @Test
    public void testReverseFactorial() {
        System.out.println("reverseFactorial");
        int x = 0;
        int expResult = 5;
        int result = ProceduralAbstraction.reverseFactorial(119);
        assertEquals(expResult, result);
    }

    /**
     * Test of isMatrixNice method, of class ProceduralAbstraction.
     */
    @Test
    public void testIsMatrixNice() {
        System.out.println("isMatrixNice");
        int[][] arr = {{10, 5, 6}, {3, 7, 11}, {8, 9, 4}};
        boolean expResult = true;
        boolean result = ProceduralAbstraction.isMatrixNice(arr);
        assertEquals(expResult, result);
    }
}
