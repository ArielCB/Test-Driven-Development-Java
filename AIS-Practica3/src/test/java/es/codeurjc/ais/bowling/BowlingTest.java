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
	@DisplayName("Test pins mayor que 0")
	void testPins0() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->bowling.throwing(-1));
		assertEquals("Number must be greater than zero", ex.getMessage());
	}
	
	@Test
	@DisplayName("Test pins menor que 10")
	void testPins10() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->bowling.throwing(11));
		assertEquals("Number must be smaller than ten", ex.getMessage());
	}
	
	@Test
	@DisplayName("Test score = tiradas anteriores")
	void testGetScore() {
		bowling.throwing(4);
		bowling.throwing(5);
		bowling.throwing(0);
		bowling.throwing(2);
		assertEquals(11,bowling.getScore());
	}
	
	@Test
	@DisplayName("Test score = tiradas anteriores(2)")
	void testGetScore1() {
		bowling.throwing(3);
		bowling.throwing(3);
		bowling.throwing(1);
		bowling.throwing(7);
		assertEquals(14,bowling.getScore());
	}
	
}