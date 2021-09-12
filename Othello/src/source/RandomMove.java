package source;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMove implements Strategy{

	@Override
	public Move getBestMove(ArrayList<Move> validMoves, int curPiece, BoardState bs_) {
		// TODO Auto-generated method stub
		int i = validMoves.size() -1;
		
		Random rand;
		int randomNum = ThreadLocalRandom 
	            .current() 
	            .nextInt(0, i + 1); 

	    return validMoves.get(randomNum);
	}
	
}
