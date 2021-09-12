package source;

import java.util.ArrayList;
import java.util.List;

public class LocalBestMove implements Strategy {

	@Override
	public Move getBestMove(ArrayList<Move> validMoves, int curPiece, BoardState bs_) {
		// TODO Auto-generated method stub
		Game g = Game.getInstance();
		int max=-1;
		Move bestMove = null;
		for(Move m: validMoves) {
			ArrayList<String> neg = g.getValidNeighbors(m, curPiece);
			ToChange tc = new ToChange(bs_);
			
			if(neg.size()>0) {
				List<int[]> toFlip = tc.getFlipped(neg, m, curPiece);
				if(toFlip.size()>max) {
					max = toFlip.size();
					bestMove = m;
				}
			}
		}
		return bestMove;
	}
}