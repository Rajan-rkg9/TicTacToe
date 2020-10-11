import java.util.Scanner;


public class TicTacToe {
	static final int TAILS = 0;
	static final int HEADS = 1;
	static final String USER = "USER";
	static final String COMPUTER = "COMPUTER";
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		char board[] =createBoard();
		char computerLetter;
		System.out.println("Enter letter X or O");
		char userLetter = scanner.next().charAt(0);
		int movePosition = 0;
		int maxTurns = 9;
		if(userLetter == 'X')
			computerLetter='O';
		else
			computerLetter = 'X';
		chooseLetter(userLetter);    	
		String firstPlayer = whoPlaysFirst();
		
		//UC12
		String winner = "";
		while(maxTurns >0)
		{
			maxTurns--;
			if(firstPlayer.equals(USER)) 
			{
				showBoard(board);
			    movePosition = desiredLocation(board , userLetter); 
		    	checkPositionAvailable(board , userLetter);
		    	board = makeMove(userLetter,board);
		    	if(determineWin(board, userLetter).equals("WIN"))
		    		{
		    		winner = USER;
		    		break;
		    		}
		    	firstPlayer = COMPUTER;
			}
			else
			{
				showBoard(board);
		    	board = makeMove(computerLetter,board);
		    	if(determineWin(board, computerLetter).equals("WIN"))
		    	{
		    		winner = COMPUTER;
		    		break;
		    	}
		    	firstPlayer = COMPUTER;
			}
		}
		
		if(winner.equals(COMPUTER))
			System.out.println("Computer Won");
		else if(winner.equals(USER))
			System.out.println("User Won");
		else
			System.out.println("Game Drawn!!");
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
    public static char chooseLetter(char userLetter)
		{
			if(userLetter == 'X')
			{
			System.out.println("Player has chosen " + userLetter + " and Computer has letter O");
			}
			else
			System.out.println("Player has chosen " + userLetter + " and Computer has letter X");
			return userLetter;
		}
    /**
     * UC3
     * @param board 
     * 
     */
    public static void showBoard(char[] board) {
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
    public static int desiredLocation(char board[] ,char userLetter) {
    	int index = 1 ,flag = 0;
    	System.out.println("Enter the index from 1 to  9 to make the move :");
    	int index1 = scanner.nextInt();
    	while(index!=10)
    	{
    		if(board[index]  == ' ' && index == index1)
    		{
    			makeMove( userLetter , board);
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
    public static boolean checkPositionAvailable(char board[] ,char userLetter) {
    	int position = desiredLocation(board , userLetter);
    	if(board[position]== ' ')
    	return true;
    	else
    	return false;
    	}
    /**
     * UC5
     * @param userLetter
     */
    public static char[] makeMove(char userLetter ,char board[]) {
    	int position = desiredLocation(board , userLetter);
    	if(checkPositionAvailable(board , userLetter))
    		board[position] = userLetter;
    		showBoard(board);
    		return board;
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
    /**
     * UC7
     * @param board
     * @param userLetter
     * @return
     */
    public static String determineWin(char board[] , char userLetter) {
    	int index;
    	
    	 if((board[1] == userLetter && board[2] == userLetter && board[3] == userLetter)||
    	   (board[4] == userLetter && board[5] == userLetter && board[6] == userLetter)||
    	   (board[7] == userLetter && board[8] == userLetter && board[9] == userLetter)||
    	   (board[1] == userLetter && board[4] == userLetter && board[7] == userLetter)||
    	   (board[2] == userLetter && board[5] == userLetter && board[8] == userLetter)||
    	   (board[3] == userLetter && board[6] == userLetter && board[9] == userLetter)||
    	   (board[1] == userLetter && board[5] == userLetter && board[9] == userLetter)||
    	   (board[3] == userLetter && board[5] == userLetter && board[9] == userLetter))
    	 return "WIN";
    	 for (index =1 ; index <= 9; index++) {
 			if (board[index] != ' ')
 				continue;
 			else
 				break;
 		}
 		if (index == 9)
 			return "TIE";
 		else
 			return "TURN";
    }
    /**
	 * UC8
	 * @return
	 */
	public static int getIndexForSuccessfulMove(char[] board, char letter) {
		int index;
		for (index = 1; index <= 9; index++) {
			char[] dummyBoard = board;
			if (dummyBoard[index] == ' ') {
				dummyBoard[index] = letter;
				String status = determineWin(dummyBoard, letter);
				if (status.equals("WIN"))
					return index;
			} else
				continue;
		}
		return 0;
	}
	/**
	 * UC9
	 * @return
	 */
	public static int getIndexToBlockMove(char[] board, char letter) {
		int index;
		char dummyLetter = 'O';
		if(letter == dummyLetter)
			dummyLetter = 'X';
			
		for (index = 1; index <= 9; index++) {
			char[] dummyBoard = board;
			if (dummyBoard[index] == ' ') {
				dummyBoard[index] = dummyLetter;
				String status = determineWin(dummyBoard, dummyLetter);
				if (status.equals("WIN"))
					return index;
			} else
				continue;
		}
		return 0;
	}
	/**
	 *UC10
	 * @return
	 */
	public static char[] checkComputerTurn(char board[], char computerLetter) {
		int index = getIndexForSuccessfulMove(board, computerLetter);
		if (index != 0) {
			board = makeMove(computerLetter , board);
			return board;
		}
		index = getIndexToBlockMove(board, computerLetter);
		if (index != 0) {
			board = makeMove(computerLetter , board);
			return board;
		}
		index = findCorner(board);
		if (index != 0) {
			board = makeMove(computerLetter , board);
			return board;
		}
		if (checkPositionAvailable(board, computerLetter)) {
			board = makeMove(computerLetter , board);
			return board;
		} else {
			for (int side = 2; side <= 8; side++) {
				if (checkPositionAvailable(board, computerLetter)) {
					board = makeMove(computerLetter , board);
					break;
				}
				side++;
			}
			return board;
		}
	}

	public static int findCorner(char board[]) {

		if (board[1] == ' ')
			return 1;
		if (board[3] == ' ')
			return 3;
		if (board[7] == ' ')
			return 7;
		if (board[9] == ' ')
			return 9;
		else
			return 0;
	}
}
