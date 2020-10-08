import java.util.Scanner;

public class TicTacToe {
	static Scanner scanner = new Scanner(System.in);
	static final int TAILS = 0;
	static final int HEADS = 1;
	static final String USER = "USER";
	static final String COMPUTER = "COMPUTER";
	public static void main(String[] args) {
		char board[] =createBoard();
		System.out.println("Enter letter X or O");
		char userInput = scanner.next().charAt(0);
		char input = chooseLetter(userInput);
		showBoard();
		desiredLocation(board , input); 
    	freeOrNot(board , input);
    	makeMove(input,board);
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
    public static char chooseLetter(char userInput)
		{
			if(userInput == 'X')
			{
			System.out.println("Player has chosen " + userInput + " and Computer has letter O");
			}
			else
			System.out.println("Player has chosen " + userInput + " and Computer has letter X");
			return userInput;
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
    /**
     * UC4
     * @param position
     * @return
     */
    public static int desiredLocation(char board[] ,char input) {
    	int index = 1 ,flag = 0;
    	while(index!=10)
    	{
    		System.out.println("Enter the index from 1 to  9 to make the move :");
        	int index1 = scanner.nextInt();
    		if(board[index]  == ' ' && index == index1)
    		{
    			makeMove( input , board);
    			flag = 1;
    		}
    		if(flag ==1 )
    			break;
    	}
    	return index;
    }
    /**
     * UC4
     * @return
     */
    public static boolean freeOrNot(char board[] ,char input) {
    	int position = desiredLocation(board , input);
    	if(board[position]== ' ')
    	return true;
    	else
    	return false;
    	}
    /**
     * UC5
     * @param input
     */
    public static char[] makeMove(char input ,char board[]) {
    	int position = desiredLocation(board , input);
    	if(freeOrNot(board , input))
    		board[position] = input;
    		return board;
    }
    
}
