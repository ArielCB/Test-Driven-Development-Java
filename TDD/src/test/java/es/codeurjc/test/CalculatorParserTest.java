package es.codeurjc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

public class CalculatorParserTest {
	
    private CalculatorParser calculator;
    
    @BeforeEach
    public void setup() {
    	calculator = new CalculatorParser();
    }
    
    @Test
    @DisplayName("1 => 1")
    public void test1 () {
    	assertEquals(1, calculator.parse("1"));
    }
    
    @Test
    @DisplayName("2 => 2")
    public void test2 () {
    	assertEquals(2, calculator.parse("2"));
    }
    
    @Test
    @DisplayName("3 => 3")
    public void test3 () {
    	assertEquals(3, calculator.parse("3"));
    }
    
    @Test
    @DisplayName("1+1 => 2")
    public void test4 () {
    	assertEquals(2, calculator.parse("1+1"));
    }
    
    @Test
    @DisplayName("2+3 => 5")
    public void test5 () {
    	assertEquals(5, calculator.parse("2+3"));
    }
    
    @Test
    @DisplayName("2+3+4 => 9")
    public void test6 () {
    	assertEquals(9, calculator.parse("2+3+4"));
    }
    
    @Test
    @DisplayName("1+2+3+4 => 10")
    public void test7 () {
    	assertEquals(10, calculator.parse("1+2+3+4"));
    }
    
    @Test
    @DisplayName("A => Error")
    public void test8 () {
    	NumberFormatException ex = assertThrows(NumberFormatException.class,
    			() -> calculator.parse("A"));
    	assertEquals("Invalid expression. Use: Int (+/- Int)*",ex.getMessage());
    }
    
    @Test
    @DisplayName("B => Error")
    public void test9 () {
    	NumberFormatException ex = assertThrows(NumberFormatException.class,
    			() -> calculator.parse("B"));
    	assertEquals("Invalid expression. Use: Int (+/- Int)*",ex.getMessage());
    }
    
    @Test
    @DisplayName("k => Error")
    public void test10 () {
    	NumberFormatException ex = assertThrows(NumberFormatException.class,
    			() -> calculator.parse("k"));
    	assertEquals("Invalid expression. Use: Int (+/- Int)*",ex.getMessage());
    }
    
    @Test
    @DisplayName("HoLa => Error")
    public void test11 () {
    	NumberFormatException ex = assertThrows(NumberFormatException.class,
    			() -> calculator.parse("HoLa"));
    	assertEquals("Invalid expression. Use: Int (+/- Int)*",ex.getMessage());
    }
    
    @Test
    @DisplayName("1+A => Error")
    public void test12 () {
    	NumberFormatException ex = assertThrows(NumberFormatException.class,
    			() -> calculator.parse("1+A"));
    	assertEquals("Invalid expression. Use: Int (+/- Int)*",ex.getMessage());
    }
    
    @Test
    @DisplayName("5-3 => 2")
    public void test13 () {
    	assertEquals(2, calculator.parse("5-3"));
    }
    
    @Test
    @DisplayName("1-2 => -1")
    public void test14 () {
    	assertEquals(-1, calculator.parse("1-2"));
    }
    
    @Test
    @DisplayName("7-2-1 => 4")
    public void test15 () {
    	assertEquals(4, calculator.parse("7-2-1"));
    }
    
    @Test
    @DisplayName("9-5-3-1 => 0")
    public void test16 () {
    	assertEquals(0, calculator.parse("9-5-3-1"));
    }
    
    @Test
    @DisplayName("7+1-5 => 3")
    public void test17 () {
    	assertEquals(3, calculator.parse("7+1-5"));
    }
    
    @Test
    @DisplayName("9-5+4 => 8")
    public void test18 () {
    	assertEquals(8, calculator.parse("9-5+4"));
    }
    
    @Test
    @DisplayName("9+1-6-2 => 2")
    public void test19 () {
    	assertEquals(2, calculator.parse("9+1-6-2"));
    }
    
    @Test
    @DisplayName("-5+9 => 4")
    public void test20 () {
    	assertEquals(4, calculator.parse("-5+9"));
    }
    
    @Test
    @DisplayName("-6+4-3+8 => 3")
    public void test20b () {
    	assertEquals(3, calculator.parse("-6+4-3+8"));
    }
    
}
