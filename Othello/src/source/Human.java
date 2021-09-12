package source;
import java.util.*;

public class Human extends Player {
	int isPlaying;
	public Human(String coins) {
		if(coins.equalsIgnoreCase("white")) {
			isPlaying = 1;
		}
		else {
			isPlaying = -1;
		}
	}
	
	@Override
	public Move getMove() {
		int r,c; 
		Move m = null;
		Scanner sc = new Scanner(System.in);
		BoardState bs = BoardState.getInstance();
		System.out.println("Your Move (enter -1, -1 to forfeit)"); 
		try {
			System.out.println("Enter row: ");
			r = sc.nextInt();
			System.out.println("Enter col: ");
			c = sc.nextInt();
			if(c == -1 && r ==-1) {
				exitGame();
				return getMove();
			}
			m = new Move(r, c);
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("Wrong Input Try Again");
			m = getMove();
		}
		return m;
	}
	
	public void exitGame() {
		System.out.println("Are you sure you want to exit the game?");
		System.out.println("Press Y to leave N to stay.");
	
		Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().charAt(0);
		
		if(ch=='Y' || ch=='y') {
			System.out.println("====================================");
			System.out.println("============You Forfeit!============");
			System.out.println("========Game Over!You Lose!=========");
			System.out.println("====================================");
			System.exit(0);
			
		}
		else if(ch=='N' || ch =='n') {
			System.out.println("Continued.");
			return;
		}
		else {
			exitGame();
		}
		
	}

}
