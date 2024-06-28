package es.codeurjc.ais.bowling;

public class Bowling{
	
	private int score = 0;
	private int previousThrow = 0;
	private int turn = 0;
	private boolean spare = false, strike1 = false, strike2 = false;
	
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
		if(strike2) {
			score += pins;
		}
		if(strike1) {
			score += pins;
		}

		//First throw
		if(turn == 0) {
			
			//Check strike
			if(pins == 10) {
				if(strike1) {
					strike2 = true;
				}
				strike1 = true;
				
				//Disable spare bonus
				spare = false;
				
				turn++;
			}
		}
		
		//Second throw
		else {
			if( pins + previousThrow > 10) {
				throw new IllegalArgumentException("You cant throw more than 10 pins per turn");
			}
			
			//Disable bonus
			spare = false;
			if(strike1) {
				strike2 = true;
			}
			else {
				strike2 = false;
			}
			strike1 = false;
			
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