package source;
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Game {
	
	private boolean blackToMove; //tracking which players turn is it, 1 or 2
	private Player playerOne;
	private Player playerTwo;
	private BoardState bs;
	private ArrayList<Move> whiteValidMoves;
	private ArrayList<Move> blackValidMoves;
	
	private static Game theGame = new Game();
	
	private Game() {
		
	}
	public static Game getInstance() {
		return theGame;
	}
	public void setUpGame(int boardType, int gameType, int diff) {
		bs = BoardState.getInstance();
		bs.setBoardSize(boardType);
		bs.resetState(); //every time we start a new game by creating an object of Game we get the instance of boardState and reset it. 
		
		blackToMove = true; //game starts with black to move
		
		switch(gameType) {
			case 1: //player vs computer
				playerOne = new Human("black");
				switch(diff){
				case 1: playerTwo=new Computer("white", 1, bs);
						break;
				case 2: playerTwo=new Computer("white", 2, bs);
						break;
				}
				break;
			case 2: 
				playerOne = new Human("black");
				playerTwo = new Human("white");
				break;
			default:
				System.out.println("WrongInput");
		}	
		
		whiteValidMoves = new ArrayList<Move>();
		blackValidMoves = new ArrayList<Move>();
		
		setValidMoves();
		bs.printBoard();
		startGame();
	}
	
	public void printValidMoves(String player) {
		ArrayList<Move> vm;
		String toPrint;
		if(player.equalsIgnoreCase("black")) {
			vm=blackValidMoves;
			toPrint="Valid Moves P1 (X): ";
		}
		else {
			vm = whiteValidMoves;
			toPrint="Valid Moves P2 (O): ";
		}
		System.out.print(toPrint);
		for(Move m: vm) {
			System.out.print("("+m.getRow()+", "+m.getCol()+")");
		}
		System.out.println();
	}
	public  void startGame() {
		while(validMovesLeft()) {
			
			if(!playerHasLegalMoves()) {
				blackToMove=!blackToMove;
				System.out.println("-----------------------------");
				System.out.println("No Legal Moves. Turn Skipped!");
				System.out.println("-----------------------------");
				continue;
			}
			Move m;
			
			if(blackToMove) {
				printValidMoves("black");
				m = playerOne.getMove();
				
			}
			else {
				//printValidMoves("white");
				if(playerTwo instanceof Computer) {
					int randomNum = ThreadLocalRandom 
				            .current() 
				            .nextInt(0, 4 + 1); 
					System.out.println("---------------------");
					System.out.println("Computer is thinking!");
					System.out.println("---------------------");
					try {
					    TimeUnit.SECONDS.sleep(randomNum);
					} catch (InterruptedException ie) {
					    Thread.currentThread().interrupt();
					}
				}
				else {
					printValidMoves("white");
				}
				m = playerTwo.getMove();
			}
			
			if(isLegal(m)) {
				playMove(m);
				new cmdMakeMove().execute(m);
				blackToMove= !blackToMove;
				setValidMoves();
				bs.printBoard();
				continue;
			}
			else {
				System.out.println("------------------------------");
				System.out.println("Illegal Move! Make a new Move.");
				System.out.println("------------------------------");
			}
				
		}
		gameOver();
	}
	public ArrayList<Move> getValidMoves(int player) {
		if(player == -1) {
			return blackValidMoves;
		}
		else {
			return whiteValidMoves;
		}
	}
	private boolean validMovesLeft() {
		if(whiteValidMoves.size()>0 || blackValidMoves.size()>0) {
			return true;
		}
		return false;
	}
	
	private boolean playerHasLegalMoves() {
		if(blackToMove) {
			if(blackValidMoves.size() >0)
				return true;
			else
				return false;
		}
		else {
			if(whiteValidMoves.size() >0)
				return true;
			else
				return false;
		}
	}
	
	public boolean isLegal(Move m) {
		ArrayList<Move> vms;
		if(blackToMove) {
			vms = blackValidMoves;
		}
		else {
			vms = whiteValidMoves;
		}
		for(Move vm : vms) {
			if(m.getRow() == vm.getRow() && m.getCol() == vm.getCol())
				return true;
		}
		return false;
	}
	
	
	public void setValidMoves(){
		int curPiece;
		ArrayList<Move> vm;
		vm = blackValidMoves;
		curPiece = -1;
		vm.clear();
		for(int i=0;i<bs.getBoardSize();i++) {
			for(int j=0;j<bs.getBoardSize();j++) {
				Move m = new Move(i,j);
				if(isLegal(m, curPiece)) {
					vm.add(m);
				}
			}
		}
		
		vm =whiteValidMoves;
		curPiece = 1;
		vm.clear();
		for(int i=0;i<bs.getBoardSize();i++) {
			for(int j=0;j<bs.getBoardSize();j++) {
				Move m = new Move(i,j);
				if(isLegal(m, curPiece)) {
					vm.add(m);
				}
			}
		}
	}
	
	public void playMove(Move m) {
		
		int curPiece;
		if(blackToMove) {
			curPiece = -1;
		}
		else {
			curPiece =1;
		}
		ToChange tc = new ToChange(bs);
		ArrayList<String> neg = getValidNeighbors(m, curPiece);
		if(neg.size()>0) {
			List<int[]> toFlip = tc.getFlipped(neg, m, curPiece);
			bs.setPiece(toFlip, m, curPiece);
		}
	}
	
	public void gameOver() {
		Controller.gameOver(bs.getScore());
		bs.resetState();
		System.exit(0);
	}
	
	public ArrayList<String> getValidNeighbors(Move m, int cp) {
		int r = m.getRow();
		int c= m.getCol();
		int size =bs.getBoardSize();
		int toMatch= cp*-1;
		int[][] board = bs.getBoard();
		ArrayList<String> result = new ArrayList<String>();
		
		//left
		if(c-1>=0) {
			if(board[r][c-1]==toMatch) 
				result.add("L");	
		}
		//right
		if(c+1<size) {
			if(board[r][c+1]==toMatch) 
				result.add("R");
		}
		//top
		if(r-1>=0) {
			if(board[r-1][c]==toMatch) 
				result.add("T");
		}
		//bottom
		if(r+1<size) {
			if(board[r+1][c]==toMatch) 
				result.add("B");
		}
		
		//Top-right Diagonal
		if(r-1>=0 && c+1<size) {
			if(board[r-1][c+1]==toMatch) 
				result.add("TR");
		}
		
		//Top-left Diagonal
		if(r-1>=0 && c-1>=0) {
			if(board[r-1][c-1]==toMatch) 
				result.add("TL");
		}
		
		//Bottom-right Diagonal
		if(r+1<size && c+1<size) {
			if(board[r+1][c+1]==toMatch) 
				result.add("BR");

		}
		
		//Bottom-left Diagonal
		if(r+1<size && c-1>=0) {
			if(board[r+1][c-1]==toMatch) 
				result.add("BL");
		}
		
		return result;
	}
	
	
	public boolean isLegal(Move m, int curPiece) {
		int[][] board = bs.getBoard();
		
		if(board[m.getRow()][m.getCol()]!=0) //already a coin on the selected position
			return false;
		
		ArrayList<String> neg = getValidNeighbors(m, curPiece);
		
		if(neg.size()<=0) 
			return false;
		Solver sv = new Solver(bs);
		for(String s: neg) {
			if(sv.solveMain(s, m ,curPiece)) {
				return true;
			}	
		}
		return false;
	}
}
