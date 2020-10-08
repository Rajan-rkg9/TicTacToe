import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		createBoard();
		System.out.println("Enter letter X or O");
		Scanner scanner = new Scanner(System.in);
		char userInput = scanner.next().charAt(0);
		chooseLetter(userInput);
		showBoard();
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
    /**
     * UC2
     * @param letter
     */
    static void chooseLetter(char userInput)
		{
			if(userInput == 'X')
			{
			System.out.println("Player has chosen " + userInput + " and Computer has letter O");
			}
			else
			System.out.println("Player has chosen " + userInput + " and Computer has letter X");
		}
    /**
     * UC3
     * 
     */
    public static void showBoard() {
    	char board[]=createBoard();
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
	}
}
