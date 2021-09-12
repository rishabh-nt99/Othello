package source;

import java.util.ArrayList;
import java.util.List;

public class BoardState {
	private static BoardState theBS = new BoardState();
	private static int boardType;
	private static int board[][];
	private int size;
	private int[] score = new int[2];

	public static BoardState getInstance() {
		return theBS;
	}
	public void setBoardSize(int bs) {
			boardType = bs;
			switch(boardType) {
				case 1: //small
					board= new int[6][6];
					size=6;
					break;
				case 2: //medium
					board= new int[8][8];
					size=8;
					break;
				case 3: //large
					board= new int[10][10];
					size=10;
					break;
			}
			resetState();			
	}
	public void changeState(Move m) {
		//implement move making
		//board=bs.clone();
	}
	public void testState(int[][] testBS, int bt, int sz) {
		board = testBS.clone();
		boardType = bt;
		size= sz;
	}
	
	public void resetState() {
		for(int i =0;i<size;i++) {
			for(int j=0;j<size;j++) {
				board[i][j]=0;
			}
		}
		//setting center black pieces;
		board[size/2][size/2] = -1;
		board[size/2 -1][size/2 -1] = -1;
		
		//setting center white pieces;
		board[size/2 -1][size/2]= 1;
		board[size/2][size/2 -1] = 1;
		
		score[0]=2; //player 1 is black
		score[1]=2; //player 2 is white 
	}
	
	public int getBoardSize() {
		return size;
	}
	
	public int[][] getBoard(){
		return board;
	}
	public int[] getScore(){
		return score;
	}
	
	public void revertState(int[][] prevBoard, int[] sc) {
		board=prevBoard.clone();
		score = sc.clone();
	}
	public void calScore() {
		int p1=0;
		int p2=0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==-1) {
					p1++;
				}
				else if(board[i][j]==1) {
					p2++;
				}
			}
		}
		score[0]=p1;
		score[1]=p2;
	}
	
	public void printBoard() {
		System.out.println("-----------------------------------");
		System.out.println("Score (P1 v/s P2)= "+score[0]+" : "+score[1]);
		System.out.println("-----------------------------------");
		System.out.print("  ");
		for(int i=0;i<size;i++) {
			System.out.print(" "+i);
		}
		System.out.println();

		for(int i=0;i<size;i++) {
			System.out.print(i+" |");
			for(int j=0;j<size;j++) {
				char ch =' ';
				switch(board[i][j]) {
				case -1: 
					ch = 'X'; 
					break;
				case 0: 
					ch = '-'; 
					break;
				case 1: 
					ch = 'O'; 
					break;
				}
				System.out.print(ch+"|");
			}
			System.out.println();
			System.out.print("  ");
			for(int j = 0;j<size;j++) {
				System.out.print("==");
			}
			System.out.print("=");
			System.out.println();
		}
	}
	public void setPiece(List<int[]> toFlip, Move m, int cp) {
		int r=m.getRow();
		int c = m.getCol();
		board[r][c]=cp;
		
		for(int[] cor: toFlip) {
			r=cor[0];
			c=cor[1];
			board[r][c]=cp;
		}
		calScore();
	}
}
