package game;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class JTest {
	private ScoreSheet scoring;
	
	@Before
	public void setup() {
		scoring = new ScoreSheet();

	}
	@Test
	public void canGutterOut() {
		scoring.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		assertThat(scoring.score(), is(0));
	}
	
	@Test
	public void scoreOnes() {
		scoring.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
		assertThat(scoring.score(), is(20));
	}
	
	@Test
	public void getSpareplusextraThree() {
		
		scoring.roll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		assertThat(scoring.score(), is(16));
	}
	
	@Test
	public void getStrikePlusThrees() {
		scoring.roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		assertThat(scoring.score(), is(22));
	}
	
	@Test
	public void perfectGame() {
		scoring.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
		assertThat(scoring.score(), is(300));
	}
	
}
