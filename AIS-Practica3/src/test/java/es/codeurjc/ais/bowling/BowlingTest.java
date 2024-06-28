package es.codeurjc.ais.bowling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class BowlingTest{
	
	Bowling bowling;
	
	@BeforeEach
	void setup() {
		bowling = new Bowling();
	}
	
	@Test
	@DisplayName("Test pins greater than 0")
	void testPins0() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->bowling.throwing(-1));
		assertEquals("Number must be greater than zero", ex.getMessage());
	}
	
	@Test
	@DisplayName("Test pins smaller than 10")
	void testPins10() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->bowling.throwing(11));
		assertEquals("Number must be smaller than ten", ex.getMessage());
	}
	
	@Test
	@DisplayName("Test score = sum of throws")
	void testGetScore() {
		bowling.throwing(4);
		bowling.throwing(5);
		bowling.throwing(0);
		bowling.throwing(2);
		assertEquals(11,bowling.getScore());
	}
	
	@Test
	@DisplayName("Test score = sum of throws(2)")
	void testGetScore1() {
		bowling.throwing(3);
		bowling.throwing(3);
		bowling.throwing(1);
		bowling.throwing(7);
		assertEquals(14,bowling.getScore());
	}
	
	@Test
	@DisplayName("Pins in a turn <= 10")
	void testPinsPerThrow() {
		bowling.throwing(9);
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> bowling.throwing(9));
		assertEquals("You cant throw more than 10 pins per turn",ex.getMessage());
	}
	
	@Test
	@DisplayName("Test change of turns")
	void testChangeOfTurns() {
		bowling.throwing(0);
		bowling.throwing(8);
		bowling.throwing(9);
		assertEquals(17,bowling.getScore());
	}
	
	@Test
	@DisplayName("Test spare")
	void testSpare() {
		bowling.throwing(3);
		bowling.throwing(7);
		bowling.throwing(5);
		bowling.throwing(5);
		bowling.throwing(2);
		bowling.throwing(1);
		bowling.throwing(3);
		bowling.throwing(4);
		assertEquals(43,bowling.getScore());
	}
	
	@Test
	@DisplayName("Test strike")
	void testStrike() {
		bowling.throwing(3);
		bowling.throwing(7);
		bowling.throwing(10);
		bowling.throwing(10);
		bowling.throwing(5);
		bowling.throwing(5);
		bowling.throwing(3);
		bowling.throwing(4);
		bowling.throwing(2);
		bowling.throwing(1);
		bowling.throwing(10);
		bowling.throwing(4);
		bowling.throwing(0);
		bowling.throwing(2);
		bowling.throwing(1);
		assertEquals(128,bowling.getScore());
	}
	
	@Test
	@DisplayName("Test ending spare")
	void testEndingSpare() {
		bowling.throwing(10);
		for(int i = 0;i<16;i++) {
			bowling.throwing(0);
		}
		bowling.throwing(5);
		bowling.throwing(5);
		bowling.throwing(7);
		assertEquals(27,bowling.getScore());
	}
	
	@Test
	@DisplayName("Test ending strike")
	void testEndingStrike() {
		for(int i = 0;i<18;i++) {
			bowling.throwing(0);
		}
		bowling.throwing(10);
		bowling.throwing(4);
		bowling.throwing(5);
		assertEquals(19,bowling.getScore());
	}
	
	@Test
	@DisplayName("Test game ends")
	void testEnds() {
		for(int i = 0;i<20;i++) {
			bowling.throwing(0);
		}
		IndexOutOfBoundsException ex = assertThrows(IndexOutOfBoundsException.class,() -> bowling.throwing(0));
		assertEquals("The game has finished, you cant throw anymore.",ex.getMessage());
	}
	
	@Test
	@DisplayName("Test game ends Spare bonus")
	void testEndsSpare() {
		for(int i = 0;i<18;i++) {
			bowling.throwing(0);
		}
		bowling.throwing(5);
		bowling.throwing(5);
		bowling.throwing(0);
		IndexOutOfBoundsException ex = assertThrows(IndexOutOfBoundsException.class,() -> bowling.throwing(0));
		assertEquals("The game has finished, you cant throw anymore.",ex.getMessage());
	}
	
	@Test
	@DisplayName("Test game ends Strike bonus")
	void testEndsStrike() {
		for(int i = 0;i<18;i++) {
			bowling.throwing(0);
		}
		bowling.throwing(10);
		bowling.throwing(0);
		bowling.throwing(0);
		IndexOutOfBoundsException ex = assertThrows(IndexOutOfBoundsException.class,() -> bowling.throwing(0));
		assertEquals("The game has finished, you cant throw anymore.",ex.getMessage());
	}
	
}