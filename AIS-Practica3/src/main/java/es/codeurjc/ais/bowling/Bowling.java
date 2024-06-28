package es.codeurjc.ais.bowling;

public class Bowling{
	
	private int score = 0;
	private int previousThrow = 0;
	private int turn = 0;
	
	public void throwing(int pins) {
		if( pins < 0) {
			throw new IllegalArgumentException("Number must be greater than zero");
		}
		if( pins > 10) {
			throw new IllegalArgumentException("Number must be smaller than ten");
		}
		if(turn ==1 && previousThrow+pins>10) {
			throw new IllegalArgumentException("You cant throw more than 10 pins per turn");
		}
		
		score += pins;
		previousThrow = pins;
		
		//Cambio de turno
		turn++;
		turn%=2;
	}
	
	public int getScore() {
		return score;
	}
	
}