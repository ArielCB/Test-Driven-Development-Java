package es.codeurjc.ais.bowling;

public class Bowling{
	
	
	public void throwing(int pins) {
		if( pins < 0) {
			throw new IllegalArgumentException("Number must be greater than zero");
		}
		throw new IllegalArgumentException("Number must be smaller than ten");
	}
	
	public int getScore() {
		return 0;
	}
	
}