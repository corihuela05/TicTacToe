import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static ArrayList<Integer> playerPositions=new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions=new ArrayList<Integer>();
		public static void main(String[] args) {
			
			// TODO Auto-generated method stub
			char[][] gameBoard= {{' ','|' ,' ','|',' '},
					{'-' ,'+' ,'-' ,'+','-'},
					{' ','|' ,' ','|',' '},
					{'-' ,'+' ,'-', '+' , '-'},
					{' ','|' ,' ','|',' '}};
			
			printGameBoard(gameBoard);	
			Scanner scan=new Scanner(System.in);
			while (true) {
				Scanner scan1=new Scanner(System.in);
				System.out.println("Enter Placement (1-9) :");
				int playerPos =scan1.nextInt();
				while (playerPositions.contains(playerPos)|| cpuPositions.contains(playerPos));
					System.out.println("Position taken! Enter another position");
				
				placePiece(gameBoard,playerPos,"player");
				
				Random rand= new Random();
				int cpuPos= rand.nextInt(9)+1;
				while (playerPositions.contains(cpuPos)|| cpuPositions.contains(cpuPos));
					System.out.println("Position taken! Enter another position");
				
				
				placePiece(gameBoard,cpuPos,"cpu");
				
				printGameBoard(gameBoard);
				
				String result= checkWinner();
				System.out.println(result);
			}
			
		}
		
		
		public static void printGameBoard(char[][] gameBoard) {
		 for (char[] row : gameBoard) {
			 for (char c : row ) {
				 System.out.print(c);
			 }
			 System.out.println();
		}
}
		
		public static void placePiece(char[][] gameBoard, int pos,String user) {
		char symbol=' ';
		
		if (user.equals("player")){
			symbol='X';
			playerPositions.add(pos);
			
			
		}
		else if (user.equals("cpu")) {
			symbol ='O';
			cpuPositions.add(pos);
			
		}
		switch(pos) {
			case 1:
				gameBoard[0][0]=symbol;
				break;
			case 2:
				gameBoard[0][2]=symbol;
				break;
			case 3:
				gameBoard[0][4]=symbol;
				break;
			case 4:
				gameBoard[2][0]=symbol;
				break;
			case 5:
				gameBoard[2][2]=symbol;
				break;
			case 6:
				gameBoard[2][4]=symbol;
				break;
			case 7:
				gameBoard[4][0]=symbol;
				break;
			case 8:
				gameBoard[4][2]=symbol;
				break;
			case 9:
				gameBoard[4][4]=symbol;
				break;
			default:
				break;
			//printGameBoard(gameBoard);
	}
		}

	public static String checkWinner() {
	
	List topRow=Arrays.aslist(1,2,3);
	List midRow=Arrays.aslist(4,5,6);
	List bottomRow=Arrays.aslist(7,8,9);
	List leftCol=Arrays.aslist(1,2,3);
	List midCol=Arrays.aslist(2,5,8);
	List rightCol=Arrays.aslist(3,6,9);
	List firstCross=Arrays.aslist(1,5,9);
	List secondCross=Arrays.aslist(7,5,3);
	
	List<List>winning=new ArrayList<List>();
	winning.add(topRow);
	winning.add(midRow);
	winning.add(bottomRow);
	winning.add(leftCol);
	winning.add(rightCol);
	winning.add(firstCross);
	winning.add(secondCross);
	
	for (List l: winning) {
		if (playerPositions.containsAll(l)){
			return "Congrats you won!";
		} else if (cpuPositions.contains(l)){
			return "CPU Wins! Play again!";
		}
		else if (cpuPositions.size()+ playerPositions.size()==9){
			return "Its a tie";
		}
	}
		
	return "";
	}
}

