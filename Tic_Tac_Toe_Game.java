package test;

import java.util.Scanner;

public class Tic_Tac_Toe_Game
{
	static Scanner sc=new Scanner(System.in);
	public static char board[][];
	static Tic_Tac_Toe_Game currentPlayer;
    public String name;
	public char symbol;
	public Tic_Tac_Toe_Game(String name,char symbol)
	{
		this.name = name;
		this.symbol = symbol;
	}
	
	public static void start()
	{
		board=new char[3][3];
		makeEmptyBoard();
	}
	public static void makeEmptyBoard()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j]=' ';
			}			
		}
	}
	public static void displayBoard()
	{
		System.out.println("-------------");
		for(int i=0;i<board.length;i++)
		{
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("-------------");			
		}
	}
	public void makeMove()
	{
		System.out.println("Enter Row & column Numbers :");
		int row=sc.nextInt();
		int col=sc.nextInt();
		boolean k = isValid(row,col);
		if(k)
		{
			if(row>=0 && row<3 && col>=0 && col<3)
			{
				placeMark(row,col,symbol);
			}
			else
			{
				System.out.println(row+" and "+col+" are out of Board Size");
				System.out.println();
				makeMove();
			}
		}
		else
		{
			System.out.println(row+" and "+col+" are already Filled\n select another row and column");
			makeMove();
		}
	}
	public static void placeMark(int row,int col,char symbol)
	{
		if(row>=0 && row<3 && col>=0 && col<3)
		{
			board[row][col]=symbol;
		}
	}
	public static boolean isValid(int row,int col)
	{
		if(board[row][col]==' ')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	static boolean rowWinCheck()
	{
		for(int i=0;i<board.length;i++)
		{
			if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
			{
				return true;
			}
		}
		return false;
	}
	static boolean columnWinCheck()
	{
		for(int j=0;j<board.length;j++)
		{
			if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
			{
				return true;
			}
		}
		return false;
	}
	static boolean diagnolWinCheck()
	{
		if(board[0][0]!=' '&& board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]!=' '&& board[0][2]==board[1][1] && board[1][1]==board[2][0])
		{
			return true;
		}
		return false;
	}
	static boolean drawCheck()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				if(board[i][j]==' ')
				{
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args)
	{
		start();
		Tic_Tac_Toe_Game t1 = new Tic_Tac_Toe_Game("Reddy",'X');
		Tic_Tac_Toe_Game t2 = new Tic_Tac_Toe_Game("Prasad", 'O');
		currentPlayer = t1;
		while(true)
		{
			System.out.println(currentPlayer.name+"'s Turn");
			currentPlayer.makeMove();
			displayBoard();
			if(rowWinCheck() || columnWinCheck() || diagnolWinCheck())
			{
				System.out.println(currentPlayer.name+" Win the Game....");
				break;
			}
			else if(!drawCheck())
			{
				System.out.println("Match Draw");
				break;
			}
			else
			{
				if(currentPlayer==t1)
				{
					currentPlayer=t2;
				}
				else
				{
					currentPlayer=t1;
				}
			}
		}			
	}
	
}
