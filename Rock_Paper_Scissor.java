package com.task;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
public class Rock_Paper_Scissor
{
	static Scanner sc=new Scanner(System.in);
	static Random r=new Random();
	static int userCount,computerCount,matchCount,drawCount;
	static void start()
	{
		System.out.println("1.Start Game\n2.Statistics\n3.exit");
		System.out.println("======Select Your Choice======");
		int choice=sc.nextInt();
		switch(choice)
		{
			case 1: 
				userChoice();
				break;
			case 2:
				System.out.println("Number of matches Played : "+matchCount);
				System.out.println("Number of matches Won by You:"+userCount);
				System.out.println("Number of matches Won by Computer:"+computerCount);
				System.out.println("Number of matches Draw:"+drawCount);
				start();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				start();		
		}
	}
		
	static void userChoice()
	{
		System.out.println("1.Rock\n2.Paper\n3.Scissor");
		System.out.println("Select your option : ");
		int option = sc.nextInt();
		switch(option)
		{
			case 1:
				System.out.println("you selected Rock");
				computerChoice(option);
				break;
			case 2:
				System.out.println("you selected Paper");
				computerChoice(option);
				break;
			case 3:
				System.out.println("you selected Scissor");
				computerChoice(option);
				break;
			default:
		}
	}
	
	static void computerChoice(int option)
	{
		int rand_num = r.nextInt(3);
		if(rand_num==0)
		{
			System.out.println("Computer selected Rock");
			result(option,rand_num);
		}
		else if(rand_num==1)
		{
			System.out.println("Computer selected paper");
			result(option,rand_num);
		}
		else
		{
			System.out.println("computer selected Scissor");
			result(option,rand_num);
		}
	}
	
	static void result(int option,int rand_num)
	{
		if(option==1 && rand_num==0 || option==2 && rand_num==1 || option==3 && rand_num==2)
		{
			System.out.println("Match is Draw");
			matchCount++;
			drawCount++;
			start();
		}
		else if(option==1 && rand_num==2 || option==3 && rand_num==1 || option==2 && rand_num==0)
		{
			System.out.println("You won the Match");
			matchCount++;
			userCount++;
			start();
		}
		else
		{
			System.out.println("Computer won the Match");
			matchCount++;
			computerCount++;
			start();
		}
		
	}
	public static void main(String[] args)
	{
		start();
	}

}
