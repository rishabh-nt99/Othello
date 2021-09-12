package source;

import java.util.Scanner;

public class Controller {

	public void StartGame() {
		printMenu();
	}
	
	public void printMenu() {
		int gt;
		int bt;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Press the corresponding number to choose item: ");
		
		System.out.println("Select Board Type: ");
		System.out.println("1) Small (6x6)");
		System.out.println("2) Medium (8x8)");
		System.out.println("3) Large (10x10)");
		System.out.println("4) To Exit the Game");
		
		
		while(true) {
			try {
				bt = sc.nextInt();
				if(bt==1 || bt==2 ||bt==3||bt==4) {
					break;
				}
				else {
					System.out.println("WRONG INPUT. TRY AGAIN!");
				}
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Wrong Input Error, Game Closed");
				System.exit(0);
			}
		}
		
		if(bt == 4) {
			System.out.println("Thank You. Game Closed.");
			System.exit(0);
		}

		System.out.println("Select Game Mode: ");
		System.out.println("1) Player v/s Computer");
		System.out.println("2) Player v/s Player");
		System.out.println("3) To Exit the Game");
		int diff = -1;
		while(true) {

			try {
				gt = sc.nextInt();
				if(gt==1) {
					diff=getDifficulty();
					break;
				}
				else if( gt == 2) {
					break;
				}
				else if(gt==3) {
					System.out.println("Thank you. Game Closed!");
					System.exit(0);
				}
				else {
					System.out.println("WRONG INPUT. TRY AGAIN!");
				}
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Wrong Input Error, Game Closed");
				System.exit(0);
			}
			
		}			
		Game game = Game.getInstance();
		game.setUpGame(bt, gt, diff);
	}
	
	public int getDifficulty() {
		Scanner sc=new Scanner(System.in);
		int diff;
		while(true) {
			System.out.println("Select Difficulty Level: ");
			System.out.println("1) Easy");
			System.out.println("2) Hard");
			try {
				 diff = sc.nextInt();
				
				if(diff==1 || diff ==2) {
					break;
				}
				else {
					continue;
				}
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Wrong Input Error, Game Closed");
				continue;
			}	
		}
		return diff;
	}
	
	public static void gameOver(int[] sc) {
		System.out.println("------------------------------------");
		System.out.println("-------------Game Over!-------------");
		System.out.println("------------------------------------");		

		System.out.println("-----------------------------------");
		System.out.println("Final Score: "+ sc[0]+ " : " + sc[1]);
		System.out.println("-----------------------------------");
		
		if(sc[0]>sc[1]) {
			System.out.println("-----------------------------------");
			System.out.println("----------Player 1 Wins!!----------");
			System.out.println("-----------------------------------");
		}
		else if(sc[0]==sc[1]) {
			System.out.println("-----------------------------------");
			System.out.println("----------It's a draw!!----------");
			System.out.println("-----------------------------------");
		}
		else {
			System.out.println("-----------------------------------");
			System.out.println("----------Player 2 Wins!!----------");
			System.out.println("-----------------------------------");
		}
		System.out.println();
	}
}
