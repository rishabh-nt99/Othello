package source;

import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String args[])throws IOException {
		System.out.println("                Hello! Welcome to Othello!!!");
		System.out.println("============================================================");
		Controller pc = new Controller();
		pc.StartGame();
	}
}	
