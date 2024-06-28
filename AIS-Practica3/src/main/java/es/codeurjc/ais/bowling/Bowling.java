package es.codeurjc.ais.bowling;

public class Bowling{
	
	private int score = 0;
	private int previousThrow = 0;
	private int turn = 0, frame = 1;
	private boolean spare = false, strike1 = false, strike2 = false;
	private boolean finalBonus = false;
	
	public void throwing(int pins) {
		if( pins < 0) {
			throw new IllegalArgumentException("Number must be greater than zero");
		}
		if( pins > 10) {
			throw new IllegalArgumentException("Number must be smaller than ten");
		}
		if(frame > 10) {
			throw new IndexOutOfBoundsException("The game has finished, you cant throw anymore.");
		}
		
		//Any throw
		
		//Sum score
		score += pins;
		if(!finalBonus) {
			if(spare)  {
				score += pins;
			}
			if(strike2) {
				score += pins;
			}
			if(strike1) {
				score += pins;
			}
		}
		else {
			frame++;
		}
		
		//First throw
		if(turn == 0) {
			
			//Check strike
			if(pins == 10) {

				//Disable bonus
				spare = false;
				strike2 = false;
				
				if(strike1) {
					strike2 = true;
				}
				strike1 = true;
				
				//Last turn
				if(frame == 10) {
					finalBonus = true;
					frame-=2;
				}
				
				//Pass Frame
				turn++;
				frame++;
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
				
				//Last turn
				if(frame == 10) {
					finalBonus = true;
					frame--;
				}
			}
			
			//Pass frame
			frame++;
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