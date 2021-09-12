package source;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Computer extends Player{
	int isPlaying;
	Strategy st;
	BoardState bs;
	public Computer(String coins, int difficulty, BoardState bs_) {
		bs=bs_;
		if(coins.equalsIgnoreCase("white")) {
			isPlaying = 1;
		}
		else {
			isPlaying = -1;
		}
		if(difficulty==1) {
			st = new RandomMove();
		}
		else {
			st = new LocalBestMove();
		}
	}
	@Override
	public Move getMove() {
		ArrayList<Move> validMoves= getValidMoves();
		Move m = st.getBestMove(validMoves, isPlaying, bs);
		return m;
	}
	
	private ArrayList<Move> getValidMoves() {
		ArrayList<Move> validMoves = new ArrayList<Move>(); 
		Game g = Game.getInstance();
		validMoves = g.getValidMoves(isPlaying);
		return validMoves;
	}	
}
