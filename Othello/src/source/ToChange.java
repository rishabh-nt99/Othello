package source;

import java.util.ArrayList;
import java.util.List;

public class ToChange {
	BoardState bs = BoardState.getInstance();
	int[][] board = bs.getBoard();
	int size = bs.getBoardSize();
	
	public ToChange(BoardState bs_) {
		bs = BoardState.getInstance();
		board = bs_.getBoard();
		size = bs_.getBoardSize();
	}
	public List<int[]> getFlipped(ArrayList<String> neg, Move m, int cp) {
		List<int[]> toFlip = new ArrayList<int[]>();
		for(String s: neg) {
			if(s.equalsIgnoreCase("L")) {
				List<int[]> result= getToFlipL(m, cp);
				if(result!=null) {
					for(int[] n: result) {
						toFlip.add(n);
					}
				}
			}
			else if(s.equalsIgnoreCase("R")) {
				List<int[]> result= getToFlipR(m, cp);
				if(result!=null) {
					for(int[] n: result) {
						toFlip.add(n);
					}
				}
			}
			else if(s.equalsIgnoreCase("T")) {
				List<int[]> result= getToFlipT(m, cp);
				if(result!=null) {
					for(int[] n: result) {
						toFlip.add(n);
					}
				}
			}
			else if(s.equalsIgnoreCase("B")) {
				List<int[]> result= getToFlipB(m, cp);
				if(result!=null) {
					for(int[] n: result) {
						toFlip.add(n);
					}
				}
			}
			else if(s.equalsIgnoreCase("TR")) {
				List<int[]> result= getToFlipTR(m, cp);
				if(result!=null) {
					for(int[] n: result) {
						toFlip.add(n);
					}
				}
			}
			else if(s.equalsIgnoreCase("TL")) {
				List<int[]> result= getToFlipTL(m, cp);
				if(result!=null) {
					for(int[] n: result) {
						toFlip.add(n);
					}
				}
			}
			else if(s.equalsIgnoreCase("BR")) {
				List<int[]> result= getToFlipBR(m, cp);
				if(result!=null) {
					for(int[] n: result) {
						toFlip.add(n);
					}
				}
			}
			else if(s.equalsIgnoreCase("BL")) {
				List<int[]> result= getToFlipBL(m, cp);
				if(result!=null) {
					for(int[] n: result) {
						toFlip.add(n);
					}
				}
			}
		}
		return toFlip;
		
	}
	
	public List<int[]> getToFlipL(Move m, int cp) {
		int r=m.getRow(); 
		int c = m.getCol();
		
		List<int[]> result = new ArrayList<int[]>();
		int toMatch = cp * -1;
		
		for(int i=c-1; i>=0; i--) {
			if(board[r][i]==cp) {
				return result;
			}
			else {
				int[] temp = {r,i};
				result.add(temp);
			}
		}
		return null;
	}
	public List<int[]> getToFlipR(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		List<int[]> result = new ArrayList<int[]>();
		int toMatch = cp * -1;
		
		for(int i=c+1; i<size; i++) {
			if(board[r][i]==cp) {
				return result;
			}
			else {
				int[] temp = {r,i};
				result.add(temp);
			}
		}
		return null;
	}
	public List<int[]> getToFlipT(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		List<int[]> result = new ArrayList<int[]>();
		int toMatch = cp * -1;
		
		for(int i=r-1; i>=0; i--) {
			if(board[i][c]==cp) {
				return result;
			}
			else {
				int[] temp = {i,c};
				result.add(temp);
			}
		}
		return null;
	}
	public List<int[]> getToFlipB(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		List<int[]> result = new ArrayList<int[]>();
		int toMatch = cp * -1;
		for(int i=r+1; i<size; i++) {
			if(board[i][c]==cp) {
				return result;
			}
			else {
				int[] temp = {i,c};
				result.add(temp);
			}
		}
		return null;
	}
	public List<int[]> getToFlipTR(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		List<int[]> result = new ArrayList<int[]>();
		int toMatch = cp * -1;
		
		for(int i=r-1, j=c+1; i>=0 && j<size; i--, j++) {
			if(board[i][j]==cp) {
				return result;
			}
			else {
				int[] temp = {i,j};
				result.add(temp);
			}
		}
		return null;
	}
	public List<int[]> getToFlipTL(Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		
		List<int[]> result = new ArrayList<int[]>();
		int toMatch = cp * -1;
		
		for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--) {
			if(board[i][j]==cp) {
				return result;
			}
			else {
				int[] temp = {i,j};
				result.add(temp);
			}
		}
		return null;
	}
	public List<int[]> getToFlipBR(Move m, int cp) {
		int r= m.getRow();
		int c = m.getCol();
		
		List<int[]> result = new ArrayList<int[]>();
		int toMatch = cp * -1;
		
		for(int i=r+1, j=c+1; i<size && j<size; i++, j++) {
			if(board[i][j]==cp) {
				return result;
			}
			else {
				int[] temp = {i,j};
				result.add(temp);
			}
		}
		return null;
	}
	public List<int[]> getToFlipBL(Move m, int cp) {
		int r= m.getRow();
		int c = m.getCol();
		
		List<int[]> result = new ArrayList<int[]>();
		int toMatch = cp * -1;
		
		for(int i=r+1, j=c-1; i<size && j>=0; i++, j--) {
			if(board[i][j]==cp) {
				return result;
			}
			else {
				int[] temp = {i,j};
				result.add(temp);
			}
		}
		return null;
	}
}
