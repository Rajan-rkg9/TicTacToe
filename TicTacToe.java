import java.util.Scanner;

public class TicTacToe {
	static final int TAILS = 0;
	static final int HEADS = 1;
	static final String USER = "USER";
	static final String COMPUTER = "COMPUTER";
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		char board[] =createBoard();
		System.out.println("Enter letter X or O");
		char userInput = scanner.next().charAt(0);
		char input = chooseLetter(userInput);
		showBoard();
		desiredLocation(board , input); 
    	freeOrNot(board , input);
    	makeMove(input,board);
    	whoPlaysFirst();
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
    	System.out.println("Enter the index from 1 to  9 to make the move :");
    	int index1 = scanner.nextInt();
    	while(index!=10)
    	{
    		if(board[index]  == ' ' && index == index1)
    		{
    			makeMove( input , board);
    			flag = 1;
    		}
    		if(flag ==1 )
    			break;
    		index++;
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
    public static void makeMove(char input ,char board[]) {
    	int position = desiredLocation(board , input);
    	if(freeOrNot(board , input))
    		board[position] = input;
    		showBoard();
    }
    /**
     * UC6
     * @return
     */
    public static String whoPlaysFirst() {
    	int outcome =(int)( Math.floor(Math.random() * 10) % 2);
    	if(outcome == TAILS)
    	{
    		System.out.println("Its tails!! User moves first.");
    		return USER;
    	}
    	else
    	{
    		System.out.println("Its tails!! User moves first.");
    		return COMPUTER;
    	}
    }
    
    
}
