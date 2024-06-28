package es.codeurjc.ais.bowling;

public class Bowling{
	
	private int score = 0;
	private int previousThrow = 0;
	private int turn = 0;
	private boolean spare = false;
	
	public void throwing(int pins) {
		if( pins < 0) {
			throw new IllegalArgumentException("Number must be greater than zero");
		}
		if( pins > 10) {
			throw new IllegalArgumentException("Number must be smaller than ten");
		}
		
		//Any throw
		
		//Sum score
		score += pins;
		if(spare)  {
			score += pins;
		}

		//Second throw
		if(turn == 1) {
			if( pins + previousThrow > 10) {
				throw new IllegalArgumentException("You cant throw more than 10 pins per turn");
			}
			
			//Disable spare bonus
			spare = false;
			
			//Check for spare
			if(pins + previousThrow == 10) {
				spare = true;
			}
		}
		
		//Change turn
		turn++;
		turn%=2;
		previousThrow = pins;
	}
	
	public int getScore() {
		return score;
	}
	
}