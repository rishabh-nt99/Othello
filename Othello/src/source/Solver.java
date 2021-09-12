package source;

import java.util.ArrayList;
import java.util.List;

public class Solver {
	BoardState bs;
	int[][] board;
	int size;
	
	public Solver(BoardState bs_) {
		size= bs_.getBoardSize();
		board=bs_.getBoard();
		bs=bs_;
	}
	public boolean solveL(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		int toMatch = cp * -1;
		
		for(int i=c-1; i>=0; i--) {
			if(board[r][i]==cp) {
				return true;
			}
		}
		return false;
	}
	public boolean solveR(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		int toMatch = cp * -1;
		
		for(int i=c+1; i<size; i++) {
			if(board[r][i]==cp) {
				return true;
			}
		}
		return false;
	}
	public boolean solveT(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		int toMatch = cp * -1;
		
		for(int i=r-1; i>=0; i--) {
			if(board[i][c]==cp) {
				return true;
			}
		}
		return false;
	}
	public boolean solveB(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		int toMatch = cp * -1;
		
		for(int i=r+1; i<size; i++) {
			if(board[i][c]==cp) {
				return true;
			}
		}
		return false;
	}
	public boolean solveTR(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		int toMatch = cp * -1;
		
		for(int i=r-1, j=c+1; i>=0 && j<size; i--, j++) {
			if(board[i][j]==cp) {
				return true;
			}
		}
		return false;
	}
	public boolean solveTL(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		int toMatch = cp * -1;
		
		for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--) {
			if(board[i][j]==cp) {
				return true;
			}
		}
		return false;
	}
	public boolean solveBR(Move m, int cp) {
		int r= m.getRow();
		int c = m.getCol();
		
		int toMatch = cp * -1;
		
		for(int i=r+1, j=c+1; i<size && j<size; i++, j++) {
			if(board[i][j]==cp) {
				return true;
			}
		}
		return false;
	}
	public boolean solveBL(Move m, int cp) {
		int r= m.getRow();
		int c = m.getCol();
		
		int toMatch = cp * -1;
		
		for(int i=r+1, j=c-1; i<size && j>=0; i++, j--) {
			if(board[i][j]==cp) {
				return true;
			}
		}
		return false;
	}
	
	public boolean solveMain(String s, Move m , int cp) {
		
		if(s.equalsIgnoreCase("L")) {
			if(solveL(m, cp))
				return true;
		}
		else if(s.equalsIgnoreCase("R")) {
			if(solveR(m, cp))
				return true;
		}
		else if(s.equalsIgnoreCase("T")) {
			if(solveT(m, cp))
				return true;
		}
		else if(s.equalsIgnoreCase("B")) {
			if(solveB(m, cp))
				return true;
		}
		else if(s.equalsIgnoreCase("TR")) {
			if(solveTR(m, cp))
				return true;
		}
		else if(s.equalsIgnoreCase("TL")) {
			if(solveTL(m, cp))
				return true;
		}
		else if(s.equalsIgnoreCase("BR")) {
			if(solveBR(m, cp))
				return true;
		}
		else if(s.equalsIgnoreCase("BL")) {
			if(solveBL(m, cp))
				return true;
		}
		
		return false;
	}
	
}
