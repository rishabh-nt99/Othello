package source;

import java.util.ArrayList;
public interface Strategy {
	public Move getBestMove(ArrayList<Move> validMoves, int curPiece, BoardState bs_);
}
