import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		createBoard();
		System.out.println("Enter letter X or O");
		Scanner scanner = new Scanner(System.in);
		char userInput = scanner.next().charAt(0);
		chooseLetter(userInput);
	} 
	/**
	 * UC1
	 * @return
	 */
	public static char[] createBoard() {
		 char board[]= new char[10]; 
		 for(int space =1; space<=9 ; space++)
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
  
    
}