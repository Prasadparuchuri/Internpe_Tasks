package test;
import java.util.Scanner;
import java.util.Random;
public class Guessing_RandomNum
{
	public static Scanner sc=new Scanner(System.in);
	public static Random r=new Random();
	
	public static void play()
	{
		int random_Number=r.nextInt(101);
		int number=102;
		int count=0;
		check(random_Number,number,count);
	}
	public static void check(int random_Number,int number,int count)
	{
		while(number!=random_Number)
		{
			System.out.println("Enter a Number 0 to 100:");
			number=sc.nextInt();
			count++;
			result(random_Number,number,count);
		}
	}
	public static void result(int random_Number,int number,int count)
	{
		if(number == random_Number)
		{
			System.out.println("Wow! your gess is correct...");
			System.out.println("your guess the number in "+count+" Attempts");
			System.out.println();
			System.out.println("=====xxxxxxxxxxxxxxxxxxxx=====");
			System.out.println();
			playAgain();
		}
		else if(number>random_Number)
		{
			System.out.println("your guesss is Too High--Try Again");
			check(random_Number,number,count);
		}
		else
		{
			System.out.println("your guess is Too Low....Try Again");
			check(random_Number,number,count);
		}
	}
	public static void playAgain()
	{
		System.out.println("1.Play Again\n2.Exit");
		System.out.println("Select your Option");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			play();
			break;
		case 2:
			System.out.println("Game Terminated......");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Input....\nSelect Correct Option");
			playAgain();
		}
	}
	public static void main(String[] args)
	{
		play();
	}
}
