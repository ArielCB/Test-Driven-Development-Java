package es.codeurjc.ais.bowling;

public class Bowling{
	
	private int score=0;
	
	public void throwing(int pins) {
		if( pins < 0) {
			throw new IllegalArgumentException("Number must be greater than zero");
		}
		if( pins > 10) {
			throw new IllegalArgumentException("Number must be smaller than ten");
		}
		score += pins;
	}
	
	public int getScore() {
		return score;
	}
	
}