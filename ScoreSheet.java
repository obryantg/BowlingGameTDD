package game;

public class ScoreSheet {
	private int roll = 0;
	private int[] rolls = new int[21];
	
	public void roll(int...rolls) {
		for (int pinsDown : rolls) {
			roll(pinsDown);
		}
	}
	
	public void roll(int pinsDown) {
		rolls[roll++] = pinsDown;
	}

	public int score() {
		int score = 0;
		int frameRoll = 0;
		for (int frame= 0; frame < 10; frame++) {
			if (isStrike(frameRoll)) {
				score += 10 + rolls[frameRoll + 1] + rolls[frameRoll + 2];
				frameRoll++;
			} else if (isSpare(frameRoll)) {
				//rule for spare;
				score += 10 + rolls[frameRoll + 2];
				frameRoll += 2;
			} else {
				score += rolls[frameRoll] + rolls[frameRoll + 1];
				frameRoll+= 2;
			}
		
		}
		return score;
	}
	
	private boolean isStrike(int frameRoll){
		return rolls[frameRoll] == 10;
	}
	private boolean isSpare(int frameRoll) {
		return rolls[frameRoll] + rolls[frameRoll + 1]== 10;
	}

}
