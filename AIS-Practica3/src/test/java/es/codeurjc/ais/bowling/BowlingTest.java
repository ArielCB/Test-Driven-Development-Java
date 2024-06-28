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
	void testPins0() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->bowling.throwing(-1));
		assertEquals("Number must be greater than zero", ex.getMessage());
	}
	
}