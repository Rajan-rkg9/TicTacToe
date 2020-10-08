import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		createBoard();
		chooseLetter();	
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
	
	static void chooseLetter()
	{
		System.out.println("Enter letter X or O");
		Scanner scanner = new Scanner(System.in);
		char letter = scanner.next().charAt(0);
		if(letter == 'X')
		{
		System.out.println("Player has chosen " + letter + " and Computer has letter O");
		}
		else
		System.out.println("Player has chosen " + letter + " and Computer has letter X");
	}
	
}
