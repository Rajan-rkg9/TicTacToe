
public class TicTacToe {
	 static char board[]= new char[10];  
	public static void main(String[] args) {
		printBoard();
		assignEmptyBoard();
	}
	public static void printBoard() {
	System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
	System.out.println("|-----------|");
	System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
	System.out.println("|-----------|");
	System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
	}
	static void assignEmptyBoard()
	{
		for(int a =0 ; a<9 ; a++) 
		{
			board[a+1] = ' ' ;
		}
	}
}
