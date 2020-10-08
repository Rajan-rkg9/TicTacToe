import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		createBoard();	
	} 
	/**
	 * UC1
	 * @return
	 */
	public static char[] createBoard() {
		 char board[]= new char[10]; 
		 for(int space =0; space<10 ; space++)
			 board[space] = ' ';
	     return board;
	}
	
	
	
}
